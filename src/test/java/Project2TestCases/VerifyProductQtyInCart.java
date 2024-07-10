package Project2TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VerifyProductQtyInCart {
	
	WebDriver driver;

	public VerifyProductQtyInCart(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//div[@class='features_items']/div[3]/div/div[2]/ul/li/a") WebElement viewProd;
	@FindBy(id="quantity") WebElement Qty;
	@FindBy(xpath="//div[@class='product-information']/span/button") WebElement addCart;
	@FindBy(xpath="//div[@class='modal-content']/div[2]/p/a") WebElement viewCart;
	@FindBy(xpath="//tr[@id='product-2']/td[4]/button") WebElement matchQty;
	
	
	public void url() {
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String isPageVisible = driver.getCurrentUrl();
		Assert.assertEquals(isPageVisible,"https://automationexercise.com/");
		System.out.println("Page is Visible");
	}
	
	public void viewCart() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		viewProd.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String productdetail = driver.getCurrentUrl();
		Assert.assertEquals(productdetail,"https://automationexercise.com/product_details/2");
		System.out.println("Product detail is visible");
		
		Qty.clear();
		Qty.sendKeys("4");
		
		addCart.click();
		
		viewCart.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("Product Qty displayed in cart page with exact quantity: "+matchQty.getText());
		
	
		}
	
	public void closeBrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.close();
	}

}
