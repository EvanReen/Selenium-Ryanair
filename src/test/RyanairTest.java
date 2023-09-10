package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Bags;
import pages.Flights;
import pages.LoginPage;
import pages.Passenger;
import pages.RyanairHome;
import pages.SeatSelection;

public class RyanairTest {
	
	private WebDriver driver;
    private RyanairHome homePage;
    private Flights flightsPage;
    private LoginPage logInPage;
    private Passenger passengersPage;
    private SeatSelection seatsPage;
    private Bags bagsPage;

    @BeforeClass
    public void setUp() {
        
    	//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver");
    	// Set up WebDriver
        driver = new ChromeDriver();
        
        // Initialize Page Object classes
        homePage = new RyanairHome(driver);
        flightsPage = new Flights(driver);
        logInPage = new LoginPage(driver);
        passengersPage = new Passenger(driver);
        seatsPage = new SeatSelection(driver);
        bagsPage = new Bags(driver);
    }
    
    @Test(priority = 1)
    public void testRyanairBookingFlow() throws InterruptedException {
        
    	// Step 1: Open Ryanair home page
        homePage.goToHomePage();
        
      //Maximizes the browser window
    	driver.manage().window().maximize() ;
        //Assert.assertTrue(homePage.isHomePageLoaded(), "Ryanair home page is not loaded.");
    	
    	//driver.manage().deleteAllCookies();
    	WebElement acceptButton = driver.findElement(By.cssSelector("[data-ref='cookie.accept-all']"));
        acceptButton.click();
             
        Thread.sleep(5000);

        // step 2: Perform search
        homePage.searchFlights();
        
        Thread.sleep(5000);
         
        // Step 3: Select suggested flights (e.g., "Regular" option)
        Assert.assertTrue(flightsPage.isFlightsPageLoaded(), "Flights page is not loaded.");
        flightsPage.selectFlightOption();
        Thread.sleep(5000);

        // Step 4: Choose "Log in later"
        //Assert.assertTrue(logInPage.isLogInPageLoaded(), "Log in page is not loaded.");
        logInPage.chooseLogInLater();
        
        Thread.sleep(5000);

        // Step 5: Enter passenger details and click [Continue]
        //Assert.assertTrue(passengersPage.isPassengersPageLoaded(), "Passengers page is not loaded.");
        passengersPage.enterPassengerDetails();

        
        Thread.sleep(5000);
        
        //step 6: seats selection
        seatsPage.selectSeats();
        
        Thread.sleep(5000);
      //driver.manage().deleteAllCookies();
    	WebElement noThanks = driver.findElement(By.cssSelector(".enhanced-takeover-beta__product-dismiss-cta.ry-button--anchor-blue.ry-button--anchor"));
    	noThanks.click();
    	
    	Thread.sleep(5000);
        //Assert.assertTrue(bagsPage.isBagsPageLoaded(), "Bags page is not loaded.");
        
    }
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    
	public static void main(String[] args) {
        // Run the TestNG test class
    	// Create an instance of TestNG
        TestNG testNG = new TestNG();

        // Create a TestListenerAdapter to listen to test execution
        TestListenerAdapter listener = new TestListenerAdapter();
        testNG.addListener(listener);

        // Specify the classes you want to run as tests (your test case class)
        testNG.setTestClasses(new Class[]{RyanairTest.class});

        // Run the test suite
        testNG.run();

        // Print the results (optional)
        System.out.println("Total Passed Tests: " + listener.getPassedTests().size());
        System.out.println("Total Failed Tests: " + listener.getFailedTests().size());
        System.out.println("Total Skipped Tests: " + listener.getSkippedTests().size());
    }

}
