package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    // WebDriver methods

    protected void openPage(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    protected String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    protected String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    protected String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    protected String getWindowID(WebDriver driver) {
        return driver.getWindowHandle();
    }

    protected Set<String> getAllWindowIDs(WebDriver driver) {
        return driver.getWindowHandles();
    }

    protected void navigateBack(WebDriver driver) {
        driver.navigate().back();
    }

    protected void navigateForward(WebDriver driver) {
        driver.navigate().forward();
    }

    protected void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    protected void navigateToUrl(WebDriver driver, String pageUrl) {
        driver.navigate().to(pageUrl);
    }

    private Alert waitForAlert(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.alertIsPresent());
    }

    protected void acceptAlert(WebDriver driver) {
        waitForAlert(driver).accept();
    }

    protected void dismissAlert(WebDriver driver) {
        waitForAlert(driver).dismiss();
    }

    protected String getAlertText(WebDriver driver) {
        return waitForAlert(driver).getText();
    }

    protected void sendKeysToAlert(WebDriver driver, String keysToSend) {
        waitForAlert(driver).sendKeys(keysToSend);
    }

    protected void switchToOtherWindowByCurrentID(WebDriver driver, String windowID) {
        Set<String> allWindowIDs = getAllWindowIDs(driver);
        for (String id : allWindowIDs) {
            if (!id.equals(windowID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    protected void switchToWindowByTitle(WebDriver driver, String windowTitle) {
        Set<String> allWindowIDs = getAllWindowIDs(driver);
        for (String id : allWindowIDs) {
            driver.switchTo().window(id);
            if (getPageTitle(driver).equals(windowTitle)) {
                break;
            }
        }
    }

    protected void closeAllWindowsExceptWindowByID(WebDriver driver, String windowID) {
        Set<String> allWindowIDs = getAllWindowIDs(driver);
        for (String id : allWindowIDs) {
            if (!id.equals(windowID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(windowID);
    }

    // WebElement methods

    private By getByXPath(String xpathLocator) {
        return By.xpath(xpathLocator);
    }

    protected WebElement getWebElement(WebDriver driver, String xpathLocator) {
        return driver.findElement(getByXPath(xpathLocator));
    }

    protected List<WebElement> getWebElements(WebDriver driver, String xpathLocator) {
        return driver.findElements(getByXPath(xpathLocator));
    }

    protected void clickElement(WebDriver driver, String xpathLocator) {
        getWebElement(driver, xpathLocator).click();
    }

    protected void sendKeysToElement(WebDriver driver, String xpathLocator, String keysToSend) {
        WebElement element = getWebElement(driver, xpathLocator);
        element.clear();
        element.sendKeys(keysToSend);
    }

    protected String getElementText(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).getText();
    }

    protected String getElementDomAttribute(WebDriver driver, String xpathLocator, String attributeName) {
        return getWebElement(driver, xpathLocator).getDomAttribute(attributeName);
    }

    protected String getElementDomProperty(WebDriver driver, String xpathLocator, String propertyName) {
        return getWebElement(driver, xpathLocator).getDomProperty(propertyName);
    }

    protected String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
        return getWebElement(driver, xpathLocator).getCssValue(propertyName);
    }

    protected String getElementColorHex(WebDriver driver, String xpathLocator, String propertyName) {
        return Color.fromString(getElementCssValue(driver, xpathLocator, propertyName)).asHex().toUpperCase();
    }

    protected int getElementCount(WebDriver driver, String xpathLocator) {
        return getWebElements(driver, xpathLocator).size();
    }

    protected boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isDisplayed();
    }

    protected boolean isElementEnabled(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isEnabled();
    }

    protected boolean isElementSelected(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isSelected();
    }

    protected void selectOptionInDefaultDropdown(WebDriver driver, String xpathLocator, String optionValue) {
        new Select(getWebElement(driver, xpathLocator)).selectByVisibleText(optionValue);
    }

    protected String getSelectedOptionValueInDefaultDropdown(WebDriver driver, String xpathLocator) {
        return new Select(getWebElement(driver, xpathLocator)).getFirstSelectedOption().getText();
    }

    protected boolean isDefaultDropdownMultiple(WebDriver driver, String xpathLocator) {
        return new Select(getWebElement(driver, xpathLocator)).isMultiple();
    }

    protected void checkDefaultCheckboxOrRadioButton(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver, xpathLocator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void uncheckDefaultCheckbox(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver, xpathLocator);
        if (element.isSelected()) {
            element.click();
        }
    }

    protected void switchToFrame(WebDriver driver, String xpathLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByXPath(xpathLocator)));
    }

    protected void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    // Actions methods

    protected void moveToElement(WebDriver driver, String xpathLocator) {
        new Actions(driver).moveToElement(getWebElement(driver, xpathLocator)).perform();
    }

    protected void clickAndHoldOnElement(WebDriver driver, String xpathLocator) {
        new Actions(driver).clickAndHold(getWebElement(driver, xpathLocator)).perform();
    }

    protected void releaseMouseFromElement(WebDriver driver, String xpathLocator) {
        new Actions(driver).release(getWebElement(driver, xpathLocator)).perform();
    }

    protected void rightClickOnElement(WebDriver driver, String xpathLocator) {
        new Actions(driver).contextClick(getWebElement(driver, xpathLocator)).perform();
    }

    protected void doubleClickOnElement(WebDriver driver, String xpathLocator) {
        new Actions(driver).doubleClick(getWebElement(driver, xpathLocator)).perform();
    }

    protected void pressKeyOnElement(WebDriver driver, String xpathLocator, Keys key) {
        new Actions(driver).sendKeys(getWebElement(driver, xpathLocator), key).perform();
    }

    // JavascriptExecutor methods

    protected Object executeJS(WebDriver driver, String javascript) {
        return ((JavascriptExecutor) driver).executeScript(javascript);
    }

    protected void scrollToTopPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-document.body.scrollHeight);");
    }

    protected void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight);");
    }

    protected void scrollElementIntoViewTopByJS(WebDriver driver, String xpathLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
    }

    protected void scrollElementIntoViewBottomByJS(WebDriver driver, String xpathLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, xpathLocator));
    }

    protected void clickElementByJS(WebDriver driver, String xpathLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
    }

    protected String getElementValidationMessageByJS(WebDriver driver, String xpathLocator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
    }

    protected void setElementAttributeByJS(WebDriver driver, String xpathLocator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getWebElement(driver, xpathLocator));
    }

    protected void removeElementAttributeByJS(WebDriver driver, String xpathLocator, String attributeName) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeName + "');", getWebElement(driver, xpathLocator));
    }

    protected void highlightElementByJS(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver, xpathLocator);
        String originalStyle = element.getDomAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'border: 2px solid red; border-style: dashed;');", element);
        sleepForSeconds(oneSecond);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);
    }

    protected boolean isImageDisplayedByJS(WebDriver driver, String xpathLocator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0;", getWebElement(driver, xpathLocator));
    }

    // Wait methods

    protected void waitForPageReady(WebDriver driver) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(WebDriver -> (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof jQuery === 'undefined' || (jQuery.active === 0)) && document.readyState === 'complete';"));
        } catch (TimeoutException e) {
            throw new RuntimeException("Page load timeout exceeded!", e);
        }
    }

    protected void waitForElementToBeVisible(WebDriver driver, String xpathLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByXPath(xpathLocator)));
    }

    protected void waitForAllElementsToBeVisible(WebDriver driver, String xpathLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXPath(xpathLocator)));
    }

    protected void waitForElementToBeClickable(WebDriver driver, String xpathLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getByXPath(xpathLocator)));
    }

    // Custom methods

    protected void selectOptionInCustomDropdown(WebDriver driver, String dropdownXPath, String allOptionsXPath, String expectedOption) {
        clickElement(driver, dropdownXPath);
        sleepForSeconds(oneSecond);
        List<WebElement> allOptions = new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allOptionsXPath)));
        for (WebElement option : allOptions) {
            if (option.getText().trim().equals(expectedOption)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
                sleepForSeconds(oneSecond);
                option.click();
                sleepForSeconds(oneSecond);
                break;
            }
        }
    }

    protected void sleepForSeconds(long timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Common constants

    private final long longTimeout = GlobalConstants.LONG_TIMEOUT;
    private final long oneSecond = GlobalConstants.ONE_SECOND;

}
