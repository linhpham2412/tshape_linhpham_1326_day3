package nt.tshape.PageModal;

import nt.tshape.BaseInterface;
import nt.tshape.Test.Test_Day1;
import nt.tshape.UserInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoCustomerRegisteredPage extends BaseInterface {
    public DemoCustomerRegisteredPage(WebDriver driver, WebDriverWait wait, UserInfo userInfo) {
        this.driver = driver;
        this.wait = wait;
        this.userInfo = userInfo;
    }

    public WebDriver driver;
    private WebDriverWait wait;
    private UserInfo userInfo;

    //locator
    private final By customerIDLabelXPath = new By.ByXPath("//table[@id='customer']//td[text()='Customer ID']//parent::tr//child::td[2]");

}
