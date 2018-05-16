package com.pritesh.runner;

//http://toolsqa.com/cucumber/junit-test-runner-class/

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(plugin = {"pretty", "io.cucumber.pro.JsonReporter:all"})
//@CucumberOptions(features = {"./feature/First.feature","./feature/Second.feature"}, glue={"pritesh.cucumberexample"})//, dryRun = true
//@CucumberOptions(features = "./feature/First.feature", glue={"pritesh.cucumberexample"})//, dryRun = true
//@CucumberOptions(features = "src/test/resources/features/Second.feature", glue = {"com.pritesh"}, plugin = "html:target/selenium-reports")
@CucumberOptions(features = "src/test/resources/features/calculator/calculatorSum.feature",
        glue = {"com.pritesh"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"})
//format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
//, dryRun = true
//@CucumberOptions(features = "./feature", glue={"pritesh.cucumberexample"})//, dryRun = true

public class CucumberCalculatorTestRunner {
    @BeforeClass
    public static void setUp() {
        System.out.println("BeforeClass - CucumberCalculatorTestRunner ");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("AfterClass - CucumberCalculatorTestRunner ");
    }
}
