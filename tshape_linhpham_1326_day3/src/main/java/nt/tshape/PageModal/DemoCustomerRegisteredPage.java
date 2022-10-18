package nt.tshape.PageModal;

import nt.tshape.BaseInterface;
import nt.tshape.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoCustomerRegisteredPage extends BaseInterface {
    //locator
    private final By customerRegisterTableHeaderLabelXPath = new By.ByXPath("//table[@id='customer']//following::p[@class='heading3']");
    public WebDriver driver;
    private final WebDriverWait wait;

    public DemoCustomerRegisteredPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Constant.LONG_TIME);
    }

    //Method
    public String getRegisterTableHeaderMessage() {
        try {
            return driver.findElement(customerRegisterTableHeaderLabelXPath).getText();
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(customerRegisterTableHeaderLabelXPath));
            return driver.findElement(customerRegisterTableHeaderLabelXPath).getText();
        }
    }

    public String getCustomerLabelMessage(String fieldName) {
        final By customerFieldLabelXPath = new By.ByXPath("//table[@id='customer']//td[text()='" + fieldName + "']//parent::tr//child::td[2]");
        try {
            return driver.findElement(customerFieldLabelXPath).getText();
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(customerFieldLabelXPath));
            return driver.findElement(customerFieldLabelXPath).getText();
        }
    }
}
