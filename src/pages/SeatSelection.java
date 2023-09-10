package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractComponents.AbstractComponent;

public class SeatSelection extends AbstractComponent {

	public SeatSelection(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this); // Initialize WebElements using PageFactory
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver");
		// TODO Auto-generated constructor stub
	}
	
	 @FindBy(how=How.ID,using="seat-11A")
	 WebElement firstSeat;
	 
	 @FindBy(how=How.ID,using="seat-11B")
	 WebElement secondSeat;
	 
	 @FindBy(how=How.ID,using="seat-11A")
	 WebElement thirdSeat;
	 
	 @FindBy(how=How.ID,using="seat-11B")
	 WebElement fourthSeat;
	
	 @FindBy(how=How.CSS,using=".ry-button")
	 WebElement nextFlight;
	 
	 @FindBy(how=How.CSS,using="body > seats-root > div > div > div > seats-container-root > seats-container-v2 > main > div > div > div > div > div > div > div > div > div > ry-action-sheet > div > div > div > div > div > button:nth-child(3)")
	 WebElement sameSeats;

	 @FindBy(how=How.CSS,using=".ry-button--gradient-yellow")
	 WebElement continueSeatPage;
	
	public void selectSeats() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		firstSeat.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		secondSeat.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(nextFlight));
		nextFlight.click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		thirdSeat.click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		fourthSeat.click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueSeatPage);
		 continueSeatPage.click();
		
	}

}
