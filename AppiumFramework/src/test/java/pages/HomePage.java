package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import scripts.BaseClass;
import scripts.eBayShoppingTest;

public class HomePage extends eBayShoppingTest {

	
	MobileElement menuButton= (MobileElement)driver.findElementById("com.ebay.mobile:id/home");

	public void clickMenu() { 
			menuButton.click();
	}

	
	MobileElement tapSearch= (MobileElement)driver.findElementById("com.ebay.mobile:id/search_box");

	public void tapSearchBox() {
			tapSearch.click();
	}


	MobileElement searchTxtBox= (MobileElement)driver.findElementById("com.ebay.mobile:id/search_src_text");

	public void enterSearchKeyword(String keyword) { 
			searchTxtBox.sendKeys(keyword);
	}

}
