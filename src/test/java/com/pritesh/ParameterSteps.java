package com.pritesh;

import com.pritesh.utils.BrowserDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ParameterSteps {
    WebDriver driver;
    Scenario scenario;

    @Before("@selenium")
    public void launchBrowser(Scenario scenario) {
        driver = new BrowserDriver(BrowserDriver.DRIVER_NAME.CHROME);
        this.scenario = scenario;
        System.out.println("Executing scenario " + scenario.getName());
    }

    @After("@selenium")
    public void killBrowser() {
        scenario.write("Finished scenario");
        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
        }
        driver.close();
        driver.quit();
    }


    @Given("^I am on \"([^\"]*)\" page$")
    public void i_am_on_page(String arg1) {
        driver.get("http://" + arg1);
    }

    @Then("^I verify that the title is \"([^\"]*)\"$")
    public void i_verify_that_the_title_is(String arg1) {
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(arg1));
    }
}
