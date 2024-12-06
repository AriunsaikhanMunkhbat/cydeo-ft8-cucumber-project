package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//button[.='Continue']")
    public WebElement continueBtn;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[.='Sign In']")
    public WebElement signinBtn;

//==========================================

//search elements
    @FindBy(id = "typeaheadInput")
    public WebElement searchTerm;

    @FindBy(id = "submitSearch-button")
    public WebElement searchBtn;

    @FindBy(id = "google-location-search")
    public WebElement searchLocation;

    //job posting elements

    @FindBy(xpath = "//button[@aria-label='Filter Search Results by Easy Apply']")
    public WebElement easyApplyCheckBox;

    public void login(String email,String password){
        emailInput.sendKeys(email);
        continueBtn.click();
        BrowserUtils.waitFor(2);
        passwordInput.sendKeys(password);
        signinBtn.click();

    // quick test for search 
        BrowserUtils.waitFor(2);
        searchTerm.sendKeys("sdet");
        BrowserUtils.waitFor(2);
        searchBtn.click();

    // go through job postings 
        String isChecked = easyApplyCheckBox.getAttribute("aria-checked");

        BrowserUtils.waitFor(2);
        if ("true".equals(isChecked)) {
            System.out.println("Button is already checked.");
        } else {
            easyApplyCheckBox.click();
            System.out.println("Button clicked to enable 'Easy Apply' filter.");
        }

    

    }


}
