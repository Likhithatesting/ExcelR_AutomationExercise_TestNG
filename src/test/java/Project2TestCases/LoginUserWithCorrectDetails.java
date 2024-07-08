package Project2TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginUserWithCorrectDetails {
	
	WebDriver driver;

	public LoginUserWithCorrectDetails(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}
	
	public void url() {
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li[4]") WebElement login;
	@FindBy(xpath="//form[@action='/login']/input[2]") WebElement email;
	@FindBy(xpath="//form[@action='/login']/input[3]") WebElement pswd;
	@FindBy(xpath="//form[@action='/login']/button") WebElement loginBtn;
	@FindBy(xpath="//div[@class='shop-menu pull-right']/ul/li[10]/a") WebElement logInAsMsg;
	@FindBy(xpath="//div[@class='shop-menu pull-right']/ul/li[5]/a") WebElement delAcc;
	@FindBy(xpath="//div[@class='col-sm-9 col-sm-offset-1']") WebElement delAccMsg;

	
	public void loginUser() {
		String isPageVisible = driver.getCurrentUrl();
		Assert.assertEquals(isPageVisible,"https://automationexercise.com/");
		System.out.println(isPageVisible);

		login.click();
	}
		
	public void enterLoginDetails(String eml, String pw) {	
		
		email.sendKeys(eml);
		pswd.sendKeys(pw);
		
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	//To display logged in as Message
		 public void loggedInAsMsg() throws InterruptedException {
			 Thread.sleep(5000);
			 System.out.println("=======================");
			 if(logInAsMsg.isDisplayed()) {
				 System.out.println(logInAsMsg.getText());
			 }
			 else {
				 System.out.println("Not displayed");
			 }
		 }
	
	
		 //To delete Account
		 public void deleteAccount() {
			 delAcc.click();
			 
		// To display delete account confirmation message	
			 System.out.println("=======================");
			 System.out.println(delAccMsg.getText());
		 }
		 
		 
	// To Close the Browser
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}


}
