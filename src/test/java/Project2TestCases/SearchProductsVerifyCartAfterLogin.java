package Project2TestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchProductsVerifyCartAfterLogin {
	
	WebDriver driver;

	public SearchProductsVerifyCartAfterLogin(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[2]/a") WebElement Products;
	@FindBy(id="search_product") WebElement searchTxt;
	@FindBy(id="submit_search") WebElement searchBtn;
	@FindBy(xpath="//h2[@class='title text-center']") WebElement searchMsg;
	@FindBy(xpath="//button[@class='btn btn-success close-modal btn-block']") WebElement cont;
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[3]/a") WebElement viewCart;
	@FindBy(id= "cart_info_table") WebElement cartInfo;
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[4]/a") WebElement login;
	@FindBy(name="email") WebElement email;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//form[@action='/login']/button") WebElement loginBtn;
	@FindBy(id= "cart_info_table") WebElement loginCartInfo;
	
	
	
	public void url() {
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void searchProduct(){
		Products.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://automationexercise.com/products");
		System.out.println("======================================");
		System.out.println("User is navigated to ALL PRODUCTS page successfully.");
		System.out.println("======================================");
		
		searchTxt.sendKeys("Tshirt");
		searchBtn.click();
		
		System.out.println(searchMsg.getText());
		
	}
	
	//List searched products
	
	public void searchList() {
		
		List<WebElement> searchProducts = driver.findElements(By.xpath("//div[@class='col-sm-4']/div/div/div/a"));
		
		for(int i =0;i<searchProducts.size();i++) {
			
			searchProducts.get(i).click();
			cont.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			
		}
		
		viewCart.click();
		System.out.println("Products available in Cart:"+"\n"+cartInfo.getText());
		
	}
	
	public void login() {
		
		login.click();
		email.sendKeys("likhitha10@gmail.com");
		password.sendKeys("Likith@123");
		loginBtn.click();
		
		viewCart.click();
		if(loginCartInfo.equals(cartInfo)) {
			System.out.println("======================================");
			System.out.println("Same Products are visible in cart:"+"\n"+loginCartInfo.getText());
			System.out.println("======================================");
		}
		else {
			System.out.println("======================================");
			System.out.println("Products are not visible in Cart");
			System.out.println("======================================");
		}
		
		
	}
	
	public void closeBrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.close();
	 }

}
