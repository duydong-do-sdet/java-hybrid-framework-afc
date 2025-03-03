package pageObjects.magento.portal;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageObjects.magento.portal.myAccount.PortalAccountDashboardPageObject;
import pageUIs.magento.portal.PortalRegisterPageUI;

public class PortalRegisterPageObject extends BasePage {
    private WebDriver driver;

    public PortalRegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeysToFirstNameTextbox(String firstName) {
        waitForElementToBeVisible(driver, PortalRegisterPageUI.FIRSTNAME_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void sendKeysToLastNameTextbox(String lastName) {
        waitForElementToBeVisible(driver, PortalRegisterPageUI.LASTNAME_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterPageUI.LASTNAME_TEXTBOX, lastName);
    }

    public void sendKeysToEmailTextbox(String emailAddress) {
        waitForElementToBeVisible(driver, PortalRegisterPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void sendKeysToPasswordTextbox(String password) {
        waitForElementToBeVisible(driver, PortalRegisterPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void sendKeysToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementToBeVisible(driver, PortalRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    public PortalAccountDashboardPageObject clickRegisterButton() {
        waitForElementToBeClickable(driver, PortalRegisterPageUI.REGISTER_BUTTON);
        clickElement(driver, PortalRegisterPageUI.REGISTER_BUTTON);
        acceptAlert(driver);
        return PageGeneratorManager.getPortalAccountDashboardPage(driver);
    }

    public PortalAccountDashboardPageObject registerNewUserAccount(String firstName, String lastName, String emailAddress, String password) {
        sendKeysToFirstNameTextbox(firstName);
        sendKeysToLastNameTextbox(lastName);
        sendKeysToEmailTextbox(emailAddress);
        sendKeysToPasswordTextbox(password);
        sendKeysToConfirmPasswordTextbox(password);
        return clickRegisterButton();
    }

}
