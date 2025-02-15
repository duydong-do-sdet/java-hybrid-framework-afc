package afc.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Level_01_Dont_Repeat_Yourself {
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
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

        driver.findElement(By.xpath("//button[contains(@class,'login-button')]")).click();
        sleepForSeconds(3);

        Assert.assertTrue(driver.findElement(By.xpath("//nav[@class='oxd-navbar-nav']//span[text()='Admin']")).isDisplayed());
    }

    @Test
    public void TC_02_Add_Employee() {
        driver.findElement(By.xpath("//nav[@class='oxd-navbar-nav']//span[text()='PIM']")).click();

        driver.findElement(By.xpath("//div[@class='oxd-topbar-body']//a[text()='Add Employee']")).click();
        sleepForSeconds(3);

        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);

        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//p[text()='Create Login Details']/parent::div//input[@type='checkbox']")));

        driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys(userName);

        driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).sendKeys(password);

        driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys(password);

        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        sleepForSeconds(8);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='orangehrm-edit-employee-name']/h6")).getText(), fullName);
    }

    @Test
    public void TC_03_Login_As_Employee() {
        selectOptionInCustomDropdown("//li[@class='oxd-userdropdown']", "//ul[@class='oxd-dropdown-menu']//a", "Logout");

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

        driver.findElement(By.xpath("//button[contains(@class,'login-button')]")).click();
        sleepForSeconds(3);

        driver.findElement(By.xpath("//nav[@class='oxd-navbar-nav']//span[text()='My Info']")).click();
        sleepForSeconds(3);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='orangehrm-edit-employee-name']/h6")).getText(), fullName);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepForSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getRandomNumber() {
        return new Random().nextInt(10000);
    }

    public void selectOptionInCustomDropdown(String dropdownXPath, String allOptionsXPath, String expectedOption) {
        driver.findElement(By.xpath(dropdownXPath)).click();
        sleepForSeconds(1);
        List<WebElement> allOptions = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allOptionsXPath)));
        for (WebElement option : allOptions) {
            if (option.getText().trim().equals(expectedOption)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
                sleepForSeconds(1);
                option.click();
                sleepForSeconds(1);
                break;
            }
        }
    }

}
