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
		 
		 try {
	    	WebElement bagsTitle = driver.findElement(By.xpath("//span[normalize-space()='Cabin Bags']"));
	        return bagsTitle.isDisplayed();
		 }catch (org.openqa.selenium.NoSuchElementException e) {
	            return false;
	        }
	    }

}
