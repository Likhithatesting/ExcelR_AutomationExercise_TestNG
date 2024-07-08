package Project2TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterWithExistingEmail {
	
	WebDriver driver;

	public RegisterWithExistingEmail(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}
	
	public void url() {
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li[4]") WebElement reg;
	@FindBy(xpath="//div[@class='signup-form']/h2") WebElement SignUpmsg;
	@FindBy(name="name") WebElement name;
	@FindBy(xpath="//form[@action='/signup']/input[3]") WebElement email;
	@FindBy(xpath="//form[@action='/signup']/button") WebElement signUp;
	@FindBy(xpath="//form[@action='/signup']/p") WebElement existUsermsg;

	
	public void reguser() {
			
			//To verify home page is visible successfully
			
			String isPageVisible = driver.getCurrentUrl();
			Assert.assertEquals(isPageVisible,"https://automationexercise.com/");
			System.out.println("Page is Visible");
			reg.click();
			
			//To verify New User Signup is visible
			System.out.println("=======================");
			System.out.println(SignUpmsg.getText());
			
	}

	public void enterName(String nm) {
		name.sendKeys(nm);
		
	}
	
	public void enterEmail(String eml) {
		email.sendKeys(eml);
		
	}
	
	public void clickOnSignUp() {
		signUp.click();
		
		//To verify error message " Email Address already exist! is visible"
		System.out.println("=======================");
		System.out.println(existUsermsg.getText());
	}
	
	// To Close the Browser
		public void closeBrowser() throws InterruptedException {
				Thread.sleep(5000);
				driver.close();

			}

}
