package abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractComponent {
	
	protected WebDriver driver;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected void clickElement(By locator) {
        findElement(locator).click();
    }

    protected void typeText(By locator, String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

}
