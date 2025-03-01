package pageObjects.portal.myAccount;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageObjects.portal.PortalHomePageObject;
import pageUIs.portal.myAccount.PortalAccountDashboardPageUI;

public class PortalAccountDashboardPageObject extends PortalMyAccountSidebar {
    private WebDriver driver;

    public PortalAccountDashboardPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getRegisterSuccessMessage() {
        waitForElementToBeVisible(driver, PortalAccountDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, PortalAccountDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public String getWelcomeMessage() {
        waitForElementToBeVisible(driver, PortalAccountDashboardPageUI.WELCOME_MESSAGE);
        return getElementText(driver, PortalAccountDashboardPageUI.WELCOME_MESSAGE);
    }

    public String getContactInformationText() {
        waitForElementToBeVisible(driver, PortalAccountDashboardPageUI.CONTACT_INFORMATION_TEXT);
        return getElementText(driver, PortalAccountDashboardPageUI.CONTACT_INFORMATION_TEXT);
    }

    public boolean isPageTitleDisplayed() {
        waitForElementToBeVisible(driver, PortalAccountDashboardPageUI.PAGE_TITLE);
        return isElementDisplayed(driver, PortalAccountDashboardPageUI.PAGE_TITLE);
    }

    public PortalHomePageObject selectLogoutInMyAccountHeaderDropdown() {
        waitForElementToBeClickable(driver, PortalAccountDashboardPageUI.MY_ACCOUNT_HEADER_DROPDOWN);
        selectOptionInCustomDropdown(driver, PortalAccountDashboardPageUI.MY_ACCOUNT_HEADER_DROPDOWN, PortalAccountDashboardPageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Log Out");
        sleepForSeconds(8);
        return PageGeneratorManager.getPortalHomePage(driver);
    }

}
