package com.pritesh;

import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class AndroidDesiredCapabilitiesServer {
  RemoteWebDriver driver;
  WebDriverWait wait;

  public void setAndroidDesiredCapabilities(
      String deviceName, String platformVersion, String appPackage, String appActivity)
      throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();

    // Set android deviceName desired capability. Set it Android Emulator/Device.
    // 2WMDU17320000701 - Pritesh's Android Phone
    // H4NPCV0285852WX - Asus Zen Tablet
    capabilities.setCapability("deviceName", deviceName);

    // Set browserName desired capability. It's Android in our case here.
    capabilities.setCapability("device", "Android");

    // Set android platformVersion desired capability. Set your emulator's android version.
    capabilities.setCapability("platformVersion", platformVersion);

    // Set android platformName desired capability. It's Android in our case here.
    capabilities.setCapability("platformName", "Android");

    // Set android appPackage desired capability. It is com.android.calculator2 for calculator
    // application.
    // Set your application's appPackage if you are using any other app.
    capabilities.setCapability("appPackage", appPackage);

    // Set android appActivity desired capability. It is com.android.calculator2.Calculator for
    // calculator application.
    // Set your application's appPackage if you are using any other app.
    capabilities.setCapability("appActivity", appActivity);

    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
    // capabilities.setCapability("autoGrantPermissions", true);
    capabilities.setCapability("noReset", "true");

    // Created object of RemoteWebDriver will all set capabilities.
    // Set appium server address and port number in URL string.
    // It will launch calculator app in emulator.
    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 10);

    getUserAndroidArtifactsPath();
    getAndroiDeviceVersion();
  }

  private void getUserAndroidArtifactsPath() {
    // Expected : PATH : /Users/pritesh.patel/Documents/SelenimuPNP
    String userDir = System.getProperty("user.dir");
    System.out.println("PATH : " + userDir);
  }

  private void getAndroiDeviceVersion() {
    Process processResult = null;
    try {
      processResult = Runtime.getRuntime().exec("adb shell getprop | grep build.version.release");
      // result.getInputStream().read(data);
      // [ro.build.version.release]: [7.0]
      String version = IOUtils.toString(processResult.getInputStream(), StandardCharsets.UTF_8);
      System.out.println("ADB DEVICE INFO : " + version);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  protected boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
