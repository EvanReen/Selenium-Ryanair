package abstractComponents;

import org.openqa.selenium.WebDriver;

public abstract class AbstractComponent {
	
	protected WebDriver driver;

    public AbstractComponent(WebDriver driver) {
    	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver"); // Path to Chromedriver
        this.driver = driver;
    }
    
}
