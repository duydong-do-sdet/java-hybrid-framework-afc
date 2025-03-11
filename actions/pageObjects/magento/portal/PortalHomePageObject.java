package pageObjects.magento.portal;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.magento.portal.PortalHomePageUI;

public class PortalHomePageObject extends BasePage {
    private WebDriver driver;

    public PortalHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Select 'Register' option from 'Account' header dropdown")
    public PortalRegisterPageObject selectRegisterInMyAccountHeaderDropdown() {
        waitForElementToBeClickable(driver, PortalHomePageUI.MY_ACCOUNT_HEADER_DROPDOWN);
        selectOptionInCustomDropdown(driver, PortalHomePageUI.MY_ACCOUNT_HEADER_DROPDOWN, PortalHomePageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Register");
        return PageGeneratorManager.getPortalRegisterPage(driver);
    }

    @Step("Select 'Login' option from 'Account' header dropdown")
    public PortalLoginPageObject selectLoginInMyAccountHeaderDropdown() {
        waitForElementToBeClickable(driver, PortalHomePageUI.MY_ACCOUNT_HEADER_DROPDOWN);
        selectOptionInCustomDropdown(driver, PortalHomePageUI.MY_ACCOUNT_HEADER_DROPDOWN, PortalHomePageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Log In");
        return PageGeneratorManager.getPortalLoginPage(driver);
    }

}
