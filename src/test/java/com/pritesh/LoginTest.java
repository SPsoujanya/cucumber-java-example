package com.pritesh;

import com.pritesh.utils.BrowserDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void before() {
        System.out.println(System.getProperty("user.dir"));
        driver = new BrowserDriver(BrowserDriver.DRIVER_NAME.CHROME);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void after() {
        driver.close();
        driver.quit();
    }

    @Given("^User is on Home Page$")
    public void user_is_on_Home_Page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        //driver = new BrowserDriver(BrowserDriver.DRIVER_NAME.CHROME);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.store.demoqa.com");
    }

    @When("^User Navigate to LogIn Page$")
    public void user_Navigate_to_LogIn_Page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
    }

    @When("^User enters UserName and Password$")
    public void user_enters_UserName_and_Password() {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        driver.findElement(By.id("log")).sendKeys("testuser_1");
        driver.findElement(By.id("pwd")).sendKeys("Test@123");
        driver.findElement(By.id("login")).click();
    }

    @Then("^Message displayed Login Successfully$")
    public void message_displayed_Login_Successfully() {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        System.out.println("Login Successfully");
    }

    @When("^User LogOut from the Application$")
    public void user_LogOut_from_the_Application() {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
    }

    @Then("^Message displayed LogOut Successfully$")
    public void message_displayed_Logout_Successfully() {
        System.out.println("LogOut Successfully");
    }

}