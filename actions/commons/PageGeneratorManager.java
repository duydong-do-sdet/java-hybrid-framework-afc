package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.AdminManageCustomersPageObject;
import pageObjects.portal.PortalHomePageObject;
import pageObjects.portal.PortalLoginPageObject;
import pageObjects.portal.PortalRegisterPageObject;
import pageObjects.portal.myAccount.PortalAccountDashboardPageObject;
import pageObjects.portal.myAccount.PortalAccountInformationPageObject;
import pageObjects.portal.myAccount.PortalAddressBookPageObject;

public class PageGeneratorManager {

    // Portal pages

    public static PortalHomePageObject getPortalHomePage(WebDriver driver) {
        return new PortalHomePageObject(driver);
    }

    public static PortalRegisterPageObject getPortalRegisterPage(WebDriver driver) {
        return new PortalRegisterPageObject(driver);
    }

    public static PortalAccountDashboardPageObject getPortalAccountDashboardPage(WebDriver driver) {
        return new PortalAccountDashboardPageObject(driver);
    }

    public static PortalAccountInformationPageObject getPortalAccountInformationPage(WebDriver driver) {
        return new PortalAccountInformationPageObject(driver);
    }

    public static PortalAddressBookPageObject getPortalAddressBookPage(WebDriver driver) {
        return new PortalAddressBookPageObject(driver);
    }

    public static PortalLoginPageObject getPortalLoginPage(WebDriver driver) {
        return new PortalLoginPageObject(driver);
    }

    // Admin pages

    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPageObject(driver);
    }

    public static AdminManageCustomersPageObject getAdminManageCustomersPage(WebDriver driver) {
        return new AdminManageCustomersPageObject(driver);
    }

}
