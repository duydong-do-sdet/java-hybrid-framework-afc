package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorJQuery {

    public static WebTablePageObject getWebTablePage(WebDriver driver) {
        return new WebTablePageObject(driver);
    }

}
