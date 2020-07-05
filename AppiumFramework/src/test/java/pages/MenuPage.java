package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import scripts.BaseClass;
import scripts.eBayShoppingTest;

public class MenuPage extends eBayShoppingTest{

	MobileElement signinButton= (MobileElement)driver.findElementById("com.ebay.mobile:id/logo");

	public void clickSigninText() { 
			signinButton.click();
	}
}
