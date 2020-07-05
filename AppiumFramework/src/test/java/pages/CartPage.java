package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import scripts.eBayShoppingTest;

public class CartPage extends eBayShoppingTest {

	
	List<AndroidElement> cartItemTitle=driver.findElements(By.id("com.ebay.mobile:id/title"));

	public void getCartItemTitle(String itemName) { // Method to get the text of the item name, compare it with the same
													// -displayed on Item Page and assert.
		String cartItemName = cartItemTitle.get(1).getText();
		Assert.assertEquals(itemName, cartItemName,
				"Asserion failed: Item name displayed in cart is not matching item description");
	}

	MobileElement cartItemPrices= (MobileElement)driver.findElementById("com.ebay.mobile:id/item_price");

	public void getCartItemPrice(float itemPrice) { 
		String t = cartItemPrices.getText();
		String u = t.substring(4);
		String v = u.replace(",", "");
		float w = Float.parseFloat(v);
		Assert.assertEquals(itemPrice, w, "Asserion failed: Item price displayed in cart is not matching item description");
	}
	

	MobileElement checkoutButton= (MobileElement)driver.findElementById("com.ebay.mobile:id/shopping_cart_checkout");

	public void clickCheckoutButton() { 
		checkoutButton.click();
	}

}
