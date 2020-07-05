package scripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ItemPage;
import pages.LogInPage;
import pages.MenuPage;
import pages.SearchResultPage;

public class eBayShoppingTest extends BaseClass { 
	
	private HomePage hp=new HomePage();;
	private MenuPage mp=new MenuPage();
	private LogInPage lp=new LogInPage();
	private SearchResultPage sp=new SearchResultPage();
	private ItemPage ip=new ItemPage();
	private CartPage cp=new CartPage();
	private CheckoutPage chp=new CheckoutPage();
	public static Logger logs;
	

	@Test(priority = 1)
	public void launchApp() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			logs.info("Application launched");
			hp.clickMenu();
		} catch (Exception e) {
			logs.fatal("Test Failed!! Remainig tests will be skipped.");
			e.printStackTrace();
			AssertJUnit.fail();
		}
	}

	@Test(priority = 2, dependsOnMethods = { "launchApp" }) 
	public void goToSignIn() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			mp.clickSigninText();
		} catch (Exception e) {
			logs.fatal("Test Failed!! Remainig tests will be skipped.");
			e.printStackTrace();
			AssertJUnit.fail();
		}
	}

	@Test(priority = 3, dependsOnMethods = { "goToSignIn" })
	public void signInToApp() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			logs.info("Logging in");
			lp.enterUsername(username);
			lp.enterPassword(password);
			lp.clickSigninButton();
			logs.info("Successfully logged in");
			lp.clickDenyButton();
		} catch (Exception e) {

			logs.fatal("Test Failed!! Remainig tests will be skipped.");
			e.printStackTrace();
			AssertJUnit.fail();
		}
	}

	
	@Test(priority = 4, dependsOnMethods = { "signInToApp" }) 
	public void searchAndSelectItem() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			hp.tapSearchBox();
			logs.info("Searching for the item");
			hp.enterSearchKeyword(keyword);
			sp.selectItem();
			logs.info("Required item is selected");
		} catch (Exception e) {
			logs.fatal("Test Failed!! Remainig tests will be skipped.");
			e.printStackTrace();
			AssertJUnit.fail();
		}
	}

	@Test(priority = 5, dependsOnMethods = { "searchAndSelectItem" }) 
	public void cartActions() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			logs.info("Cheking item details");
			String itemName = ip.getItemTitle();
			float itemPrice = ip.getItemPrice();
			ip.addToCartAction();
			logs.info("Required item is added to cart");
			ip.viewCart();
			logs.info("Checking cart details");
			cp.getCartItemTitle(itemName); 
			cp.getCartItemPrice(itemPrice);
			cp.clickCheckoutButton();
			logs.info("Checking out");
		} catch (Exception e) {
			logs.fatal("Test Failed!! Remainig tests will be skipped.");
			e.printStackTrace();
			AssertJUnit.fail();
		}
	}

	@Test(priority = 6, dependsOnMethods = { "cartActions" })
	public void doCheckOut() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(textContains(\"Total\"));");
			chp.selectPaymentMethod();
			logs.info("Code is not written to add valid credit card or PayPal account");
			chp.confirmPaymenrAndBuy();
			logs.info("Test scenario coverage is completed");
		} catch (Exception e) {
			logs.fatal("Test Failed!! Remainig tests will be skipped.");
			e.printStackTrace();
			AssertJUnit.fail();
		}
	}
}
