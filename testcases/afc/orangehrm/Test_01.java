package afc.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_01 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void TC_01_Title() {
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }

    @Test
    public void TC_02_Form() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='orangehrm-login-form']")).isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
