package com.pritesh;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ReuseUsingBackgrounds {
  @Given("^I filter some records$")
  public void i_filter_some_records() {
    System.out.println("\n\nBackground - Filtering some records\n");
  }

  @Given("^I click on the delete button of the first record$")
  public void i_click_on_the_delete_button_of_the_first_record() {
    System.out.println("Click delete button\n");
  }

  @Then("^I verify that record is removed from the table$")
  public void i_verify_that_record_is_removed_from_the_table() {
    System.out.println("Verify deleted record\n");
  }

  @Given("^I click on update button of the first record$")
  public void i_click_on_update_button_of_the_first_record() {
    System.out.println("Click update button\n");
  }

  @Then("^I verify that record opens in new window and we can modify it$")
  public void i_verify_that_record_opens_in_new_window_and_we_can_modify_it() {
    System.out.println("Verify modified record\n");
  }
}
