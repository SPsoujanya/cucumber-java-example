package com.pritesh;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OutLineSixthTest {
  @Given("^I open the application$")
  public void i_open_the_application() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("i_open_the_application");
  }

  @When("^I enter username as \"([^\"]*)\"$")
  public void i_enter_username_as(String arg1) {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("i_enter_username_as " + arg1);
  }

  @When("^I enter password as \"([^\"]*)\"$")
  public void i_enter_password_as(String arg1) {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("i_enter_password_as " + arg1);
  }

  @Then("^I enter title as \"([^\"]*)\"$")
  public void i_enter_title_as(String arg1) {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("i_enter_title_as " + arg1);
  }

  @Then("^press submit$")
  public void press_submit() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("press_submit");
  }
}
