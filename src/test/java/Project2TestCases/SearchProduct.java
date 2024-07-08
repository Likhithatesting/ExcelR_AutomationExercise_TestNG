package Project2TestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchProduct {
	
	WebDriver driver;

	public SearchProduct(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[2]/a") WebElement products;
	@FindBy(xpath="//div[@class='features_items']/h2") WebElement allProd;
	@FindBy(id="search_product") WebElement searchProd;
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']/i") WebElement searchBtn;
	
	public void url() {
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String isPageVisible = driver.getCurrentUrl();
		Assert.assertEquals(isPageVisible,"https://automationexercise.com/");
		System.out.println("Page is Visible");
	}
	
	public void Products() throws InterruptedException {
		
		products.click();
		Thread.sleep(5000);
		
		String productsPage = driver.getCurrentUrl();
		 Assert.assertEquals(productsPage, "https://automationexercise.com/products");
		 System.out.println("=======================");
		 System.out.println("Navigated to All Products Page Successfully");
		 
		 //Displaying all products Text displayed
		 System.out.println("=======================");
		 System.out.println(allProd.getText());	 

         }
	
	public void searchProduct(String sp) throws InterruptedException {
		
		searchProd.sendKeys(sp);
		searchBtn.click();
		Thread.sleep(2000);
		
		String searchList = driver.getCurrentUrl();
		 Assert.assertEquals(searchList, "https://automationexercise.com/products?search=Tshirt");
		 System.out.println("=======================");
		 System.out.println("Searched Products is visible");
		 
		 if(searchList.contains(sp)) {
			 System.out.println("All the products related to search are visible");
			 
			
		 }
		
	}
	
	public void listDisplay() throws InterruptedException {
		
		List<WebElement> list_of_products = driver.findElements(By.xpath("//div[@class='features_items']/div"));
		
		for(int i =0;i<list_of_products.size();i++) {
			//list_of_products.get(i).getText();
			//System.out.println(list_of_products);
			
			String productName = list_of_products.get(i).getText();
			System.out.println("======================");
			System.out.println(productName);
			Thread.sleep(2000);
		}
		}
	
     public void closeBrowser() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.close();
     }
	
	
}
