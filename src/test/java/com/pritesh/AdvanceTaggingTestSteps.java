package com.pritesh;

import com.pritesh.utils.BrowserDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AdvanceTaggingTestSteps {
  private WebDriver driver;

  @Given("^I want to use the browser Firefox$")
  public void i_want_to_use_the_browser_Firefox() {
    driver = new BrowserDriver(BrowserDriver.DRIVER_NAME.FIREFOX);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @When("^I set the username to \"([^\"]*)\"$")
  public void i_set_the_username_to(String arg1) {
    driver.get("http://www.google.com");
  }

  @When("^I set the password to \"([^\"]*)\"$")
  public void i_set_the_password_to(String arg1) {}

  @When("^I login to CosmicComix$")
  public void i_login_to_CosmicComix() {}

  @Then("^I see the error message \"([^\"]*)\"$")
  public void i_see_the_error_message(String arg1) {
    System.out.println("i_see_the_error_message : " + arg1);
  }

  @Then("^I am on the login page$")
  public void i_am_on_the_login_page() {}

  @Given("^I want to use the browser \"([^\"]*)\"$")
  public void i_want_to_use_the_browser(String arg1) {
    System.out.println("i_want_to_use_the_browser : " + arg1);
    if (arg1.equals("Firefox")) {
      driver = new BrowserDriver(BrowserDriver.DRIVER_NAME.FIREFOX);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    } else if (arg1.equals("Chrome")) {
      driver = new BrowserDriver(BrowserDriver.DRIVER_NAME.CHROME);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
  }

  @When("^I set the username to testUserName$")
  public void i_set_the_username_to_testUserName() {}

  @When("^I set the password to testUserPassword$")
  public void i_set_the_password_to_testUserPassword() {}

  @Then("^I am on the launcher page$")
  public void i_am_on_the_launcher_page() {}
}
