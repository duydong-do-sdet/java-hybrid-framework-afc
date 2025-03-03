package pageObjects.magento.admin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.magento.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    private WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeysToUserNameTextbox(String userName) {
        waitForElementToBeVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
        sendKeysToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, userName);
    }

    public void sendKeysToPasswordTextbox(String password) {
        waitForElementToBeVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public AdminManageCustomersPageObject clickLoginButton() {
        waitForElementToBeClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getAdminManageCustomersPage(driver);
    }

}
