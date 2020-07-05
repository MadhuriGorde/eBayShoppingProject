package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import scripts.eBayShoppingTest;

public class ItemPage extends eBayShoppingTest {

	MobileElement itemTitle= (MobileElement)driver.findElementByXPath("//android.widget.TextView[@resource-id='com.ebay.mobile:id/textview_item_name']");

	public String getItemTitle() {
		String itemName = itemTitle.getText();
		return itemName;
	}
	
	MobileElement itemValue= (MobileElement)driver.findElementById("com.ebay.mobile:id/textview_item_price");

	public float getItemPrice() throws Exception { 
		String a = itemValue.getText();
		String b = a.substring(4);
		String e = b.replaceAll(",", "");
		float itemPrice = Float.parseFloat(e);
		return itemPrice;
	}

	MobileElement addToCartButton= (MobileElement)driver.findElementById("com.ebay.mobile:id/button_add_to_cart");
	
	MobileElement viewInCartButton= (MobileElement)driver.findElementById("com.ebay.mobile:id/button_view_in_cart");

	public void addToCartAction() { 
		if (addToCartButton.isDisplayed()) {
			addToCartButton.click();
		} else if (viewInCartButton.isDisplayed()) {
			viewInCartButton.click();
		}

	}

	
	MobileElement cartButton= (MobileElement)driver.findElementsByAccessibilityId("shopping cart");

		public void viewCart() {
		cartButton.click();
	}
}
