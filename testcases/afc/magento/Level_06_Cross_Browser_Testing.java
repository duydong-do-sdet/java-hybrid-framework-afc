package afc.magento;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.AccountDashboardPageObject;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Level_06_Cross_Browser_Testing extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private AccountDashboardPageObject accountDashboardPage;
    private String firstName, lastName, fullName, emailAddress, password;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getWebDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getHomePage(driver);

        firstName = "Dong";
        lastName = "Do";
        fullName = firstName + " " + lastName;
        emailAddress = "dongafc" + getRandomNumber() + "@gmail.com";
        password = "SeJava@4";
    }

    @Test
    public void User_01_Register() {
        registerPage = homePage.selectRegisterInMyAccountHeaderDropdown();

        registerPage.sendKeysToFirstNameTextbox(firstName);

        registerPage.sendKeysToLastNameTextbox(lastName);

        registerPage.sendKeysToEmailTextbox(emailAddress);

        registerPage.sendKeysToPasswordTextbox(password);

        registerPage.sendKeysToConfirmPasswordTextbox(password);

        accountDashboardPage = registerPage.clickRegisterButton();
    }

    @Test
    public void User_02_Verify() {
        Assert.assertEquals(accountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");

        Assert.assertEquals(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");

        String contactInfo = accountDashboardPage.getContactInformationText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
