package com.pritesh.runner;

// http://toolsqa.com/cucumber/junit-test-runner-class/

import com.cucumber.listener.Reporter;
import com.pritesh.dataprovider.FileReaderManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

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
  plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
)
// , dryRun = true
// @CucumberOptions(features = "./feature", glue={"pritesh.cucumberexample"})//, dryRun = true

public class CucumberTestRunnerExtendedReport {
  @AfterClass
  public static void writeExtentReport() {
    Reporter.loadXMLConfig(
        new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
    Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
    Reporter.setSystemInfo("Machine", "Mac OS X 10.13.4 x86_64");
    Reporter.setSystemInfo("Selenium", "3.10.0");
    Reporter.setSystemInfo("Gradle", "4.4");
    Reporter.setSystemInfo("Java Version", "1.8.0_101 (Oracle Corporation 25.101-b13)");
  }
}
// http://toolsqa.com/selenium-cucumber-framework/file-reader-manager-singleton-design-pattern/
// http://toolsqa.com/selenium-cucumber-framework/cucumber-extent-report/
// http://toolsqa.com/selenium-cucumber-framework/read-configurations-from-property-file/
// https://www.coveros.com/how-to-get-the-most-out-of-cucumber-tags/
