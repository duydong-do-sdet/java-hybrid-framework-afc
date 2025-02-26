package pageObjects;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPageObject selectRegisterInMyAccountHeaderDropdown() {
        waitForElementToBeClickable(driver, HomePageUI.MY_ACCOUNT_HEADER_DROPDOWN);
        selectOptionInCustomDropdown(driver, HomePageUI.MY_ACCOUNT_HEADER_DROPDOWN, HomePageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Register");
        return PageGeneratorManager.getRegisterPage(driver);
    }

}
