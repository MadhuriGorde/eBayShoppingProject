package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import scripts.eBayShoppingTest;

public class ItemPage extends eBayShoppingTest {

	public ItemPage(AndroidDriver<AndroidElement> driver) { 
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ebay.mobile:id/textview_item_name']") // Element locator for item title
	
	AndroidElement itemTitle;

	public String getItemTitle() {
			String itemName = itemTitle.getText();
			return itemName;
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.ebay.mobile:id/textview_item_price\")") // Element locator for item price
																											// -displayed in the item description.
	AndroidElement itemValue;

	public float getItemPrice() throws Exception {
			String a = itemValue.getText();
			String b = a.substring(4);
			String e = b.replaceAll(",", "");
			float itemPrice = Float.parseFloat(e);
			return itemPrice;
	}

	

	@AndroidFindBy(id = "com.ebay.mobile:id/button_add_to_cart") // Element locator for add to cart button.
	
	AndroidElement addToCartButton;
	
	@AndroidFindBy(id = "com.ebay.mobile:id/button_view_in_cart") // Element locator for view in cart button.
	
	AndroidElement viewInCartButton;

	public void addToCartAction() { 
			if (addToCartButton.isDisplayed()) {
				addToCartButton.click();
			} else if (viewInCartButton.isDisplayed()) {
				viewInCartButton.click();
			}

	}

	@AndroidFindBy(accessibility = "shopping cart") // Element locator for open cart button
	
	AndroidElement cartButton;

	public void viewCart() {
			cartButton.click();
	}
}
