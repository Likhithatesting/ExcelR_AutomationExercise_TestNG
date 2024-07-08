package Project2TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VerifyAddressDetailsInCheckOutPage {
	
	WebDriver driver;
	

    @BeforeSuite
	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String isPageVisible = driver.getCurrentUrl();
		Assert.assertEquals(isPageVisible,"https://automationexercise.com/");
		System.out.println(isPageVisible);
	}
	
    
    @DataProvider(name="dataset")
	public Object[][] signup(){
		
		Object[][] data = new Object[1][2];
		
		data[0][0] = "Likhitha";
		data[0][1] = "likhitha13@gmail.com";
		
		return data;
	}
    
    
    @Test(dataProvider = "dataset")
	public void SignUp(String name, String email) throws InterruptedException {
		
    	driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[4]")).click();
		WebElement signupName = driver.findElement(By.xpath("//form[@action='/signup']/input[2]"));
		WebElement signupEmail = driver.findElement(By.xpath("//form[@action='/signup']/input[3]"));
		
		signupName.sendKeys(name);
		signupEmail.sendKeys(email);
		
		driver.findElement(By.xpath("//form[@action='/signup']/button")).click();
		
		driver.findElement(By.id("id_gender2")).click();
		driver.findElement(By.id("password")).sendKeys("Likith@123");
		driver.findElement(By.id("days")).sendKeys("16");
		driver.findElement(By.id("months")).sendKeys("02");
		driver.findElement(By.id("years")).sendKeys("2020");
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.id("first_name")).sendKeys("Likhitha");
		driver.findElement(By.id("last_name")).sendKeys("P");
		driver.findElement(By.id("address1")).sendKeys("Whitefield");
		driver.findElement(By.id("address2")).sendKeys("ITPL");
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.id("state")).sendKeys("Karnataka");
		driver.findElement(By.id("city")).sendKeys("Bangalore");
		driver.findElement(By.id("zipcode")).sendKeys("560016");
		driver.findElement(By.id("mobile_number")).sendKeys("9876098678");
		driver.findElement(By.xpath("//form[@action='/signup']/button")).click();
		System.out.println("=====================");
		System.out.println(driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-1']")).getText());
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		System.out.println("=====================");
		System.out.println(driver.findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[10]/a")).getText());
		
		
		driver.findElement(By.xpath("//div[@class='features_items']/div[6]/div/div[1]/div/a")).click();
		driver.findElement(By.xpath("//div[@class='modal-footer']/button")).click();
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[3]")).click();
		
		Thread.sleep(3000);
		String cartPage = driver.getCurrentUrl();
		Assert.assertEquals(cartPage, "https://automationexercise.com/view_cart");
		System.out.println("=====================");
		System.out.println("Cart Page is displayed");
		
		driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
		
	}
	
	@Test
	public void verifyAddress() {
		
		WebElement  addressDetails =driver.findElement(By.xpath("//section[@id='cart_items']/div/div[3]"));
		String s = addressDetails.getText();
		System.out.println("=====================");
		System.out.println(s);
		
	}
	
	
	@AfterSuite
	public void closeBrowser() throws InterruptedException {
		 Thread.sleep(5000);
		 driver.close();
	 }

}
