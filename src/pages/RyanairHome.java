package pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractComponents.AbstractComponent;

public class RyanairHome extends AbstractComponent {
	
	//constructor
	public RyanairHome(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); // Initialize WebElements using PageFactory
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver");
    }
	
	//getting url 
	public void goToHomePage() {
        driver.get("https://www.ryanair.com/");
    }

    public boolean isHomePageLoaded() {
    	WebElement pageTitle = driver.findElement(By.xpath("//title[contains(text(),'Ryanair')]"));
        return pageTitle.isDisplayed();
    }
    
    @FindBy(how=How.ID,using="input-button__departure") 
   	WebElement departureAirport;
       
    @FindBy(how=How.ID,using="input-button__destination") 
   	WebElement destinationAirport;
       
    @FindBy(how=How.CSS,using="[data-ref='airport-item__name']")
    WebElement airport;
    
    @FindBy(how=How.CLASS_NAME,using="m-toggle__month")
    List<WebElement> monthWidget;
    
    @FindBy(how=How.CSS,using="\"[data-ref='datepicker-tabs__exact-dates'].datepicker-tabs__button\")")
    WebElement ExactdateWidget;
    
    @FindBy(how=How.CSS,using="[data-id='2023-10-11']")
    WebElement dateWidget;
   
    @FindBy(how=How.CSS,using="[data-id='2023-10-17']")
    WebElement returndateWidget;
    
    @FindBy(how=How.CSS,using="ry-counter.passengers-picker__passenger-type:nth-child(3) > div:nth-child(2) > div:nth-child(3)")
    WebElement addAdultsCounter;
    
    @FindBy(how=How.CSS,using=".passengers__confirm-button")
    WebElement done;
    
    @FindBy(xpath="//button[@aria-label='Search']")
    WebElement search;
    
    public void searchFlights() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	
    	//Select From Airports
		departureAirport.click();
		departureAirport.clear();
		departureAirport.sendKeys("Dublin");
	      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	      airport.click();
	      
	      
	    //Select To Airport
		destinationAirport.click();
		destinationAirport.clear();
		destinationAirport.click();
		destinationAirport.sendKeys("Barcelona");
	    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    	 // Wait for the dropdown options to appear
	        List<WebElement> dropdownOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[data-ref='airport-item__name']")));
	    	// Find the "Barcelona" option and click it, avoiding the "Anywhere" option
	        for (WebElement option : dropdownOptions) {
	            if (option.getText().equals("Barcelona")) {
	                option.click();
	                break; // Click "Barcelona" and exit the loop
	            }
	        }
	    	//airport.click();	    
	    	
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	    // Click the "Exact Dates" button
	    WebElement exactDatesButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-ref='datepicker-tabs__exact-dates'].datepicker-tabs__button")));
	    exactDatesButton.click();
	    //Select Departure Date
	      for(WebElement ele:monthWidget) {
			if(ele.getText().contains("Oct 11")) {
				ele.click();
			}
		}
	      
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      try {
	      	dateWidget.click();
	      }catch(StaleElementReferenceException e) {
	      	WebElement departDate = wait.until(ExpectedConditions.elementToBeClickable(dateWidget));
	  		departDate.click();
	  		
	      }
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Select Return Date
	      for(WebElement ele:monthWidget) {
			if(ele.getText().contains("Oct 17")) {
				ele.click();
			}
		}
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      try {
	    	  returndateWidget.click();
	      }catch(StaleElementReferenceException e) {
	      WebElement returnDate = wait.until(ExpectedConditions.elementToBeClickable(returndateWidget));
			returnDate.click();
	      }
	      
	    //Select no. of passengers
		WebElement adults = wait.until(ExpectedConditions.elementToBeClickable(addAdultsCounter));
		adults.click();
		
		done.click();
		
		// Click the search button
		search.click();
    }

}
