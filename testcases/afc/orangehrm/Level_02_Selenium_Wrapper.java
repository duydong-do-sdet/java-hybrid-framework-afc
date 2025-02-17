package afc.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_Selenium_Wrapper extends BasePage {
    WebDriver driver;
    String firstName, lastName, fullName, userName, password;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        firstName = "Dong";
        lastName = "Do";
        fullName = firstName + " " + lastName;
        userName = "dongdo" + getRandomNumber();
        password = "SeJava@4";
    }

    @Test
    public void TC_01_Login_As_Admin() {
        sendKeysToElement(driver, "//input[@name='username']", "Admin");

        sendKeysToElement(driver, "//input[@name='password']", "admin123");

        clickElement(driver, "//button[contains(@class,'login-button')]");
        sleepForSeconds(3);

        Assert.assertTrue(isElementDisplayed(driver, "//nav[@class='oxd-navbar-nav']//span[text()='Admin']"));
    }

    @Test
    public void TC_02_Add_Employee() {
        clickElement(driver, "//nav[@class='oxd-navbar-nav']//span[text()='PIM']");

        clickElement(driver, "//div[@class='oxd-topbar-body']//a[text()='Add Employee']");
        sleepForSeconds(3);

        sendKeysToElement(driver, "//input[@name='firstName']", firstName);

        sendKeysToElement(driver, "//input[@name='lastName']", lastName);

        clickElementByJS(driver, "//p[text()='Create Login Details']/parent::div//input[@type='checkbox']");

        sendKeysToElement(driver, "//label[text()='Username']/parent::div/following-sibling::div/input", userName);

        sendKeysToElement(driver, "//label[text()='Password']/parent::div/following-sibling::div/input", password);

        sendKeysToElement(driver, "//label[text()='Confirm Password']/parent::div/following-sibling::div/input", password);

        clickElement(driver, "//button[normalize-space()='Save']");
        sleepForSeconds(8);

        Assert.assertEquals(getElementText(driver, "//div[@class='orangehrm-edit-employee-name']/h6"), fullName);
    }

    @Test
    public void TC_03_Login_As_Employee() {
        selectOptionInCustomDropdown(driver, "//li[@class='oxd-userdropdown']", "//ul[@class='oxd-dropdown-menu']//a", "Logout");

        sendKeysToElement(driver, "//input[@name='username']", userName);

        sendKeysToElement(driver, "//input[@name='password']", password);

        clickElement(driver, "//button[contains(@class,'login-button')]");
        sleepForSeconds(3);

        clickElement(driver, "//nav[@class='oxd-navbar-nav']//span[text()='My Info']");
        sleepForSeconds(3);

        Assert.assertEquals(getElementText(driver, "//div[@class='orangehrm-edit-employee-name']/h6"), fullName);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public int getRandomNumber() {
        return new Random().nextInt(10000);
    }

}
