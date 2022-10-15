package nt.tshape.PageModal;


import nt.tshape.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoIndexPage {
    public WebDriver driver;
    private WebDriverWait wait;

    //Locator
    String tbodyLoginFormXPath = "//form[@name=\"frmLogin\"]//table//tbody";
    private final By userIDTextBoxXPath = By.xpath(tbodyLoginFormXPath+"//tr[1]//td[2]//input[@name=\"uid\"]");
    private final By passwordTextBoxXPath = By.xpath(tbodyLoginFormXPath+"//tr[2]//td[2]//input[@name=\"password\"]");
    private final By loginButtonXPath = By.xpath(tbodyLoginFormXPath+"//tr[3]//td[2]//input[@name=\"btnLogin\"]");
    private final By createAccountLink = By.xpath("//h4[@class='barone']//following::div//ol//li[1]//a[contains(@href,'http://demo.guru99.com') and text()='here']");
    //Constructor
    public DemoIndexPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public DemoIndexPage openPage(){
        driver.get("https://demo.guru99.com/v4/index.php");
        return this;
    }

    public void inputUserID(String userIDValue){
        try {
            driver.findElement(userIDTextBoxXPath).sendKeys(userIDValue);
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(userIDTextBoxXPath));
            driver.findElement(userIDTextBoxXPath).sendKeys(userIDValue);
        }
    }

    public void inputPassword(String passwordValue){
        try {
            driver.findElement(passwordTextBoxXPath).sendKeys(passwordValue);
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBoxXPath));
            driver.findElement(passwordTextBoxXPath).sendKeys(passwordValue);
        }
    }

    public void loginButtonClick(){
        try {
            driver.findElement(loginButtonXPath).click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(loginButtonXPath));
            driver.findElement(loginButtonXPath).click();
        }
    }

    public DemoIndexPage clickOnCreateAccountLink(){
        try{
            driver.findElement(createAccountLink).click();
        }catch (Exception e){
            wait.until(ExpectedConditions.elementToBeClickable(createAccountLink));
            driver.findElement(createAccountLink).click();
        }
        return this;
    }

    public void clickToSkipAds(){
        Actions clickOnPos10_10 = new Actions(driver);
        clickOnPos10_10
                .moveByOffset(10,10)
                .click()
                .build()
                .perform();
        synchronized (driver){
            try {
                driver.wait(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
