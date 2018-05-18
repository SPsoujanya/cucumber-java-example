package com.pritesh.runner;

// http://toolsqa.com/cucumber/junit-test-runner-class/

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
// @CucumberOptions(plugin = {"pretty", "io.cucumber.pro.JsonReporter:all"})
// @CucumberOptions(features = {"./feature/First.feature","./feature/Second.feature"},
// glue={"pritesh.cucumberexample"})//, dryRun = true
// @CucumberOptions(features = "./feature/First.feature", glue={"pritesh.cucumberexample"})//,
// dryRun = true
// @CucumberOptions(features = "src/test/resources/features/Fifth.feature", glue = {"com.pritesh"},
// plugin = "html:target/selenium-reports")
@CucumberOptions(
  features = "src/test/resources/features/userLogin.feature",
  glue = {"com.pritesh"},
  // tags = {"@LoginTest"},
  format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"}
)
// , dryRun = true
// @CucumberOptions(features = "./feature", glue={"pritesh.cucumberexample"})//, dryRun = true

public class CucumberTestRunnerLogin {}

// https://www.coveros.com/how-to-get-the-most-out-of-cucumber-tags/
