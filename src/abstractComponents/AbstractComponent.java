package abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractComponent {
	
	protected WebDriver driver;

	public AbstractComponent(WebDriver driver) {
    	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver"); // Path to Chromedriver
        this.driver = driver;
    }

}
