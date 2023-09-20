package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {
	
	//constructor
		public LoginPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this); // Initialize WebElements using PageFactory
			// TODO Auto-generated constructor stub
		}
		
		public boolean isLogInPageLoaded() {
			try {
	            WebElement loginTouchpoint = driver.findElement(By.xpath("//div[@class='login-touchpoint']"));
	            return loginTouchpoint.isDisplayed();
	        } catch (org.openqa.selenium.NoSuchElementException e) {
	            return false;
	        }			
		}
		
		@FindBy(how=How.CSS,using=".login-touchpoint__login-later.title-m-lg.title-m-sm")
		WebElement logInLater;
		
		public void chooseLogInLater() {
			// Implement code to select "Log in later"
			logInLater.click();
			
		}

}
