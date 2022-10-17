package nt.tshape.PageModal;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoManagerHomePage {
    public WebDriver driver;
    private WebDriverWait wait;

    //Locator
    private final By userIDLabelXPath = By.xpath("//marquee[contains(@class,'heading3')]//parent::td//parent::tr//following::tr//td");

    //Constructor
    public DemoManagerHomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }


    public String getUserID(){
        try {
            return driver.findElement(userIDLabelXPath).getText();
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(userIDLabelXPath));
            return driver.findElement(userIDLabelXPath).getText();
        }
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
