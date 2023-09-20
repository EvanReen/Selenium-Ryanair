package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class Passenger extends AbstractComponent{
	
	//constructor
		public Passenger(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this); // Initialize WebElements using PageFactory
			// TODO Auto-generated constructor stub
		}
		
		public boolean isPassengersPageLoaded() {
	        // Implement logic to verify that the passengers page is loaded
	        return driver.getCurrentUrl().contains("passengers");
	    }
		
		@FindBy(how=How.XPATH,using="/html[1]/body[1]/app-root[1]/flights-root[1]/div[1]/div[1]/div[1]/div[1]/flights-lazy-content[1]/flights-passengers[1]/ry-spinner[1]/pax-app-container[1]/pax-app[1]/ry-spinner[1]/div[1]/div[1]/div[2]/pax-app-form-container[1]/pax-app-form[1]/form[1]/pax-passenger-container[1]/pax-passenger[1]/div[1]/pax-passenger-details-container[1]/pax-passenger-details[1]/pax-passenger-details-form-container[1]/pax-details-form[1]/ry-dropdown[1]/div[2]/button[1]")
		WebElement firstTitle;
		
		@FindBy(how=How.CSS,using="button.dropdown-item__link--highlighted div.dropdown-item__label")
		WebElement mr;
		
		@FindBy(how=How.ID,using="form.passengers.ADT-0.name")
		WebElement passenger1Name;
		
		@FindBy(how=How.ID,using="form.passengers.ADT-0.surname")
		WebElement passenger1Surname;
		
		@FindBy(how=How.XPATH,using="//pax-passenger-container[2]//pax-passenger[1]//div[1]//pax-passenger-details-container[1]//pax-passenger-details[1]//pax-passenger-details-form-container[1]//pax-details-form[1]//ry-dropdown[1]//div[2]//button[1]")
		WebElement secondTitle;
		
		@FindBy(how=How.CSS,using="ry-dropdown-item:nth-child(2) button")
		WebElement mrs;
		
		@FindBy(how=How.ID,using="form.passengers.ADT-1.name")
		WebElement passenger2Name;
		
		@FindBy(how=How.ID,using="form.passengers.ADT-1.surname")
		WebElement passenger2Surname;
		
		@FindBy(how=How.CSS,using=".continue-flow__button")
		WebElement continueFlow;

	    public void enterPassengerDetails() {
	    	
	    	
	    	String[] firstnames = {"Evan", "Ilaria"};
	    	String[] surnames = {"Reen", "Bianchi"};

    		firstTitle.click();
    		mr.click();
    		passenger1Name.sendKeys(firstnames[0]);
    		passenger1Surname.sendKeys(surnames[0]);
    		
   
    		secondTitle.click();
    		mrs.click();
    		passenger2Name.sendKeys(firstnames[1]);
    		passenger2Surname.sendKeys(surnames[1]);
    		
//    		driver.findElement(By.id("formState.passengers.CHD-0.name")).sendKeys(firstnames[2]);
//    		driver.findElement(By.id("formState.passengers.CHD-0.surname")).sendKeys(surnames[2]);
    		
    		continueFlow.click();
	        
	    }
}
