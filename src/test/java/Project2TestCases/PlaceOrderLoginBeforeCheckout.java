package Project2TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PlaceOrderLoginBeforeCheckout {
	
	WebDriver driver;

	public PlaceOrderLoginBeforeCheckout(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li[4]") WebElement login;
	@FindBy(xpath="//form[@action='/login']/input[2]") WebElement email;
	@FindBy(xpath="//form[@action='/login']/input[3]") WebElement pswd;
	@FindBy(xpath="//form[@action='/login']/button") WebElement loginBtn;
	@FindBy(xpath="//div[@class='shop-menu pull-right']/ul/li[10]/a") WebElement logInAsMsg;
	@FindBy(xpath="//div[@class='features_items']/div[6]/div/div[1]/div/a") WebElement prod1;
	@FindBy(xpath="//div[@class='modal-footer']/button") WebElement cont1;
	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li[3]") WebElement cart;
	@FindBy(xpath = "//a[@class='btn btn-default check_out']") WebElement proceed;
	@FindBy(xpath = "//div[@class='checkout-information']") WebElement addressInfo;
	@FindBy(id = "cart_info") WebElement cartInfo;
	@FindBy(xpath = "//div[@id='ordermsg']/textarea") WebElement textdesc;
	@FindBy(xpath = "//a[@class='btn btn-default check_out']") WebElement placeOrder;
	@FindBy(name= "name_on_card") WebElement cardName;
	@FindBy(name= "card_number") WebElement cardNum;
	@FindBy(name= "cvc") WebElement cvc;
	@FindBy(name= "expiry_month") WebElement expMonth;
	@FindBy(name= "expiry_year") WebElement expYear;
	@FindBy(xpath = "//button[@class='form-control btn btn-primary submit-button']") WebElement pay;
	@FindBy(id= "success_message") WebElement orderPlaced;
	@FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']/p") WebElement orderSuccessMsg;
	@FindBy(xpath="//div[@class='shop-menu pull-right']/ul/li[5]/a") WebElement delAcc;
	@FindBy(xpath="//div[@class='col-sm-9 col-sm-offset-1']") WebElement delAccMsg;
	@FindBy(xpath="//a[@class='btn btn-primary']") WebElement cont3;	
	
	
	
	public void url() {
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String isPageVisible = driver.getCurrentUrl();
		Assert.assertEquals(isPageVisible,"https://automationexercise.com/");
		System.out.println("Page is Visible");
	}
	
	
	public void loginUser() {

	    login.click();
		
		email.sendKeys("likhitha@gmail.com");
		pswd.sendKeys("Likith@123");
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
	
	public void addCart() {
		
    	prod1.click();
    	cont1.click();
	
	    cart.click();
}

   public void viewCart() {
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	String cartpage = driver.getCurrentUrl();
	Assert.assertEquals(cartpage, "https://automationexercise.com/view_cart");
	System.out.println("View Cart Page is displayed");

	 
}

   //verify address details and order review

   public void checkOut() {
	 
     proceed.click();
   
	 //Verify Address
	 System.out.println(addressInfo.getText());
	 System.out.println(cartInfo.getText());
	 
	 textdesc.sendKeys("jksdfjbsjfkjashrashrkjhse");
	 placeOrder.click(); 
	 
 }

   public void addCardDetails() throws InterruptedException {
	 
	 cardName.sendKeys("Likhitha");
	 cardNum.sendKeys("1234 5678 1234");
	 cvc.sendKeys("311");
	 expMonth.sendKeys("09");
	 expYear.sendKeys("2030");
	 
	 pay.click();
	 Thread.sleep(3000);
	 
	 //display order success message
	 //System.out.println(orderPlaced.getText());
	 System.out.println(orderSuccessMsg.getText());
	 
	 
 }
	 
	 
	 //To delete Account
     public void deleteAccount() {
		 delAcc.click();
		 
	// To display delete account confirmation message	
		 System.out.println("=======================");
		 System.out.println(delAccMsg.getText());
		 cont3.click();
	 }
 
     public void closeBrowser() throws InterruptedException {
	 Thread.sleep(5000);
	 driver.close();
 }
	

}
