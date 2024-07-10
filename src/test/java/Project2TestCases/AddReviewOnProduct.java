package Project2TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddReviewOnProduct {
	
	WebDriver driver;

	public AddReviewOnProduct(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[2]/a") WebElement products;
	@FindBy(xpath="//div[@class='features_items']/div[2]/div/div[2]/ul/li/a") WebElement viewProduct;
	@FindBy(xpath="//div[@class='category-tab shop-details-tab']/div/ul/li/a") WebElement review;
	@FindBy(id="name") WebElement name;
	@FindBy(id="email") WebElement email;
	@FindBy(id="review") WebElement addReview;
	@FindBy(id="button-review") WebElement submitReview;
	@FindBy(xpath="//div[@class='alert-success alert']/span") WebElement successMsg;
	
	
	
	
	public void url() {
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void reviewProduct() {
		
		products.click();
		
		//Navigated to All products Page
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String prodURL = driver.getCurrentUrl();
		Assert.assertEquals(prodURL, "https://automationexercise.com/products");
		System.out.println("Navigated to Products URL Page");
		
		
		viewProduct.click();
		
		if(review.isDisplayed()) {
			System.out.println(review.getText());
		}
		else {
			System.out.println("Text not available");
		}
	}
		
	public void commentReview() {
		
		name.sendKeys("Likhitha");
		email.sendKeys("likhitha@gmail.com");
		addReview.sendKeys("Add Review");
		submitReview.click();
		
		System.out.println(successMsg.getText());
	}
	
	
	public void closeBrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.close();
	 }

}
