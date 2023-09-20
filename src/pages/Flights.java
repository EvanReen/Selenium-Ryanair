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
		// TODO Auto-generated constructor stub
	}
	
	public boolean isFlightsPageLoaded() {
		try {
			// Implement logic to verify that the flights page is loaded
			WebElement flightsHeading = driver.findElement(By.xpath("//span[normalize-space()='Flights']"));
		    return flightsHeading.isDisplayed();
		}catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }	    
    }
	
	@FindBy(how=How.CSS,using= "flight-info-new[class='flight-card__info ng-tns-c487942061-19'] div[class='flight-info__middle-block body-l-lg body-l-sm']")
	WebElement departFlight;
	
	@FindBy(how=How.CSS,using= "flight-info-new[class='flight-card__info ng-tns-c487942061-12'] div[class='flight-info__middle-block body-l-lg body-l-sm']")
	WebElement destinationFlight;
	
	@FindBy(how=How.XPATH,using= "//div[@class='fare-table__fare-column-border fare-table__fare-column-border--regu']")
	WebElement regularOption;
	

    public void selectFlightOption() {
    	
    	departFlight.click();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	destinationFlight.click();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	regularOption.click();

    }

}
