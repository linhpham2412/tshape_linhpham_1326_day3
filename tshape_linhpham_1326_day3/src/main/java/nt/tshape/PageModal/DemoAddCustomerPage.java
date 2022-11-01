package nt.tshape.PageModal;

import nt.tshape.BaseInterface;
import nt.tshape.Test.Day1Testcases;
import nt.tshape.UserInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;


public class DemoAddCustomerPage extends BaseInterface {
    //locator
    private final By customerNameTextFieldXPath = new By.ByXPath("//form[@name='addcust']//parent::table//following::table//td[text()='Customer Name']//following::td//input[@name='name']");
    private final By customerMaleCheckBoxXPath = new By.ByXPath("//form[@name='addcust']//parent::table//following::table//td[text()='Gender']//following::td//input[@value='m']");
    private final By customerFemaleCheckBoxXPath = new By.ByXPath("//form[@name='addcust']//parent::table//following::table//td[text()='Gender']//following::td//input[@value='f']");
    private final By customerDOBTextFieldXPath = new By.ById("dob");
    private final By customerAddressTextFieldXPath = new By.ByXPath("//form[@name='addcust']//parent::table//following::table//td[text()='Address']//following::td//textarea[@name='addr']");
    private final By customerCityTextFieldXPath = new By.ByXPath("//form[@name='addcust']//parent::table//following::table//td[text()='City']//following::td//input[@name='city']");
    private final By customerStateTextFieldXPath = new By.ByXPath("//form[@name='addcust']//parent::table//following::table//td[text()='State']//following::td//input[@name='state']");
    private final By customerPINTextFieldXPath = new By.ByXPath("//form[@name='addcust']//parent::table//following::table//td[text()='PIN']//following::td//input[@name='pinno']");
    private final By customerMobileNumberTextFieldXPath = new By.ByXPath("//form[@name='addcust']//parent::table//following::table//td[text()='Mobile Number']//following::td//input[@name='telephoneno']");
    private final By customerEmailTextFieldXPath = new By.ByXPath("//form[@name='addcust']//parent::table//following::table//td[text()='E-mail']//following::td//input[@name='emailid']");
    private final By customerPasswordTextFieldXPath = new By.ByXPath("//form[@name='addcust']//parent::table//following::table//td[text()='Password']//following::td//input[@name='password']");
    private final By customerSubmitButtonXPath = new By.ByXPath("//form[@name='addcust']//parent::table//following::table//td//following::td//input[@name='sub']");
    public WebDriver driver;
    private final WebDriverWait wait;
    private final UserInfo userInfo;
    //contructor
    public DemoAddCustomerPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        userInfo = Day1Testcases.userInfo;
    }

    //method
    public DemoAddCustomerPage inputCustomerName(String customerName) {
        try {
            driver.findElement(customerNameTextFieldXPath).sendKeys(customerName);
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(customerNameTextFieldXPath));
            driver.findElement(customerNameTextFieldXPath).sendKeys(customerName);
        }
        userInfo.setCustomerName(customerName);
        return this;
    }

    public DemoAddCustomerPage checkCustomerGenderMale() {
        try {
            driver.findElement(customerMaleCheckBoxXPath).click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(customerMaleCheckBoxXPath));
            driver.findElement(customerMaleCheckBoxXPath).click();
        }
        userInfo.setIsCustomerMale(true);
        return this;
    }

    public DemoAddCustomerPage checkCustomerGenderFemale() {
        try {
            driver.findElement(customerFemaleCheckBoxXPath).click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(customerFemaleCheckBoxXPath));
            driver.findElement(customerFemaleCheckBoxXPath).click();
        }
        userInfo.setIsCustomerMale(false);
        return this;
    }

    public DemoAddCustomerPage inputCustomerDOB(String customerDOB, String Datepattern) throws ParseException {
        try {
            driver.findElement(customerDOBTextFieldXPath).sendKeys(customerDOB);
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(customerDOBTextFieldXPath));
            driver.findElement(customerDOBTextFieldXPath).sendKeys(customerDOB);
        }
        userInfo.setCustomerDateOfBirth(customerDOB, Datepattern);
        return this;
    }

    public DemoAddCustomerPage inputCustomerPINNo(String customerPINNo) {
        try {
            driver.findElement(customerPINTextFieldXPath).sendKeys(customerPINNo);
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(customerPINTextFieldXPath));
            driver.findElement(customerPINTextFieldXPath).sendKeys(customerPINNo);
        }
        userInfo.setCustomerPIN(customerPINNo);
        return this;
    }

    public DemoAddCustomerPage inputCustomerAddress(String customerAddress) {
        try {
            driver.findElement(customerAddressTextFieldXPath).sendKeys(customerAddress);
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(customerAddressTextFieldXPath));
            driver.findElement(customerAddressTextFieldXPath).sendKeys(customerAddress);
        }
        userInfo.setCustomerAddress(customerAddress);
        return this;
    }

    public DemoAddCustomerPage inputCustomerCity(String customerCity) {
        try {
            driver.findElement(customerCityTextFieldXPath).sendKeys(customerCity);
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(customerCityTextFieldXPath));
            driver.findElement(customerCityTextFieldXPath).sendKeys(customerCity);
        }
        userInfo.setCustomerCity(customerCity);
        return this;
    }

    public DemoAddCustomerPage inputCustomerState(String customerState) {
        try {
            driver.findElement(customerStateTextFieldXPath).sendKeys(customerState);
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(customerStateTextFieldXPath));
            driver.findElement(customerStateTextFieldXPath).sendKeys(customerState);
        }
        userInfo.setCustomerState(customerState);
        return this;
    }

    public DemoAddCustomerPage inputCustomerEmail(String customerEmail) {
        try {
            driver.findElement(customerEmailTextFieldXPath).sendKeys(customerEmail);
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(customerEmailTextFieldXPath));
            driver.findElement(customerEmailTextFieldXPath).sendKeys(customerEmail);
        }
        userInfo.setCustomerEmail(customerEmail);
        return this;
    }

    public DemoAddCustomerPage inputCustomerMobileNo(String customerMobileNo) {
        try {
            driver.findElement(customerMobileNumberTextFieldXPath).sendKeys(customerMobileNo);
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(customerMobileNumberTextFieldXPath));
            driver.findElement(customerMobileNumberTextFieldXPath).sendKeys(customerMobileNo);
        }
        userInfo.setCustomerMobileNo(customerMobileNo);
        return this;
    }

    public DemoAddCustomerPage inputCustomerPassword(String customerPassword) {
        try {
            driver.findElement(customerPasswordTextFieldXPath).sendKeys(customerPassword);
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(customerPasswordTextFieldXPath));
            driver.findElement(customerPasswordTextFieldXPath).sendKeys(customerPassword);
        }
        userInfo.setPassword(customerPassword);
        return this;
    }

    public void addNewCustomerSubmitButtonClick() {
        try {
            driver.findElement(customerSubmitButtonXPath).click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(customerSubmitButtonXPath));
            driver.findElement(customerSubmitButtonXPath).click();
        }
    }
}
