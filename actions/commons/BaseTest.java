package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
    private WebDriver driver;

    protected WebDriver getWebDriver(String browserName, String appUrl) {
        switch (browserName) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Unsupported browser: " + browserName);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(appUrl);
        return driver;
    }

    protected int getRandomNumber() {
        return new Random().nextInt(10000);
    }

    protected boolean verifyTrue(boolean condition) {
        boolean isVerified = true;
        try {
            Assert.assertTrue(condition);
        } catch (Throwable failure) {
            isVerified = false;
            TestFailuresCollector.getTestFailure().addFailure(Reporter.getCurrentTestResult(), failure);
            Reporter.getCurrentTestResult().setThrowable(failure);
        }
        return isVerified;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean isVerified = true;
        try {
            Assert.assertFalse(condition);
        } catch (Throwable failure) {
            isVerified = false;
            TestFailuresCollector.getTestFailure().addFailure(Reporter.getCurrentTestResult(), failure);
            Reporter.getCurrentTestResult().setThrowable(failure);
        }
        return isVerified;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean isVerified = true;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable failure) {
            isVerified = false;
            TestFailuresCollector.getTestFailure().addFailure(Reporter.getCurrentTestResult(), failure);
            Reporter.getCurrentTestResult().setThrowable(failure);
        }
        return isVerified;
    }

}
