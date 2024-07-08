package Project2TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RemoveProductsFromCart {
	
	WebDriver driver;

	public RemoveProductsFromCart(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//div[@class='features_items']/div[6]/div/div[1]/div/a") WebElement prod1;
	@FindBy(xpath="//div[@class='modal-footer']/button") WebElement cont1;
	@FindBy(xpath="//div[@class='features_items']/div[8]/div/div[1]/div/a") WebElement prod2;
	@FindBy(xpath="//div[@class='modal-footer']/button") WebElement cont2;
	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li[3]") WebElement cart;
	@FindBy(xpath = "//div[@id='cart_info']/table/tbody/tr[1]/td[6]/a") WebElement Xbutton;
	@FindBy(xpath = "//div[@id='cart_info']/table/tbody/tr") WebElement cartInfo;
	
	
	public void url() {
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String isPageVisible = driver.getCurrentUrl();
		Assert.assertEquals(isPageVisible,"https://automationexercise.com/");
		System.out.println("Page is Visible");
	}
	
	
	public void addToCart() {
		prod1.click();
		cont1.click();
		
		prod2.click();
		cont2.click();
		
		cart.click();
		
	}
	
	
	public void viewCart() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String cartpage = driver.getCurrentUrl();
		Assert.assertEquals(cartpage, "https://automationexercise.com/view_cart");
		System.out.println("View Cart Page is displayed");
		
	}
	
	public void removeProduct() throws InterruptedException {
		
		Thread.sleep(5000);
		Xbutton.click();
		
		//To verify that product is removed from the cart
		
		if(cartInfo.equals("Blue Top")) {
	        System.out.print("The product is not removed.");
	    } else {
	        System.out.print("The product is removed.");
	    }
	}
	
	
	public void closeBrowser() throws InterruptedException {
		 Thread.sleep(5000);
		 driver.close();
	 }

}
