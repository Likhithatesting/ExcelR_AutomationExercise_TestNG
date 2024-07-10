package Project2TestCases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartFromRecommendedItems {
	
	WebDriver driver;
	
	public AddToCartFromRecommendedItems(WebDriver idriver) {
		
		driver = idriver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div[@class='recommended_items']") WebElement recommend;
	@FindBy(xpath = "//div[@class='recommended_items']/div/div/div[2]/div[1]/div/div/div/a") WebElement addCart;
	@FindBy(xpath = "//div[@class='modal-content']/div[2]/p/a") WebElement viewCart;
	@FindBy(id = "cart_info") WebElement cartInfo;
	
	
	
	public void url() {
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void RecommendedItems() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		System.out.println("==================================");
		System.out.println(recommend.getText());
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		addCart.click();
		viewCart.click();
		
		System.out.println("=================Products in Cart===================");
		System.out.println(cartInfo.getText());
		
	}
	
	public void closeBrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.close();
	 }
	

}
