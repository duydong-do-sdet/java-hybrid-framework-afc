package pageObjects.myAccount;

import org.openqa.selenium.WebDriver;
import pageUIs.myAccount.AccountDashboardPageUI;

public class AccountDashboardPageObject extends MyAccountSidebar {
    private WebDriver driver;

    public AccountDashboardPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getRegisterSuccessMessage() {
        waitForElementToBeVisible(driver, AccountDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, AccountDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public String getWelcomeMessage() {
        waitForElementToBeVisible(driver, AccountDashboardPageUI.WELCOME_MESSAGE);
        return getElementText(driver, AccountDashboardPageUI.WELCOME_MESSAGE);
    }

    public String getContactInformationText() {
        waitForElementToBeVisible(driver, AccountDashboardPageUI.CONTACT_INFORMATION_TEXT);
        return getElementText(driver, AccountDashboardPageUI.CONTACT_INFORMATION_TEXT);
    }

    public boolean isPageTitleDisplayed() {
        waitForElementToBeVisible(driver, AccountDashboardPageUI.PAGE_TITLE);
        return isElementDisplayed(driver, AccountDashboardPageUI.PAGE_TITLE);
    }

}
