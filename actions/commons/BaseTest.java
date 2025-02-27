package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

}
