package pageObjects.myAccount;

import org.openqa.selenium.WebDriver;
import pageUIs.myAccount.AddressBookPageUI;

public class AddressBookPageObject extends MyAccountSidebar {
    private WebDriver driver;

    public AddressBookPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isPageTitleDisplayed() {
        waitForElementToBeVisible(driver, AddressBookPageUI.PAGE_TITLE);
        return isElementDisplayed(driver, AddressBookPageUI.PAGE_TITLE);
    }

}
