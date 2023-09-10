package pages;

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
	        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver");
			// TODO Auto-generated constructor stub
		}
		
		public boolean isLogInPageLoaded() {
			// Implement logic to verify that the login page is loaded
			return driver.getCurrentUrl().contains("login");
			
		}
		
		@FindBy(how=How.CSS,using=".login-touchpoint__login-later.title-m-lg.title-m-sm")
		WebElement logInLater;
		
		public void chooseLogInLater() {
			// Implement code to select "Log in later"
			logInLater.click();
			
		}

}
