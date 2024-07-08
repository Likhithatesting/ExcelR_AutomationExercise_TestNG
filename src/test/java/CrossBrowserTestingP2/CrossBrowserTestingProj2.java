package CrossBrowserTestingP2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTestingProj2 {
		
		WebDriver driver;
		// To launch Website URL in different browsers parallel
		@Parameters("Browser")
		
		@Test
		public void launchBrowser(String Browser) {
			
			
			if(Browser.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			}
			else if(Browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			}
			else if(Browser.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			}
				
			}
		
		
		@Test
		public void launchURL() {
			driver.get("https://automationexercise.com/");
		}


}
