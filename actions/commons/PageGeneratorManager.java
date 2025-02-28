package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.myAccount.AccountDashboardPageObject;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;
import pageObjects.myAccount.AccountInformationPageObject;
import pageObjects.myAccount.AddressBookPageObject;

public class PageGeneratorManager {

    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver) {
        return new RegisterPageObject(driver);
    }

    public static AccountDashboardPageObject getAccountDashboardPage(WebDriver driver) {
        return new AccountDashboardPageObject(driver);
    }

    public static AccountInformationPageObject getAccountInformationPage(WebDriver driver) {
        return new AccountInformationPageObject(driver);
    }

    public static AddressBookPageObject getAddressBookPage(WebDriver driver) {
        return new AddressBookPageObject(driver);
    }

}
