package Project2TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PlaceOrderRegisterBeforeCheckout {
	
	WebDriver driver;

	public PlaceOrderRegisterBeforeCheckout(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[4]") WebElement SignIn;
	@FindBy(name="name") WebElement name;
	@FindBy(xpath="//form[@action='/signup']/input[3]") WebElement email;
	@FindBy(xpath="//form[@action='/signup']/button") WebElement signUp;
	@FindBy(id="id_gender2") WebElement gender;
	@FindBy(id="password") WebElement pswd;
	@FindBy(id="days") WebElement day;
	@FindBy(id="months") WebElement month;
	@FindBy(id="years") WebElement year;
	@FindBy(id="newsletter") WebElement news;
	@FindBy(id="optin") WebElement offers;
	@FindBy(id="first_name") WebElement fname;
	@FindBy(id="last_name") WebElement lname;
	@FindBy(id="address1") WebElement address1;
	@FindBy(id="address2") WebElement address2;
	@FindBy(id="country") WebElement country;
	@FindBy(id="state") WebElement state;
	@FindBy(id="city") WebElement city;
	@FindBy(id="zipcode") WebElement zipcode;
	@FindBy(id="mobile_number") WebElement mobile;
	@FindBy(xpath="//form[@action='/signup']/button") WebElement create;
	@FindBy(xpath="//div[@class='col-sm-9 col-sm-offset-1']") WebElement msg;
	@FindBy(xpath="//a[@class='btn btn-primary']") WebElement cont;
	@FindBy(xpath="//div[@class='shop-menu pull-right']/ul/li[10]/a") WebElement logInAsMsg;
	@FindBy(xpath="//div[@class='features_items']/div[6]/div/div[1]/div/a") WebElement prod1;
	@FindBy(xpath="//div[@class='modal-footer']/button") WebElement cont1;
	@FindBy(xpath="//div[@class='features_items']/div[8]/div/div[1]/div/a") WebElement prod2;
	@FindBy(xpath="//div[@class='modal-footer']/button") WebElement cont2;
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
	
	public void signIn() {
		
		SignIn.click();
		name.sendKeys("Likhitha");
		email.sendKeys("likhitha11@gmail.com");
		signUp.click();
		gender.click();
		pswd.sendKeys("Likith@123");
		day.sendKeys("09");
		month.sendKeys("12");
		year.sendKeys("2001");
		news.click();
		offers.click();
		fname.sendKeys("Likhitha");
		lname.sendKeys("P");
		address1.sendKeys("Varthur");
		address2.sendKeys("Varthur");
		country.sendKeys("India");
		state.sendKeys("Karnataka");
		city.sendKeys("Bangalore");
		zipcode.sendKeys("560066");
		mobile.sendKeys("9876123450");
		create.click();
		
	}
	
	//To verify Account Created
	 
	public void verifyAccountVisible() {
				 System.out.println("=======================");
				 System.out.println(msg.getText());
				 cont.click();
				 
			 }
			 
			//To display logged in as Message
	public void loggedInAsMsg() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
		
		    prod2.click();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    	cont2.click();
		
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
   
   public void addCardDetails() {
		 
		 cardName.sendKeys("Likhitha");
		 cardNum.sendKeys("1234 5678 1234");
		 cvc.sendKeys("311");
		 expMonth.sendKeys("09");
		 expYear.sendKeys("2030");
		 
		 pay.click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		 
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
	 
	 public void closeBrowser() {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.close();
	 }
	

}
