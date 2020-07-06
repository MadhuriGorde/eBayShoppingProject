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

public class CheckoutPage extends eBayShoppingTest {

	public CheckoutPage(AndroidDriver<AndroidElement> driver) { 
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.ebay.mobile:id/payment_main_text") // Element locator for selecting payment option
																// -displayed at the time of checkout.
	AndroidElement paymentMethod;

	public void selectPaymentMethod() { 
		// Code needs to be added...
	}

	@AndroidFindBy(id = "com.ebay.mobile:id/purchase_link") // Element locator for confirm purchase button displayed on
															// -the checkout page.

	AndroidElement paymentConfirm;

	public void confirmPaymenrAndBuy() {// Method to click on confirm button after adding payment method.
		// This button will get enable only after a valid payment method is added.
		if (paymentConfirm.isEnabled()) {
			paymentConfirm.click();
		} else
			System.out.println("\"CONFIRM AND PAY\" button is disabled because there is no payment method");
	}
}
