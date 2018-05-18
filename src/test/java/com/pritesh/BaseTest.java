package com.pritesh;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class BaseTest {
  @After
  public void afterSuccessfulScenario(Scenario scenario) {
    if (!scenario.isFailed()) {
      System.out.println(scenario.getName() + " : -- Passed --");
    }
  }

  @After
  public void afterFailedScenario(Scenario scenario) {
    if (scenario.isFailed()) {
      System.out.println(scenario.getName() + " : [ Failed ]");
    }
  }
}
