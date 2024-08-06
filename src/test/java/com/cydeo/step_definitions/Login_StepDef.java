package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Login_StepDef {

    private static final Logger log = LoggerFactory.getLogger(Login_StepDef.class);

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
     LoginPage loginPage = new LoginPage();

     loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("lib27_user"));
     loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("lib27_pass"));
     loginPage.signinBtn.click();
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        BrowserUtils.sleep(3);
     String expectedURL = "dashboard";
     String actualURL = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expectedURL));
    }
}
