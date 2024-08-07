package com.cydeo.step_definitions;

import com.cydeo.pages.UsersPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Users_StepDef {

    UsersPage usersPage = new UsersPage();

    @Given("I click on {string} link")
    public void i_click_on_link(String link) {

        if(link.equalsIgnoreCase("Users")){
            usersPage.usersLink.click();
        }else if(link.equalsIgnoreCase("Dashboard")){
            usersPage.dashboardLink.click();
        }else{
            usersPage.booksLink.click();
        }

    }

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedHeaders) {

        List<String> actualHeaders = new ArrayList<>();

        for (WebElement eachHeader : usersPage.tableHeaders) {
            actualHeaders.add(eachHeader.getText());
        }

        Assert.assertEquals(expectedHeaders,actualHeaders);


    }
}
