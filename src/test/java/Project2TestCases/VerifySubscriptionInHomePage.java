package Project2TestCases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VerifySubscriptionInHomePage {
	
	WebDriver driver;

	public VerifySubscriptionInHomePage(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//div[@class='single-widget']/h2") WebElement subsc;
	@FindBy(id="susbscribe_email") WebElement subEmail;
	@FindBy(id="subscribe") WebElement subSubmit;
	@FindBy(xpath="//div[@class='alert-success alert']") WebElement succMsg;
	
	public void url() {
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String isPageVisible = driver.getCurrentUrl();
		Assert.assertEquals(isPageVisible,"https://automationexercise.com/");
		System.out.println("Page is Visible");
	}
	
	public void verifySubscription() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		
		System.out.println(subsc.getText());		
		
	}
	
	public void subscEmail(String eml) {
		subEmail.sendKeys(eml);
		subSubmit.click();
		System.out.println(succMsg.getText());
		
	}
	
	public void closeBrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.close();
	}

}
