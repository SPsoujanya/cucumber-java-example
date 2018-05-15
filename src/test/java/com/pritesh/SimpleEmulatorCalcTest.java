package com.pritesh;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class SimpleEmulatorCalcTest extends AndroidDesiredCapabilitiesServer {
    @Before
    public void setUp() throws Exception {
        //Created object of DesiredCapabilities class.
        //setAndroidDesiredCapabilities("2WMDU17320000701", "6.0.1","com.asus.calculator","com.asus.calculator.Calculator");
        setAndroidDesiredCapabilities("2WMDU17320000701", "6.0.1", "com.android.calculator2", "com.android.calculator2.Calculator");
    }


    @After
    public void tearDown() {
        super.tearDown();
    }


    @Given("^I Open Calculator on Device$")
    public void i_Open_Calculator_on_Device() {

    }

    @When("^I enter Number One as \"([^\"]*)\"$")
    public void i_enter_Number_One_as(String a) {
        driver.findElement(By.id("digit" + a)).click();
    }

    @When("^I enter Operator \\+$")
    public void i_enter_Operator() {
        // Click on + button.
        driver.findElement(By.id("plus")).click();
    }

    @When("^I enter Number Two as \"([^\"]*)\"$")
    public void i_enter_Number_Two_as(String b) {
        // Click on number 5 button.
        driver.findElement(By.id("digit" + b)).click();
    }

    @Then("^I press Equal Keys on Device$")
    public void i_press_Equal_Keys_on_Device() {
        // Click on = button.
        driver.findElement(By.id("equal")).click();
    }

    @Then("^I verified the result \"([^\"]*)\"$")
    public void i_verified_the_result(String ans) {
        // Get result from result text box of calc app.
        //resultEditTextID
        String result = driver.findElement(By.className("android.widget.EditText")).getText();
        System.out.println("Number sum result is : " + result);
        Assert.assertEquals(ans, result);
    }
}