package Project2TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ViewBrandProducts {
	
	WebDriver driver;

	public ViewBrandProducts(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[2]/a") WebElement Products;
	@FindBy(xpath="//div[@class='brands_products']") WebElement BrandProducts;
	@FindBy(xpath="//div[@class='brands-name']/ul/li[5]/a") WebElement Brand1;
	@FindBy(xpath="//h2[@class='title text-center']") WebElement TextConfirm;
	@FindBy(xpath="//div[@class='brands-name']/ul/li[1]/a") WebElement Brand2;
		
	
	public void url() {
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void viewBrands() {
		
		Products.click();
		System.out.println(BrandProducts.getText());
		Brand1.click();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://automationexercise.com/brand_products/Babyhug");
		System.out.println("======================================");
		System.out.println("Brand products are displayed.");
		System.out.println("======================================");
		System.out.println(TextConfirm.getText());
	}
	
	public void Brand() {
		
		Brand2.click();
		
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://automationexercise.com/brand_products/Polo");
		System.out.println("======================================");
		System.out.println("2nd Brand products are displayed.");
		
	}
	
	public void closeBrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.close();
	 }


}
