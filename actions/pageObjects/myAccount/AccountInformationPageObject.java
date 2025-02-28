package pageObjects.myAccount;

import org.openqa.selenium.WebDriver;
import pageUIs.myAccount.AccountInformationPageUI;

public class AccountInformationPageObject extends MyAccountSidebar {
    private WebDriver driver;

    public AccountInformationPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isPageTitleDisplayed() {
        waitForElementToBeVisible(driver, AccountInformationPageUI.PAGE_TITLE);
        return isElementDisplayed(driver, AccountInformationPageUI.PAGE_TITLE);
    }

}
