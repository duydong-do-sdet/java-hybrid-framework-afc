package pageObjects.demo;

import org.openqa.selenium.WebDriver;

public class UndisplayedPageGenerator {

    public static UndisplayedPageObject getUndisplayedPage(WebDriver driver) {
        return new UndisplayedPageObject(driver);
    }

}
