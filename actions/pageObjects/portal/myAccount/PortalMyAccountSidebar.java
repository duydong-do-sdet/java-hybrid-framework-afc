package pageObjects.portal.myAccount;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.portal.myAccount.PortalMyAccountSidebarUIs;

public class PortalMyAccountSidebar extends BasePage {
    private WebDriver driver;

    public PortalMyAccountSidebar(WebDriver driver) {
        this.driver = driver;
    }

    public PortalAccountDashboardPageObject clickAccountDashboardSidebarLink() {
        waitForElementToBeClickable(driver, PortalMyAccountSidebarUIs.ACCOUNT_DASHBOARD_SIDEBAR_LINK);
        clickElement(driver, PortalMyAccountSidebarUIs.ACCOUNT_DASHBOARD_SIDEBAR_LINK);
        return PageGeneratorManager.getPortalAccountDashboardPage(driver);
    }

    public PortalAccountInformationPageObject clickAccountInformationSidebarLink() {
        waitForElementToBeClickable(driver, PortalMyAccountSidebarUIs.ACCOUNT_INFORMATION_SIDEBAR_LINK);
        clickElement(driver, PortalMyAccountSidebarUIs.ACCOUNT_INFORMATION_SIDEBAR_LINK);
        return PageGeneratorManager.getPortalAccountInformationPage(driver);
    }

    public PortalAddressBookPageObject clickAddressBookSidebarLink() {
        waitForElementToBeClickable(driver, PortalMyAccountSidebarUIs.ADDRESS_BOOK_SIDEBAR_LINK);
        clickElement(driver, PortalMyAccountSidebarUIs.ADDRESS_BOOK_SIDEBAR_LINK);
        return PageGeneratorManager.getPortalAddressBookPage(driver);
    }

}
