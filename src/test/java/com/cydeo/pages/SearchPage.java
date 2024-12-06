package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    public SearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "typeaheadInput")
    public WebElement searchTerm;

    @FindBy(id = "submitSearch-button")
    public WebElement searchBtn;

    @FindBy(id = "google-location-search")
    public WebElement searchLocation;

    // @FindBy(xpath = "//button[.='Sign In']")
    // public WebElement signinBtn;


    String keyword = "sdet";
    public void search(String keyword,String location){
        searchTerm.sendKeys(keyword);
        // searchLocation.sendKeys(null);
        searchBtn.click();
    }



}
