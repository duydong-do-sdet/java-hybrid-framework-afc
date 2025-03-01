package pageObjects.admin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminManageCustomersPageUI;

public class AdminManageCustomersPageObject extends BasePage {
    private WebDriver driver;

    public AdminManageCustomersPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void closePopup() {
        waitForElementToBeVisible(driver, AdminManageCustomersPageUI.POPUP_CLOSE_BUTTON);
        clickElement(driver, AdminManageCustomersPageUI.POPUP_CLOSE_BUTTON);
    }

    public boolean isUserInfoDisplayed(String firstName, String emailAddress) {
        String customerInfo = "//td[contains(text(),'" + firstName + "')]/following-sibling::td[contains(text(),'" + emailAddress + "')]";
        waitForElementToBeVisible(driver, customerInfo);
        return isElementDisplayed(driver, customerInfo);
    }

    public void deleteUserAccount(String firstName, String emailAddress) {
        String checkbox = "//td[contains(text(),'" + firstName + "')]/following-sibling::td[contains(text(),'" + emailAddress + "')]/parent::tr//input[@type='checkbox']";
        waitForElementToBeClickable(driver, checkbox);
        checkDefaultCheckboxOrRadioButton(driver, checkbox);
        waitForElementToBeClickable(driver, AdminManageCustomersPageUI.ACTIONS_DROPDOWN);
        selectOptionInDefaultDropdown(driver, AdminManageCustomersPageUI.ACTIONS_DROPDOWN, "Delete");
        waitForElementToBeClickable(driver, AdminManageCustomersPageUI.SUBMIT_BUTTON);
        clickElement(driver, AdminManageCustomersPageUI.SUBMIT_BUTTON);
        acceptAlert(driver);
        acceptAlert(driver);
    }

    public String getDeletedSuccessMessage() {
        waitForElementToBeVisible(driver, AdminManageCustomersPageUI.DELETED_SUCCESS_MESSAGE);
        return getElementText(driver, AdminManageCustomersPageUI.DELETED_SUCCESS_MESSAGE);
    }

    public AdminLoginPageObject clickLogout() {
        waitForElementToBeClickable(driver, AdminManageCustomersPageUI.LOGOUT_LINK);
        clickElement(driver, AdminManageCustomersPageUI.LOGOUT_LINK);
        return PageGeneratorManager.getAdminLoginPage(driver);
    }

}
