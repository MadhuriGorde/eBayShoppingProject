package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import scripts.eBayShoppingTest;

public class CartPage extends eBayShoppingTest {

	
	public CartPage(AndroidDriver<AndroidElement> driver) { 
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.ebay.mobile:id/title") // Element locator for item title displayed in the cart.
	
	List<AndroidElement> cartItemTitle;

	public void getCartItemTitle(String itemName) { // Method to get the text of the item name, compare it with the same
													// -displayed on Item Page and assert.
		String cartItemName = cartItemTitle.get(1).getText();
		Assert.assertEquals(itemName, cartItemName,
				"Asserion failed: Item name displayed in cart is not matching item description");
	}

	@AndroidFindBy(id = "com.ebay.mobile:id/item_price") // Element locator for item price displayed in the cart.
	
	AndroidElement cartItemPrices;

	public void getCartItemPrice(float itemPrice) { 
		String t = cartItemPrices.getText();
		String u = t.substring(4);
		String v = u.replace(",", "");
		float w = Float.parseFloat(v);
		Assert.assertEquals(itemPrice, w, "Asserion failed: Item price displayed in cart is not matching item description");
	}

	

	@AndroidFindBy(id = "com.ebay.mobile:id/shopping_cart_checkout") // Element locator for checkout button displayed in
	
	AndroidElement checkoutButton;

	public void clickCheckoutButton() { 
		checkoutButton.click();
	}

}
