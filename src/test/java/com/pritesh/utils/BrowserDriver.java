package com.pritesh.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

// https://seleniumjava.com/2017/08/10/use-a-custom-driver-class-instead-of-utility-classes/
// https://gist.github.com/arunma/3206905
// https://gist.github.com/tjmaher/4d5c3a523cca6d79b8e7
// http://automationtestingutilities.blogspot.com/p/blog-page.html
//
public final class BrowserDriver implements WebDriver {

    private final String browserName;
    private final int timeout = 30;
    private final String chromeDriverPath = "./driver/chromedriver";
    private final String firefoxDriverPath = "./driver/geckodriver";
    private WebDriver driver;

    public BrowserDriver(String browserName) {
        this.browserName = browserName;
        this.driver = createDriver(browserName);
    }

    private WebDriver createDriver(String browserName) {
        if (browserName.toUpperCase().equals(DRIVER_NAME.FIREFOX)) return firefoxDriver();

        if (browserName.toUpperCase().equals(DRIVER_NAME.CHROME)) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.addArguments("--start-maximized");

            return chromeDriver();
        }

        throw new RuntimeException("invalid browser name");
    }

    private WebDriver chromeDriver() {
        if (!new File(chromeDriverPath).exists())
            throw new RuntimeException("chromedriver does not exist!");

        try {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            return new ChromeDriver();
        } catch (Exception ex) {
            throw new RuntimeException("couldnt create chrome driver");
        }
    }

    private WebDriver firefoxDriver() {
        if (!new File(firefoxDriverPath).exists())
            throw new RuntimeException("firefoxdriver does not exist!");
        try {
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            return new FirefoxDriver();
        } catch (Exception ex) {
            throw new RuntimeException("could not create the firefox driver");
        }
    }

    @Override
    public String toString() {
        return this.browserName;
    }

    public WebDriver driver() {
        return this.driver;
    }

    @Override
    public void close() {
        driver().close();
    }

    @Override
    public WebElement findElement(By locator) {
        return driver().findElement(locator);
    }

    @Override
    public List findElements(By arg0) {
        return driver().findElements(arg0);
    }

    @Override
    public void get(String arg0) {
        driver().get(arg0);
    }

    @Override
    public String getCurrentUrl() {
        return driver().getCurrentUrl();
    }

    @Override
    public String getPageSource() {
        return driver().getPageSource();
    }

    @Override
    public String getTitle() {
        return driver().getTitle();
    }

    @Override
    public String getWindowHandle() {
        return driver().getWindowHandle();
    }

    @Override
    public Set getWindowHandles() {
        return driver().getWindowHandles();
    }

    @Override
    public Options manage() {
        return driver().manage();
    }

    @Override
    public Navigation navigate() {
        return driver().navigate();
    }

    @Override
    public void quit() {
        driver().quit();
    }

    @Override
    public TargetLocator switchTo() {
        return driver().switchTo();
    }

    public WebElement findVisibleElement(By locator) {
        WebElement element =
                new WebDriverWait(driver(), timeout).until(visibilityOfElementLocated(locator));
        return element;
    }

    public WebElement findClickableElement(By locator) {
        WebElement element = new WebDriverWait(driver(), timeout).until(elementToBeClickable(locator));
        return element;
    }

    public WebElement findHiddenElement(By locator) {
        WebElement element =
                new WebDriverWait(driver(), timeout).until(presenceOfElementLocated(locator));
        return element;
    }

    public static class DRIVER_NAME {
        public static String CHROME = "CHROME";
        public static String FIREFOX = "FIREFOX";
    }
}
