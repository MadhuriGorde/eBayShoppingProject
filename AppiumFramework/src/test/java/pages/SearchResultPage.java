package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidElement;
import scripts.eBayShoppingTest;

public class SearchResultPage extends eBayShoppingTest {

	
	List<AndroidElement> resultItems=driver.findElements(By.id("com.ebay.mobile:id/textview_item_title"));

	public void selectItem() { 
		int resultNumber = resultItems.size();
		for (int i = 0; i < resultNumber; i++) { 
			String itemName = resultItems.get(i).getText();
			if (itemName.contains("QLED")) {
				resultItems.get(i).click();
				break;
			}
		}
	}

}
