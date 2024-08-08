package com.cydeo.step_definitions;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class Login_StepDef {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {


//     loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("lib27_user"));
//     loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("lib27_pass"));
//     loginPage.signinBtn.click();

        loginPage.login(ConfigurationReader.getProperty("lib27_user"),ConfigurationReader.getProperty("lib27_pass"));
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        BrowserUtils.sleep(3);
     String expectedURL = "dashboard";
     String actualURL = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expectedURL));
    }

    @When("I login as a student")
    public void iLoginAsAStudent() {
     loginPage.login(ConfigurationReader.getProperty("student27_user"),ConfigurationReader.getProperty("student27_pass"));
    }

    @Then("books should be displayed")
    public void booksShouldBeDisplayed() {

        BrowserUtils.waitForURLContains("books");
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("books"));
    }

    @When("I log in using {string} and {string}")
    public void iLogInUsingAnd(String email, String password) {
        loginPage.login(email,password);
    }

    @And("there should be {int} users")
    public void thereShouldBeUsers(int expectedUserAmount) {
        BrowserUtils.waitForVisibility(dashboardPage.userAmount,10);
        BrowserUtils.sleep(3);
        String actualUserAmount = dashboardPage.userAmount.getText();
        String expectedUserCount = String.valueOf(expectedUserAmount); // expectedUserAmount+""
        Assert.assertEquals(expectedUserCount,actualUserAmount);
    }

    @Then("account holder name should be {string}")
    public void accountHolderNameShouldBe(String expectedAccountName) {
     BrowserUtils.waitForVisibility(dashboardPage.userInfo,15);
  //   BrowserUtils.sleep(3);
     String actualAccountName = dashboardPage.userInfo.getText();
     Assert.assertEquals(expectedAccountName,actualAccountName);
    }


    @When("user enters the librarian information from the environment")
    public void userEntersTheLibrarianInformationFromTheEnvironment() {
        String username=System.getenv("LIBRARY_USER");
        String password=System.getenv("LIBRARY_PASSWORD");
        loginPage.login(username,password);
    }
}
