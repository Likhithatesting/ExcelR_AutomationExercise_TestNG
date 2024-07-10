package Project2TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class VerifyScrollWithOutArrowButton {	

		WebDriver driver;
		
		@BeforeSuite
		public void setup() throws InterruptedException
		
		{
		
		    driver = new FirefoxDriver();
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
		public void subscription() {
			
			//Scroll down to footer
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0, document.body.scrollHeight)");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			//verify text subscription
			WebElement subscription = driver.findElement(By.xpath("//footer[@id='footer']/child::div/child::div/child::div/child::div[2]/child::div/child::h2"));
			String s=subscription.getText();
			System.out.println("============================");
			System.out.println(s);
			
			//Scroll Up page to Top
			JavascriptExecutor jse1 = (JavascriptExecutor) driver;
			jse1.executeScript("window.scrollTo(0, 0);");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			
			//Verify that page is scrolled up and 'Full-Fledged practice Website for Automation Engineers' text is visible on screen
			WebElement website=driver.findElement(By.xpath("//div[@class='item active']//h2"));
			System.out.println(website.getText());
			
		}
		
		@AfterSuite
		public void closeBrowser() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.close();
		}

}
