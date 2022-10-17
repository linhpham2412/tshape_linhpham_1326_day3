package nt.tshape.PageModal;


import nt.tshape.UserInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoInputEmailPage {
    public WebDriver driver;
    private WebDriverWait wait;

    //Locator
    private final By emailIDTextBoxXPath = By.xpath("//td[contains(@align,'right') and text()='Email ID']//following::td/input[@name='emailid']");
    private final By submitEmailButtonXPath = By.xpath("//td[contains(@align,'right') and text()='Email ID']//parent::tr//following::tr//child::td[2]//input[@name='btnLogin']");
    //Constructor
    public DemoInputEmailPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public DemoInputEmailPage openPage(){
        driver.get("https://demo.guru99.com/");
        return this;
    }

    public DemoInputEmailPage inputEmailID(String emailIDValue){
        try {
            driver.findElement(emailIDTextBoxXPath).sendKeys(emailIDValue);
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(emailIDTextBoxXPath));
            driver.findElement(emailIDTextBoxXPath).sendKeys(emailIDValue);
        }
        return this;
    }

    public void submitEmailButtonClick(){
        try {
            driver.findElement(submitEmailButtonXPath).click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(submitEmailButtonXPath));
            driver.findElement(submitEmailButtonXPath).click();
        }
    }

    public void navigateBackButtonClick(){
        driver.navigate().back();
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
