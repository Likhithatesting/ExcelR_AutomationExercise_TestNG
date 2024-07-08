package Project2TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class VerifyScrollUsingArrowButton {
	
	WebDriver driver;
	
	@BeforeSuite
	public void setup() throws InterruptedException
	
	{
	
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	@Test(priority = 1)
	
	//verify URL
	public void verifyURL()
	{

    String URL = driver.getCurrentUrl();
    System.out.println(URL);
    Assert.assertEquals( URL , "https://automationexercise.com/");
    System.out.println("URL is correct");
    
	}
	
	@Test(priority = 2)
	public void scrollDown() throws InterruptedException {
		
		
		//Scroll down to footer
		WebElement scrolldowntext = driver.findElement(By.xpath("//footer[@id='footer']/div/div/div/div[2]/div/h2"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", scrolldowntext);
		Thread.sleep(3000);

		//verify text subscription
		if(scrolldowntext.isDisplayed()) {
			System.out.println(scrolldowntext.getText());
		}
	}
		
		@Test(priority = 3)
		public void scrollUp() throws InterruptedException {
		
		//Scroll Up to Top
			Thread.sleep(3000);
        WebElement scrollUptext = driver.findElement(By.xpath("//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]"));
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("arguments[0].scrollIntoView(true);", scrollUptext);
		Thread.sleep(2000);
		
		//Verify that page is scrolled up and 'Full-Fledged practice Website for Automation Engineers' text is visible on screen
		if(scrollUptext.isDisplayed()) {
		
			System.out.println(scrollUptext.getText());
		}
		
	}
	
	@AfterSuite
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}


}
