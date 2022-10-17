package nt.tshape.PageModal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoPracticeContacUsPage {
    public WebDriver driver;
    private WebDriverWait wait;

    //locator
    private final String pageTitle = driver.getTitle();

   //contructor
   public AutoPracticeContacUsPage(WebDriver driver) {
       this.driver = driver;
       wait = new WebDriverWait(driver, 10);
   }

   //method
    public String getPageTitle(){
       return this.pageTitle;
    }

    public void navigateBackButtonClick(){
        driver.navigate().back();
    }

    public void navigateForwardButtonClick(){
        driver.navigate().forward();
    }
}
