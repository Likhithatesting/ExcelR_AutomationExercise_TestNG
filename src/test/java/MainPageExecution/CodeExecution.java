package MainPageExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Project2TestCases.AddProductsInCart;
import Project2TestCases.AddReviewOnProduct;
import Project2TestCases.AddToCartFromRecommendedItems;
import Project2TestCases.ContactUsForm;
import Project2TestCases.LogOutUser;
import Project2TestCases.LoginUserWithCorrectDetails;
import Project2TestCases.LoginWithIncorrectDetails;
import Project2TestCases.PlaceOrderLoginBeforeCheckout;
import Project2TestCases.PlaceOrderRegisterBeforeCheckout;
import Project2TestCases.PlaceOrderRegisterWhileCheckout;
import Project2TestCases.RegisterWithExistingEmail;
import Project2TestCases.RemoveProductsFromCart;
import Project2TestCases.SearchProduct;
import Project2TestCases.SearchProductsVerifyCartAfterLogin;
import Project2TestCases.TestCasePage;
import Project2TestCases.UserRegisterAndDelete;
import Project2TestCases.VerifyAllProductsAndProductDetails;
import Project2TestCases.VerifyProductQtyInCart;
import Project2TestCases.VerifySubscriptionInCartPage;
import Project2TestCases.VerifySubscriptionInHomePage;
import Project2TestCases.ViewBrandProducts;
import Project2TestCases.ViewCategoryProducts;

public class CodeExecution {

	WebDriver driver;
	
	UserRegisterAndDelete urd;
	LoginUserWithCorrectDetails lu;
	LoginWithIncorrectDetails lwi;
	LogOutUser lou;
	RegisterWithExistingEmail ree;
	ContactUsForm cuf;
	TestCasePage tcp;
	VerifyAllProductsAndProductDetails vpp;
	SearchProduct sp;
	VerifySubscriptionInHomePage vshp;
	VerifySubscriptionInCartPage vscp;
	AddProductsInCart apc;
	VerifyProductQtyInCart vpac;
	PlaceOrderRegisterWhileCheckout powc;
	PlaceOrderRegisterBeforeCheckout pobc;
	PlaceOrderLoginBeforeCheckout polbc;
	RemoveProductsFromCart rpc;
	ViewCategoryProducts vcp;
	ViewBrandProducts vbp;
	SearchProductsVerifyCartAfterLogin spvc;
	AddReviewOnProduct arp;
	AddToCartFromRecommendedItems acri;

	
	@BeforeSuite
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		urd = new UserRegisterAndDelete(driver);
		lu = new LoginUserWithCorrectDetails(driver);
		lwi = new LoginWithIncorrectDetails(driver);
		lou = new LogOutUser(driver);
		ree = new RegisterWithExistingEmail(driver);
		cuf = new ContactUsForm(driver);
		tcp= new TestCasePage(driver);
		vpp = new VerifyAllProductsAndProductDetails(driver);
		sp = new SearchProduct(driver);
		vshp = new VerifySubscriptionInHomePage(driver);
		vscp = new VerifySubscriptionInCartPage(driver);
		apc = new AddProductsInCart(driver);
		vpac = new VerifyProductQtyInCart(driver);
		powc = new PlaceOrderRegisterWhileCheckout(driver);
		pobc = new PlaceOrderRegisterBeforeCheckout(driver);
		polbc = new PlaceOrderLoginBeforeCheckout(driver);
		rpc = new RemoveProductsFromCart(driver);
		vcp = new ViewCategoryProducts(driver);
		vbp = new ViewBrandProducts(driver);
		spvc = new SearchProductsVerifyCartAfterLogin(driver);
		arp = new AddReviewOnProduct(driver);
		acri = new AddToCartFromRecommendedItems(driver);
	
	}
	
		@Test(priority = 1)
		public void UserRegisterAndDelete() {

		urd.url();
		urd.reguser();
		urd.enterName("Likhitha");
		urd.enterEmail("likhitha2@gmail.com");
		urd.clickOnSignUp();
		urd.title();
		urd.enterpassword("Likith@123");
		urd.selectDay();
		urd.selectMonth();
		urd.selectYear();
		urd.selectNewsLetter();
		urd.selectOffers();
		urd.address("Likhitha", "Papari", "CS", "Varthur", "India", "Karnataka", "Bangalore", "560012", "9876543210");
		urd.createacc();
		urd.verifyAccountVisible();
		urd.loggedInAsMsg();
		urd.deleteAccount();
		urd.closeBrowser();
		
}
		
		@Test(priority = 2)
		public void LoginUserWithCorrectDetails() {
			lu.url();
			lu.loginUser();
			lu.enterLoginDetails("likhitha1@gmail.com", "Likith@123");
			lu.clickLogin();
			lu.loggedInAsMsg();
			lu.deleteAccount();
			lu.closeBrowser();
		}
		
		@Test(priority = 3)
		public void LoginWithIncorrectDetails() {
			lwi.url();
			lwi.loginUser();
			lwi.enterLoginDetails("likith@gmail.com", "Likitha");
			lwi.clickLogin();
			lwi.closeBrowser();
		}
	
	   @Test(priority = 4)
	   public void LogOutUser() {
		   
		   lou.url();
		   lou.loginUser();
		   lou.enterLoginDetails("likhitha@gmail.com", "Likith@123");
		   lou.clickLogin();
		   lou.loggedInAsMsg();
		   lou.logoutUser();
		   lou.closeBrowser();
		   
	   }
	
	@Test(priority = 5)
	public void RegisterWithExistingEmail() {
		ree.url();
		ree.reguser();
		ree.enterName("Likhitha");
		ree.enterEmail("likhitha@gmail.com");
		ree.clickOnSignUp();
		ree.closeBrowser();
		
	}
	
	@Test(priority = 6)
	public void ContactUsForm() {
		
		cuf.url();
		cuf.contactForm();
		cuf.fillForm("Likhitha", "likhitha@gmail.com", "Contact Form", ",mxbnfgkjsdfherut lsdnfkjdg  lsdjfhgkjsrtu  lshdfjhsuruhfkjdf lshdfjshg");
		cuf.submitForm();
		cuf.closeBrowser();
		
	}
	
	@Test(priority = 7)
	public void TestCasePage() {
		
		tcp.url();
		tcp.testcasePage();
		tcp.closeBrowser();
	}
	
	@Test(priority = 8)
	public void VerifyAllProductsAndProductDetails() {
		
		vpp.url();
		vpp.Products();
		vpp.closeBrowser();
	}
	
	
	@Test(priority = 9)
	public void SearchProduct() {
		
		sp.url();
		sp.Products();
		sp.searchProduct("Tshirt");
		sp.listDisplay();
		sp.closeBrowser();
		
	}
	
	
	@Test(priority = 10)
	public void VerifySubscriptionInHomePage() {
		vshp.url();
		vshp.verifySubscription();
		vshp.subscEmail("likhitha@gmail.com");
		vshp.closeBrowser();
		
	}
	
	@Test(priority = 11)
	public void VerifySubscriptionInCartPage() {
		vscp.url();
		vscp.verifySubscription();
		vscp.subscEmail("likhitha@gmail.com");
		vscp.closeBrowser();
	}
	
	@Test(priority = 12)
	public void AddProductsInCart() {
		
		apc.url();
		apc.addToCart();
		apc.closeBrowser();
		
	}
	
	@Test(priority = 13)
	public void VerifyProductQtyInCart() {
		vpac.url();
		vpac.viewCart();
		vpac.closeBrowser();
		
	}
	
	@Test(priority = 14)
	public void PlaceOrderRegisterWhileCheckout() {
		
		powc.url();
		powc.addCart();
		powc.viewCart();
		powc.enterName("Likhitha");
		powc.enterEmail("likhitha8@gmail.com");
		powc.clickOnSignUp();
		powc.title();
		powc.enterpassword("Likith@123");
		powc.selectDay();
		powc.selectMonth();
		powc.selectYear();
		powc.selectNewsLetter();
		powc.selectOffers();
		powc.address("Likhitha", "Pa", "Varthur", "Varthur", "India", "Karnataka", "Bangalore", "560066", "9876549809");
		powc.createacc();
		powc.verifyAccountVisible();
		powc.loggedInAsMsg();
		powc.checkOut();
		powc.addCardDetails("Likhitha", "9876 9876 0987", "311", "09", "2024");
		powc.deleteAccount();
		powc.closeBrowser();
		
	}
	
	@Test(priority = 15)
	
	public void PlaceOrderRegisterBeforeCheckout() {
		
		pobc.url();
		pobc.signIn();
		pobc.verifyAccountVisible();
		pobc.loggedInAsMsg();
		pobc.addCart();
		pobc.viewCart();
		pobc.checkOut();
		pobc.addCardDetails();
		pobc.deleteAccount();
		pobc.closeBrowser();
		
		
	}
	
	@Test(priority = 16)
	public void PlaceOrderLoginBeforeCheckout() {
		
		polbc.url();
		polbc.loginUser();
		polbc.loggedInAsMsg();
		polbc.addCart();
		polbc.viewCart();
		polbc.checkOut();
		polbc.addCardDetails();
		polbc.deleteAccount();
		polbc.closeBrowser();
		
	}
	
	@Test(priority = 17)
	public void RemoveProductsFromCart() {
		
		rpc.url();
		rpc.addToCart();
		rpc.viewCart();
		rpc.removeProduct();
		rpc.closeBrowser();
		
	}
	
	@Test(priority = 18)
	public void ViewCategoryProducts() {
		
		vcp.url();
		vcp.viewCategory();
		vcp.subCategory();
		vcp.closeBrowser();
	}
	
	@Test(priority = 19)
	public void ViewBrandProducts() {
		
		vbp.url();
		vbp.viewBrands();
		vbp.Brand();
		vbp.closeBrowser();
	}
	
	@Test(priority = 20)
	public void SearchProductsVerifyCartAfterLogin() {
		
		spvc.url();
		spvc.searchProduct();
		spvc.searchList();
		spvc.login();
		spvc.closeBrowser();
	}
	
	@Test(priority = 21)
	public void AddReviewOnProduct() {
		arp.url();
		arp.reviewProduct();
		arp.commentReview();
		arp.closeBrowser();
	}
	
	
	@Test(priority = 22)
	public void AddToCartFromRecommendedItems() {
		
		acri.url();
		acri.RecommendedItems();
		acri.closeBrowser();
		
	}
	
	//**************23rd TC using Data Provider and TestNGAnnotations************
	//**************24th TC using TestNG Annotations************
	//**************25th TC using TestNG Annotations************
	//**************26th TC using TestNG Annotations************
	//**************Login website using Data Driven*****************
	//**************Cross Browser Testing to launch the Website******************
	
		

}
