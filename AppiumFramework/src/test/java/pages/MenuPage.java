package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import scripts.BaseClass;
import scripts.eBayShoppingTest;

public class MenuPage extends eBayShoppingTest{

	public MenuPage(AndroidDriver<AndroidElement> driver) { 
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.ebay.mobile:id/logo") 
	AndroidElement signinButton;

	public void clickSigninText() { 
			signinButton.click();
	}
}
