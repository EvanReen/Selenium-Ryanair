package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abstractComponents.AbstractComponent;

public class Bags extends AbstractComponent {

	public Bags(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	 public boolean isBagsPageLoaded() {
	    	WebElement pageTitle = driver.findElement(By.cssSelector("h3[contains(text(), 'Cabin Bags')]"));
	        return pageTitle.isDisplayed();
	    }

}
