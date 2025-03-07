package commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    protected final Logger log = LogManager.getLogger(getClass());

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

    protected void verifyTrue(boolean condition) {
        try {
            Assert.assertTrue(condition);
            log.info("---------------------- PASSED ----------------------");
        } catch (Throwable failure) {
            TestFailuresCollector.getTestFailure().addFailure(Reporter.getCurrentTestResult(), failure);
            Reporter.getCurrentTestResult().setThrowable(failure);
            log.info("---------------------- FAILED ----------------------");
        }
    }

    protected void verifyFalse(boolean condition) {
        try {
            Assert.assertFalse(condition);
            log.info("---------------------- PASSED ----------------------");
        } catch (Throwable failure) {
            TestFailuresCollector.getTestFailure().addFailure(Reporter.getCurrentTestResult(), failure);
            Reporter.getCurrentTestResult().setThrowable(failure);
            log.info("---------------------- FAILED ----------------------");
        }
    }

    protected void verifyEquals(Object actual, Object expected) {
        try {
            Assert.assertEquals(actual, expected);
            log.info("---------------------- PASSED ----------------------");
        } catch (Throwable failure) {
            TestFailuresCollector.getTestFailure().addFailure(Reporter.getCurrentTestResult(), failure);
            Reporter.getCurrentTestResult().setThrowable(failure);
            log.info("---------------------- FAILED ----------------------");
        }
    }

}
