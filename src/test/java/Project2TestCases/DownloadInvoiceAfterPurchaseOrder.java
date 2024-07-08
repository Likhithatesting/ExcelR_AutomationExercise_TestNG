package Project2TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DownloadInvoiceAfterPurchaseOrder {
	
	WebDriver driver;
	@BeforeSuite
	
	public void setup() throws InterruptedException
	
	{
	
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com");
		Thread.sleep(2000);
	}
	
	
	@Test(priority=1)
	//verify URL
	public void verifyURL()
	{

    String URL = driver.getCurrentUrl();
    System.out.println(URL);
    Assert.assertEquals( URL , "https://automationexercise.com/");
    System.out.println("URL is correct");
    
	}
	
	@Test(priority=2)
	public void AddProductCart() throws InterruptedException
	{
			
		WebElement prod1 = driver.findElement(By.xpath("//div[@class='features_items']/div[2]"));
		Actions act=new Actions(driver);
		act.moveToElement(prod1).build().perform();
		
		
		WebElement addToCart1 = driver.findElement(By.xpath("//div[@class='features_items']/div[2]/div/div/div/a"));
		addToCart1.click();
		Thread.sleep(2000);
		
		WebElement cont = driver.findElement(By.xpath("//div[@class='modal-content']/div[3]/button"));
		cont.click();
		Thread.sleep(3000);		
						
		//Click 'Cart' button
		WebElement cart=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[3]/a"));
		cart.click();
		Thread.sleep(3000);
		
		// Click Proceed To Checkout
		WebElement proceedTocheckout=driver.findElement(By.xpath("//section[@id='do_action']/div[1]/div/div/a"));
		proceedTocheckout.click();
		
	}
	
	@Test(priority=3)
	public void RegisterUserPage() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//div[@class='modal-content']/div[2]/p/a")).click();
		Thread.sleep(2000);
		
		WebElement name = driver.findElement(By.xpath("//input[@type='text']"));
		name.sendKeys("Likhitha");
		
		WebElement email=driver.findElement(By.xpath("//div[@class='col-sm-4']/child::div/child::form/child::input[3]"));
		email.sendKeys("likhitha26@gmail.com");
		
		driver.findElement(By.xpath("//div[@class='col-sm-4']/child::div/child::form/child::button")).submit();
		Thread.sleep(2000);
		
	}
	
	@Test(priority=4)
	public void RegisterForm() throws InterruptedException, AWTException {
		
		WebElement title=driver.findElement(By.xpath("//div[@class='login-form']/child::form/child::div/child::div[2]/child::label/child::div/child::span/child::input"));
		title.click();
		
		WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Likith@123");
		
		Thread.sleep(2000);
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,250)");	
		
		
		driver.findElement(By.id("days")).sendKeys("8");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Select st1 = new Select(driver.findElement(By.id("months")));
		st1.selectByVisibleText("August");
		
		Select st2 = new Select(driver.findElement(By.id("years")));
		st2.selectByValue("1993");
		Thread.sleep(2000);
		
		//select check box
		driver.findElement(By.xpath("//input[@name='newsletter']")).click();
		
		driver.findElement(By.xpath("//input[@name='optin']")).click();
		
		
	}
	@Test(priority=5)
	public void Register() throws InterruptedException
		{
		
			
		WebElement firstName= driver.findElement(By.xpath("//input[@id='first_name']"));
		firstName.sendKeys("Likhitha");
		
		WebElement lastName= driver.findElement(By.xpath("//input[@id='last_name']"));
		lastName.sendKeys("P");
		
		WebElement company= driver.findElement(By.xpath("//input[@id='company']"));
		company.sendKeys("ABC");
		
		WebElement address1= driver.findElement(By.xpath("//input[@id='address1']"));
		address1.sendKeys("jasgdhf");
		
		WebElement country= driver.findElement(By.id("country"));
		Select scCountry = new Select(country);
		scCountry.selectByVisibleText("India");
		
		WebElement state= driver.findElement(By.xpath("//input[@id='state']"));
		state.sendKeys("sdfgdcb");
		
		WebElement city= driver.findElement(By.xpath("//input[@id='city']"));
		city.sendKeys("srtdsxgdfg");
		
		WebElement zipcode= driver.findElement(By.xpath("//input[@id='zipcode']"));
		zipcode.sendKeys("567867");
		
		WebElement mobile= driver.findElement(By.xpath("//input[@id='mobile_number']"));
		mobile.sendKeys("7896546789");
		
		WebElement createAcc= driver.findElement(By.xpath("//button[@type='submit']"));
		createAcc.submit();
		
		Thread.sleep(1000);
		
		//verify account created is visible
				WebElement accCreated = driver.findElement(By.xpath("//b[text()='Account Created!']"));
				 System.out.println("=======================");
				if(accCreated.isDisplayed())
				{
					System.out.println("'ACCOUNT CREATED!'is visible");
				}
				else 
				{
					System.out.println("'ACCOUNT CREATED!'is not visible");
				}

		
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
		
		}
	
	@Test(priority=6)
	public void loggedInAsMsg() throws InterruptedException {
		 Thread.sleep(5000);
		 System.out.println("=======================");
		 WebElement logInAsMsg = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[10]/a"));
		if(logInAsMsg.isDisplayed()) {
			 System.out.println(logInAsMsg.getText());
		 }
		 else {
			 System.out.println("Not displayed");
		 }
	 }
	
	@Test(priority=7)
	public void cart() throws InterruptedException {
		
		//Click 'Cart' button
		WebElement cart1=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[3]/a"));
				cart1.click();
				
				// Click Proceed To Checkout
		WebElement proceedTocheckout1=driver.findElement(By.xpath("//section[@id='do_action']/div[1]/div/div/a"));
				proceedTocheckout1.click();
				
		
		//Verify Address Details and Review Your Order
		WebElement  addressDetails =driver.findElement(By.xpath("//section[@id='cart_items']/div/div[3]"));
		String s =addressDetails.getText();
		 System.out.println("=======================");
		System.out.println(s);
		
		//Scroll down to footer
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		
		//add comment
		WebElement addComment=driver.findElement(By.xpath("//section[@id='cart_items']/div/div[6]/textarea"));
		addComment.sendKeys("sertsdfgdfgdfg");
		
	}
	
	@Test(priority=8)
	public void placeorder() throws InterruptedException {
		
		//place order
				WebElement placeOrder=driver.findElement(By.xpath("//section[@id='cart_items']/div/div[7]/a"));
				placeOrder.click();
				Thread.sleep(3000);
								
		//card name
		WebElement cardName=driver.findElement(By.xpath("//section[@id='cart_items']/div/div[3]/div/div[2]/form/div/div/input"));
		cardName.sendKeys("Likhitha");
		
		//card number
		WebElement cardNo=driver.findElement(By.xpath("//section[@id='cart_items']/div/div[3]/div/div[2]/form/div[2]/div/input"));
		cardNo.sendKeys("2341 4321 5674");
		
		//CVC
		WebElement CVC=driver.findElement(By.xpath("//section[@id='cart_items']/div/div[3]/div/div[2]/form/div[3]/div/input"));
		CVC.sendKeys("311");
		
		//expiration
		WebElement expiry=driver.findElement(By.xpath("//section[@id='cart_items']/div/div[3]/div/div[2]/form/div[3]/div[2]/input"));
		expiry.sendKeys("03");
		
		//year
		WebElement year =driver.findElement(By.xpath("//section[@id='cart_items']/div/div[3]/div/div[2]/form/div[3]/div[3]/input"));
		year.sendKeys("2025");
		
		//pay and order
		WebElement payAndorder =driver.findElement(By.xpath("//section[@id='cart_items']/div/div[3]/div/div[2]/form/div[5]/div/button"));
		payAndorder.submit();
		
		Thread.sleep(5000);
		System.out.println("=======================");
		System.out.println(driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-1']/h2")).getText());
		System.out.println("=======================");
		 
		
	}
	
	@Test(priority=9)
	public void Invoice() {
		
	driver.findElement(By.xpath("//a[@href='/download_invoice/500']")).click();
	
	File fileLocation = new File("C:\\Users\\plikh\\Downloads");
	File[] totalFiles = fileLocation.listFiles();
	
	for(File file : totalFiles) {
		if(file.getName().equals("invoice.txt")) {
			System.out.println("Invoice is downloaded");
			break;
		}
	}
		
	}
	
	@Test(priority=10)
	public void deletAccount() throws InterruptedException {
		//Click 'Delete Account' button
				WebElement deletAcc= driver.findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[5]/a"));
				deletAcc.click();
				Thread.sleep(2000);
				
				// Verify that 'ACCOUNT DELETED!' is visible
				System.out.println("=======================");
				System.out.println(driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-1']")).getText());
				System.out.println("=======================");
				driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
				
	}
	
	@AfterSuite
	 public void closeBrowser() throws InterruptedException {
		 Thread.sleep(5000);
		 driver.close();
	 }

}
