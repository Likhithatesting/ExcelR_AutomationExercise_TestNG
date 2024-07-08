package Project2TestCases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactUsForm {
	
	WebDriver driver;

	public ContactUsForm(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}
	
	public void url() {
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String isPageVisible = driver.getCurrentUrl();
		Assert.assertEquals(isPageVisible,"https://automationexercise.com/");
		System.out.println("Page is Visible");
	}
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[8]/a") WebElement contactUs;
	@FindBy(xpath="//div[@class='contact-form']/h2") WebElement getInTouchmsg;
	@FindBy(name="name") WebElement name;
	@FindBy(name="email") WebElement email;
	@FindBy(name="subject") WebElement subject;
	@FindBy(name="message") WebElement message;
	@FindBy(name="upload_file") WebElement upload;
	@FindBy(name="submit") WebElement submit;
	@FindBy(xpath="//div[@class='status alert alert-success']") WebElement successMsg;
	@FindBy(xpath="//div[@id='form-section']/a") WebElement home;
	
	
	public void contactForm() {
			
			contactUs.click();
			System.out.println("================");
			System.out.println(getInTouchmsg.getText());
			

	}
	
	public void fillForm(String nm, String eml, String sub, String msg) {
		
		name.sendKeys(nm);
		email.sendKeys(eml);
		subject.sendKeys(sub);
		message.sendKeys(msg);
	}
	
	
	public void submitForm() throws InterruptedException {
		
		upload.sendKeys("D:\\ExcelR\\SELENIUM\\Jyothi Shukla Trainer\\PROJECTS\\Automation_Exercise_Ecom_Project_2\\Contact US Form_Project2.docx");
		submit.click();
		
		Alert a = driver.switchTo().alert();
		a.accept();
		
		System.out.println("================");
		System.out.println(successMsg.getText());
		
		home.click();
		Thread.sleep(5000);
		//To verify user navigated to home page
		 
		 String homeURL = driver.getCurrentUrl();
		 Assert.assertEquals(homeURL, "https://automationexercise.com/");
		 System.out.println("=======================");
		 System.out.println("Navigated to Home Page");
	 
	}
	
	// To Close the Browser
		public void closeBrowser() throws InterruptedException {
			Thread.sleep(5000);
			driver.close();
		}


}
