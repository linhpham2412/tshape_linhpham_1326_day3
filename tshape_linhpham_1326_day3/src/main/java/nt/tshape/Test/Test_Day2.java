package nt.tshape.Test;

import nt.tshape.BaseInterface;
import nt.tshape.PageModal.*;
import nt.tshape.UserInfo;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import static nt.tshape.Utils.*;

public class Test_Day2 extends BaseInterface {

    public WebDriverWait wait = new WebDriverWait(driver, 10);
    public static UserInfo userInfo = Test_Day1.userInfo;

    @Test
    public void scenario1(){
        AutoPracticeIndexPage autoPracticeIndexPage = new AutoPracticeIndexPage(driver);
        AutoPracticeContacUsPage autoPracticeContacUsPage = new AutoPracticeContacUsPage(driver);

        autoPracticeIndexPage
                .openPage();
        Assert.assertEquals(autoPracticeIndexPage.getPageTitle(),"My Store","System not loaded correct page!");
        autoPracticeIndexPage
                .contactUSLinkClick();
        Assert.assertEquals(autoPracticeContacUsPage.getPageTitle(),"Contact us - My Store","System not loaded correct page!");
        autoPracticeContacUsPage
                .navigateBackButtonClick();
        Assert.assertEquals(autoPracticeIndexPage.getPageTitle(),"My Store","System not loaded correct page!");
        autoPracticeIndexPage
                .navigateForwardButtonClick();
        Assert.assertEquals(autoPracticeContacUsPage.getPageTitle(),"Contact us - My Store","System not loaded correct page!");
        driver.close();
    }

    @Test
    public void createNewCustomer() throws ParseException {
        DemoIndexPage demoIndexPage = new DemoIndexPage(driver);
        DemoManagerHomePage demoManagerHomePage = new DemoManagerHomePage(driver);
        DemoAddCustomerPage demoAddCustomerPage = new DemoAddCustomerPage(driver);
        DemoCustomerRegisteredPage demoCustomerRegisteredPage = new DemoCustomerRegisteredPage(driver,wait,userInfo);

        demoIndexPage
                .openPage()
                .inputUserID(userInfo.getEmailID())
                .inputPassword(userInfo.getPassword())
                .loginButtonClick();
        Assert.assertEquals(demoManagerHomePage.getPageTitle(),"Guru99 Bank Manager HomePage", "System not loaded correct page!");
        demoManagerHomePage
                .newCustomerLinkClick()
                .clickToSkipAds();
        demoAddCustomerPage
                .inputCustomerName(generateTestCustomerName(10))
                .checkCustomerGenderMale()
                .inputCustomerDOB("02/12/2000","MM/dd/yyyy")
                .inputCustomerAddress("123 Testing Street")
                .inputCustomerCity("Thu Duc City")
                .inputCustomerState("Ho Chi Minh")
                .inputCustomerPINNo("700000")
                .inputCustomerMobileNo("0123456789")
                .inputCustomerEmail(generateTestEmail())
                .inputCustomerPassword("123456789")
                .addNewCustomerSubmitButtonClick();
    }
}
