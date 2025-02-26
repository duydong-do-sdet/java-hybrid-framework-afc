package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.AccountDashboardPageObject;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

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

}
