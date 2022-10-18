package nt.tshape.PageModal;


import nt.tshape.Test.Test_Day1;
import nt.tshape.UserInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoAccessDetailsPage {
    private final By userIDValueLabelXPath = By.xpath("//td[contains(@class,'accpage') and text()='User ID :']//parent::tr//child::td[2]");
    private final By passwordValueLabelXPath = By.xpath("//td[contains(@class,'accpage') and text()='Password :']//parent::tr//child::td[2]");
    public WebDriver driver;
    public UserInfo userInfo;
    //Locator
    String tbodyLoginFormXPath = "//form[@name=\"frmLogin\"]//table//tbody";
    private final WebDriverWait wait;

    //Constructor
    public DemoAccessDetailsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        userInfo = Test_Day1.userInfo;
    }

    public DemoAccessDetailsPage saveEmailID() {
        try {
            userInfo.setEmailID(driver.findElement(userIDValueLabelXPath).getText());
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(userIDValueLabelXPath));
            userInfo.setEmailID(driver.findElement(userIDValueLabelXPath).getText());
        }
        return this;
    }

    public DemoAccessDetailsPage savePassword() {
        try {
            userInfo.setPassword(driver.findElement(passwordValueLabelXPath).getText());
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordValueLabelXPath));
            userInfo.setPassword(driver.findElement(passwordValueLabelXPath).getText());
        }
        return this;
    }

    public void navigateBackButtonClick() {
        driver.navigate().back();
    }

    public void clickToSkipAds() {
        Actions clickOnPos10_10 = new Actions(driver);
        clickOnPos10_10
                .moveByOffset(10, 10)
                .click()
                .build()
                .perform();
        synchronized (driver) {
            try {
                driver.wait(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
