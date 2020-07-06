package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import scripts.eBayShoppingTest;

public class SearchResultPage extends eBayShoppingTest {

	public SearchResultPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.ebay.mobile:id/textview_item_title") 
	List<AndroidElement> resultItems;

	public void selectItem() { 
		int resultNumber = resultItems.size();
			for (int i = 0; i < resultNumber; i++) { 
				String itemName = resultItems.get(i).getText();
				if (itemName.contains("65-inch TV")) {
					resultItems.get(i).click();
					break;
				}
			}
		}

}
