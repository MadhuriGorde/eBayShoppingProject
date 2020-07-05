package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import scripts.BaseClass;
import scripts.eBayShoppingTest;

public class LogInPage extends eBayShoppingTest{

	
	MobileElement unameTxtBox= (MobileElement)driver.findElementByXPath("//android.widget.EditText[@text='Email or username']");

	public void enterUsername(String uname) { 
		unameTxtBox.sendKeys(uname);
	}
	
	MobileElement pwordTxtBox= (MobileElement)driver.findElementByXPath("//android.widget.EditText[@text='Password']");


	public void enterPassword(String pword) { 
		pwordTxtBox.sendKeys(pword);
	}

	MobileElement buttonSignin= (MobileElement)driver.findElementById("com.ebay.mobile:id/button_sign_in");


	public void clickSigninButton() { 
		buttonSignin.click();
	}
	
	MobileElement denyButton= (MobileElement)driver.findElementById("com.ebay.mobile:id/button_google_deny");


	public void clickDenyButton() { 
		denyButton.click();
	}
	
	
}
