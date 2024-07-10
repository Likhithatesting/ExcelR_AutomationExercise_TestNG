package Project2TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VerifyAllProductsAndProductDetails {
	
	WebDriver driver;

	public VerifyAllProductsAndProductDetails(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[2]/a") WebElement products;
	@FindBy(xpath="//div[@class='features_items']/h2") WebElement allProd;
	@FindBy(xpath="//div[@class='features_items']/div[2]/div/div[2]/ul/li/a") WebElement viewProduct;
	@FindBy(xpath="//div[@class='product-information']") WebElement prodInfo;
	
	public void url() {
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String isPageVisible = driver.getCurrentUrl();
		Assert.assertEquals(isPageVisible,"https://automationexercise.com/");
		System.out.println("Page is Visible");
	}
	
	public void Products() {
		
		products.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String productsPage = driver.getCurrentUrl();
		 Assert.assertEquals(productsPage, "https://automationexercise.com/products");
		 System.out.println("=======================");
		 System.out.println("Navigated to All Products Page");
		 
		 //Displaying all products Text displayed
		 System.out.println("=======================");
		 System.out.println(allProd.getText());
		 
		 //To view Product
		 viewProduct.click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 
		 String firstProduct = driver.getCurrentUrl();
		 Assert.assertEquals(firstProduct, "https://automationexercise.com/product_details/1");
		 System.out.println("=======================");
		 System.out.println("Landed to 1st product detail page");
		 
		 //Product info display
		 
		 System.out.println(prodInfo.getText());
		 
	}
	
public void closeBrowser() {
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.close();
}

}
