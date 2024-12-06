package com.cydeo.step_definitions;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.pages.SearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class Search_StepDef {

    SearchPage searchPage = new SearchPage();


    // @Given("I am on the home page")
    // public void i_am_on_the_home_page() {
    //     Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
    // }

    // @When("I login as a myself")
    // public void i_login_as_myself() {

    //     searchPage.searchPage(ConfigurationReader.getProperty("my_user"),ConfigurationReader.getProperty("my_pass"));
    // }

    // @Then("dashboard should be displayed")
    // public void dashboard_should_be_displayed() {

    //     BrowserUtils.sleep(3);
    //  String expectedURL = "dashboard";
    //  String actualURL = Driver.getDriver().getCurrentUrl();

    //     Assert.assertTrue(actualURL.contains(expectedURL));
    // }


}
