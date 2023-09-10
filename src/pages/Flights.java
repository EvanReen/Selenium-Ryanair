package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class Flights extends AbstractComponent {
	
	//constructor
	public Flights(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this); // Initialize WebElements using PageFactory
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver");
		// TODO Auto-generated constructor stub
	}
	
	public boolean isFlightsPageLoaded() {
        // Implement logic to verify that the flights page is loaded
        return driver.getCurrentUrl().contains("flights");
    }
	
	@FindBy(how=How.CSS,using= "flight-info-new[class='flight-card__info ng-tns-c487942061-19'] div[class='flight-info__middle-block body-l-lg body-l-sm']")
	WebElement departFlight;
	
	@FindBy(how=How.CSS,using= "flight-info-new[class='flight-card__info ng-tns-c487942061-12'] div[class='flight-info__middle-block body-l-lg body-l-sm']")
	WebElement destinationFlight;
	
	@FindBy(how=How.XPATH,using= "//th[@data-e2e='fare-card-regular']//div[@class='fare-table__fare-column-border']")
	WebElement regularOption;
	

    public void selectFlightOption() {
    	
    	departFlight.click();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	destinationFlight.click();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	regularOption.click();

    }

}
