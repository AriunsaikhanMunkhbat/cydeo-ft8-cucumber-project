package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// This class is abstract because we don't want any other class to create object from that
public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Users")
    public WebElement usersLink;

    @FindBy(linkText = "Dashboard")
    public WebElement dashboardLink;

    @FindBy(linkText = "Books")
    public WebElement booksLink;

    @FindBy(css = "a#navbarDropdown>span")
    public WebElement userInfo;
}
