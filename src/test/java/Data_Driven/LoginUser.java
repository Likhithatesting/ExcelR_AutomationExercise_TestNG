package Data_Driven;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginUser {
	
	WebDriver driver;
	
	@BeforeSuite
	public void url() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test(priority = 1)
	public void loginUser() {
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[4]/a")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
		
		
	//Fetching login details from Excel Sheet
	@Test(priority = 2)
	public void loginDetails() throws IOException {
	String filepath = "D:\\ExcelR\\SELENIUM\\Jyothi Shukla Trainer\\PROJECTS\\Automation_Exercise_Ecom_Project_2\\Input Data.xlsx";
	FileInputStream fis = new FileInputStream(filepath);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet("SignIn");
		
	int rows = sheet.getLastRowNum();
		
	for(int r=1;r<=rows;r++) {
		XSSFRow row = sheet.getRow(r);
		XSSFCell email = row.getCell(0);
		XSSFCell pswd = row.getCell(1);
		
			
			try {
			driver.findElement(By.xpath("//form[@action='/login']/input[2]")).sendKeys(email.toString());
			driver.findElement(By.xpath("//form[@action='/login']/input[3]")).sendKeys(pswd.toString());
			driver.findElement(By.xpath("//form[@action='/login']/button")).click();
			
			System.out.println("Valid Data");
			}
			catch(Exception e) {
				System.out.println("Invalid Data");
			}
		}
		fis.close();

		}
	
	@AfterSuite
	public void closeBrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.close();
	}

}
