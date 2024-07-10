package Project2TestCases;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddProductsInCart {
	
	WebDriver driver;

	public AddProductsInCart(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[2]/a") WebElement products;
	@FindBy(xpath="//div[@class='features_items']/div[2]") WebElement prod1;
	@FindBy(xpath="//div[@class='features_items']/div[2]/div/div/div[2]/div/a") WebElement addToCart1;
	@FindBy(xpath="//div[@class='modal-footer']/button") WebElement cont;
	@FindBy(xpath="//div[@class='features_items']/div[3]") WebElement prod2;
	@FindBy(xpath="//div[@class='features_items']/div[3]/div/div/div[2]/div/a") WebElement addToCart2;
	@FindBy(xpath="//div[@class='modal-body']/p/a") WebElement viewCart;
	@FindBy(id="cart_info_table") WebElement verifyCart;
	
	
	public void url() {
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String isPageVisible = driver.getCurrentUrl();
		Assert.assertEquals(isPageVisible,"https://automationexercise.com/");
		System.out.println("Page is Visible");
	}
	
	public void addToCart() {
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		products.click();
		
		//Adding 1st product to cart
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions act = new Actions(driver);
		act.moveToElement(prod1).build().perform();
		
		addToCart1.click();
		cont.click();
		
		//Adding 2nd product to Cart
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions action = new Actions(driver);
		action.moveToElement(prod2).build().perform();
		
		addToCart2.click();
		viewCart.click();
		
		//To verify products added to cart and display price, qty, item details
		if(verifyCart.isDisplayed()) {
			System.out.println("Products added to cart is visible:"+"\n"+verifyCart.getText());
		}
		else {
			System.out.println("Products not added to cart");
		}
	}
	
	 public void closeBrowser() {
			
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.close();
	     }
	

}
