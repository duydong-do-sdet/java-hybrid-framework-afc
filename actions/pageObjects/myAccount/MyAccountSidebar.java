package pageObjects.myAccount;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.myAccount.MyAccountSidebarUIs;

public class MyAccountSidebar extends BasePage {
    private WebDriver driver;

    public MyAccountSidebar(WebDriver driver) {
        this.driver = driver;
    }

    public AccountDashboardPageObject clickAccountDashboardSidebarLink() {
        waitForElementToBeClickable(driver, MyAccountSidebarUIs.ACCOUNT_DASHBOARD_SIDEBAR_LINK);
        clickElement(driver, MyAccountSidebarUIs.ACCOUNT_DASHBOARD_SIDEBAR_LINK);
        return PageGeneratorManager.getAccountDashboardPage(driver);
    }

    public AccountInformationPageObject clickAccountInformationSidebarLink() {
        waitForElementToBeClickable(driver, MyAccountSidebarUIs.ACCOUNT_INFORMATION_SIDEBAR_LINK);
        clickElement(driver, MyAccountSidebarUIs.ACCOUNT_INFORMATION_SIDEBAR_LINK);
        return PageGeneratorManager.getAccountInformationPage(driver);
    }

    public AddressBookPageObject clickAddressBookSidebarLink() {
        waitForElementToBeClickable(driver, MyAccountSidebarUIs.ADDRESS_BOOK_SIDEBAR_LINK);
        clickElement(driver, MyAccountSidebarUIs.ADDRESS_BOOK_SIDEBAR_LINK);
        return PageGeneratorManager.getAddressBookPage(driver);
    }

}
