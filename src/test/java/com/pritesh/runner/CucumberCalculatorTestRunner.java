package com.pritesh.runner;

//http://toolsqa.com/cucumber/junit-test-runner-class/

import com.cucumber.listener.Reporter;
import com.pritesh.dataprovider.FileReaderManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

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
    /*
    @BeforeClass
    public static void setUp() {
        System.out.println("BeforeClass - CucumberCalculatorTestRunner ");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("AfterClass - CucumberCalculatorTestRunner ");
    }
    */

    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", "Mac OS X 10.13.4 x86_64");
        Reporter.setSystemInfo("Selenium", "3.10.0");
        Reporter.setSystemInfo("Gradle", "4.4");
        Reporter.setSystemInfo("Java Version", "1.8.0_101 (Oracle Corporation 25.101-b13)");
    }
}
