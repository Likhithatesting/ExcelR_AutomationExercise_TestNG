package Project2TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class ViewCategoryProducts {
	
	WebDriver driver;

	public ViewCategoryProducts(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(xpath="//div[@class='left-sidebar']/div") WebElement categories;
	@FindBy(xpath="//div[@class='panel-group category-products']/div[1]/div/h4/a") WebElement Women;
	@FindBy(xpath="//div[@class='left-sidebar']/div[1]/div[1]/div[2]/div/ul/li[2]/a") WebElement Tops;
	@FindBy(xpath="//h2[@class='title text-center']") WebElement TextConfirm;
	@FindBy(xpath="//div[@class='panel-group category-products']/div[2]/div/h4/a") WebElement Men;
	@FindBy(xpath="//div[@class='left-sidebar']/div[1]/div[2]/div[2]/div/ul/li[2]/a") WebElement Jeans;
		
	
	public void url() {
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void viewCategory() {
		
		System.out.println(categories.getText());
		Women.click();
		Tops.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://automationexercise.com/category_products/2");
		System.out.println("Category Page is displayed.");
		
		System.out.println(TextConfirm.getText());
		
	}
	
	public void subCategory() {
		
		Men.click();
		Jeans.click();
		
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://automationexercise.com/category_products/6");
		System.out.println("Mens- Jeans Category Page is displayed.");
		
	}
	
	public void closeBrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.close();
	 }

}
