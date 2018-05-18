package com.pritesh;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.Map;

public class KeyValuesSteps {
  @Given("^I am on home page of xyz site$")
  public void i_am_on_home_page_of_xyz_site() {
    System.out.println("Navigate to home page \n");
  }

  @Given("^I submit the form with below details$")
  public void i_submit_the_form_with_below_details(DataTable arg1) {
    Map<String, String> m = arg1.asMap(String.class, String.class);
    System.out.println("\nFilling form with below data\n");
    for (String k : m.keySet()) {
      System.out.println("Key -> " + k + " Value -> " + m.get(k));
    }
  }

  @Then("^I see that form submission is successful$")
  public void i_see_that_form_submission_is_successful() {
    System.out.println("\nVerify form success message");
  }
}
