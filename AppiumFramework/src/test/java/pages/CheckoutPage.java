package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import scripts.eBayShoppingTest;

public class CheckoutPage extends eBayShoppingTest {

	MobileElement paymentMethod= (MobileElement)driver.findElementById("com.ebay.mobile:id/payment_main_text");
	
	public void selectPaymentMethod() { // Method to add a valid payment method.
		// Code needs to be added when a valid credit card or PayPal details are
		// -available.
	}

	MobileElement paymentConfirm= (MobileElement)driver.findElementById("com.ebay.mobile:id/purchase_link");

	public void confirmPaymenrAndBuy() {// Method to click on confirm button after adding payment method.
		
		if (paymentConfirm.isEnabled()) {
			paymentConfirm.click();
		} else
			System.out.println("\"CONFIRM AND PAY\" button is disabled because there is no payment method");
	}
}
