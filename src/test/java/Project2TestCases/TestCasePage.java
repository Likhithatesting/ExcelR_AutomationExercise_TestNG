package Project2TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TestCasePage {
	
	WebDriver driver;

	public TestCasePage(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[5]") WebElement tcPage;
	
	
	
	public void url() {
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String isPageVisible = driver.getCurrentUrl();
		Assert.assertEquals(isPageVisible,"https://automationexercise.com/");
		System.out.println("Page is Visible");
	}
	
	public void testcasePage() throws InterruptedException {
		
		tcPage.click();
		Thread.sleep(5000);
		
		String tcURL = driver.getCurrentUrl();
		 Assert.assertEquals(tcURL, "https://automationexercise.com/test_cases");
		 System.out.println("=======================");
		 System.out.println("Navigated to Test Cases Page");
	}
	
	// To Close the Browser
			public void closeBrowser() throws InterruptedException {
				Thread.sleep(5000);
				driver.close();
			}


}
