package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;

import io.cucumber.messages.types.Duration;

import java.util.List;
import java.util.Set;

import org.joda.time.Seconds;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    @FindBy(xpath = "//*[@id=\"react-aria-_R_8klubslebrbH3_\"]")
    public WebElement searchTerm;

    @FindBy(xpath = "//*[@id=\"react-aria-_R_b4lubslebrb_\"]")
    public WebElement searchBtn;

    @FindBy(id = "google-location-search")
    public WebElement searchLocation;

    //job posting elements

    @FindBy(xpath = "//button[@aria-label='Filter Search Results by Easy Apply']")
    public WebElement easyApplyCheckBox;

    @FindBy(xpath = "//*[contains(@id,\"_r_1q_\")]")
    public WebElement allFilters;

    @FindBy(xpath = "/html/body/div[5]/div[1]/div/div[2]/div[2]/div[2]/div/section/div/div[1]/div/form/label")
    public WebElement easyApplyBox;

    @FindBy(xpath = "//a[contains(@class, 'card-title-link normal')]")
    public List<WebElement> jobTitleLinks;

    @FindBy(xpath = "//*[contains(@id,\"_r_32_\")]")
    public WebElement applyFilters;

    @FindBy(xpath = "//a[contains(@aria-label, \"View Details\")]")
    public List<WebElement> viewDetailsLinks;

    @FindBy(className = "btn-primary")
    public WebElement applyButton;

    @FindBy(className = "seds-button-primary")
    public WebElement nextButtonFofResume;


    // accept of reject cookie at login page
    

    public void login(String email,String password){
        // WebDriverWait wait = new WebDriverWait(Driver.getDriver(), java.time.Duration.ofSeconds(15) );

        // By acceptCookies = By.xpath("//button[contains(.,'Accept')]");
        // By rejectCookies = By.xpath("//button[contains(.,'Reject')]");

        // if (!Driver.getDriver().findElements(acceptCookies).isEmpty()) {
        //     wait.until(ExpectedConditions.elementToBeClickable(acceptCookies)).click();
        // } else if (!Driver.getDriver().findElements(rejectCookies).isEmpty()) {
        //     wait.until(ExpectedConditions.elementToBeClickable(rejectCookies)).click();
        // }

        
        emailInput.sendKeys(email);
        continueBtn.click();
        // BrowserUtils.waitFor(2);
        passwordInput.sendKeys(password);
        signinBtn.click();

    // quick test for search 
        // BrowserUtils.waitFor(2);
        searchTerm.sendKeys("sdet");
        // BrowserUtils.waitFor(2);
        searchBtn.click();

    // Apply easy Apply filter first 

        // BrowserUtils.waitFor(2);
        allFilters.click();
        // BrowserUtils.waitFor(2);
        easyApplyBox.click();
        // BrowserUtils.waitFor(2);
        applyFilters.click();


        System.out.print("going into the loop now");
        // 2️⃣ Loop through each link
        for (int i = 0; i < viewDetailsLinks.size(); i++) {
            
            WebElement link = viewDetailsLinks.get(i);

            // Open link in a new tab using JS
            ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open(arguments[0].href,'_blank');", link);

            // Switch to the new tab
            Set<String> windowHandles = Driver.getDriver().getWindowHandles();
            String newTabHandle = windowHandles.toArray(new String[0])[windowHandles.size() - 1];
            Driver.getDriver().switchTo().window(newTabHandle);

            // Wait for page to load and click "Apply" button
            BrowserUtils.waitForClickablility(applyButton, 2);
            applyButton.click();

            BrowserUtils.waitFor(2);
            nextButtonFofResume.click();
            BrowserUtils.waitFor(2);
            nextButtonFofResume.click();

            // Close the tab
            Driver.getDriver().close();

            // Switch back to original tab
            String originalTab = windowHandles.toArray(new String[0])[0];
            Driver.getDriver().switchTo().window(originalTab);

            // Optional: small pause to avoid stale elements
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        }



    // go through job postings 
        // String isChecked = easyApplyCheckBox.getAttribute("aria-checked");

        // BrowserUtils.waitFor(2);
        // if ("true".equals(isChecked)) {
        //     System.out.println("Button is already checked.");
        // } else {
        //     easyApplyCheckBox.click();
        //     System.out.println("Button clicked to enable 'Easy Apply' filter.");
        // }

        
        // for (WebElement link : jobTitleLinks) {
        //     try {
        //     // Use JavaScript to click the link
        //     JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //     js.executeScript("arguments[0].click();", link);

        //     // Optionally, perform some actions or validations
        //     System.out.println("Clicked link: " + link.getText());

        //     // Get the current window handle (original tab)
        //     String originalWindow = Driver.getDriver().getWindowHandle();

        //     // Wait for the new tab to open
        //     Set<String> allWindows = Driver.getDriver().getWindowHandles();
        //     while (allWindows.size() <= 1) {
        //         allWindows = Driver.getDriver().getWindowHandles();
        //     }

        //     // Switch to the new tab
        //     for (String windowHandle : allWindows) {
        //         if (!windowHandle.equals(originalWindow)) {
        //             Driver.getDriver().switchTo().window(windowHandle);
        //             break;
        //         }
        //     }

        //     // Perform actions or validations on the new tab
        //     System.out.println("New tab title: " + Driver.getDriver().getTitle());

        //     // Close the new tab and switch back to the original tab
        //     Driver.getDriver().close();
        //     Driver.getDriver().switchTo().window(originalWindow);
        //     // Navigate back to the original page
        //     // Driver.getDriver().navigate().back();

        //     // BrowserUtils.waitForStaleElement(link);
        //     BrowserUtils.waitFor(1);
        //     // // Re-fetch the list of elements to avoid stale element exceptions
        //     jobTitleLinks = Driver.getDriver().findElements(By.cssSelector("a.card-title-link.normal"));
        //     BrowserUtils.waitFor(1);
        //     } catch (org.openqa.selenium.StaleElementReferenceException e) {
        //     System.out.println("Stale element reference encountered, retrying the click.");
        //     jobTitleLinks = Driver.getDriver().findElements(By.cssSelector("a.card-title-link.normal"));
    //}
//}
        

            // Re-fetch the links because the DOM may have been refreshed
            // links = jobTitleLinks.findElements(By.tagName("a"));
        

    

    }


}
