package pageObjects;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeysToFirstNameTextbox(String firstName) {
        waitForElementToBeVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
        sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void sendKeysToLastNameTextbox(String lastName) {
        waitForElementToBeVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
        sendKeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
    }

    public void sendKeysToEmailTextbox(String emailAddress) {
        waitForElementToBeVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void sendKeysToPasswordTextbox(String password) {
        waitForElementToBeVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void sendKeysToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementToBeVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    public AccountDashboardPageObject clickRegisterButton() {
        waitForElementToBeClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickElement(driver, RegisterPageUI.REGISTER_BUTTON);
        acceptAlert(driver);
        return PageGeneratorManager.getAccountDashboardPage(driver);
    }

}
