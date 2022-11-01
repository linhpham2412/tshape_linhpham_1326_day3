package nt.tshape.Test;

import nt.tshape.BaseInterface;
import nt.tshape.PageModal.*;
import nt.tshape.UserInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;

import static nt.tshape.Utils.generateTestCustomerName;
import static nt.tshape.Utils.generateTestEmail;

public class Day2Testcases extends BaseInterface {

    public static UserInfo userInfo = Day1Testcases.userInfo;

    @Test
    public void websiteNavigationTest() {
        AutoPracticeIndexPage autoPracticeIndexPage = new AutoPracticeIndexPage(driver);
        AutoPracticeContacUsPage autoPracticeContacUsPage = new AutoPracticeContacUsPage(driver);

        autoPracticeIndexPage
                .openPage();
        Assert.assertEquals(autoPracticeIndexPage.getPageTitle(), "My Store", "System not loaded correct page!");
        autoPracticeIndexPage
                .contactUSLinkClick();
        Assert.assertEquals(autoPracticeContacUsPage.getPageTitle(), "Contact us - My Store", "System not loaded correct page!");
        autoPracticeContacUsPage
                .navigateBackButtonClick();
        Assert.assertEquals(autoPracticeIndexPage.getPageTitle(), "My Store", "System not loaded correct page!");
        autoPracticeIndexPage
                .navigateForwardButtonClick();
        Assert.assertEquals(autoPracticeContacUsPage.getPageTitle(), "Contact us - My Store", "System not loaded correct page!");
        driver.close();
    }

    @Test
    public void createNewCustomer() throws ParseException {
        DemoIndexPage demoIndexPage = new DemoIndexPage(driver);
        DemoManagerHomePage demoManagerHomePage = new DemoManagerHomePage(driver);
        DemoAddCustomerPage demoAddCustomerPage = new DemoAddCustomerPage(driver);
        DemoCustomerRegisteredPage demoCustomerRegisteredPage = new DemoCustomerRegisteredPage(driver);

        demoIndexPage
                .openPage()
                .inputUserID(userInfo.getEmailID())
                .inputPassword(userInfo.getPassword())
                .loginButtonClick();
        Assert.assertEquals(demoManagerHomePage.getPageTitle(), "Guru99 Bank Manager HomePage", "System not loaded correct page!");
        demoManagerHomePage
                .newCustomerLinkClick()
                .clickToSkipAds();
        demoAddCustomerPage
                .inputCustomerName(generateTestCustomerName(10))
                .checkCustomerGenderMale()
                .inputCustomerDOB("02/12/2000", "MM/dd/yyyy")
                .inputCustomerAddress("123 Testing Street")
                .inputCustomerCity("Thu Duc City")
                .inputCustomerState("Ho Chi Minh")
                .inputCustomerPINNo("700000")
                .inputCustomerMobileNo("0123456789")
                .inputCustomerEmail(generateTestEmail())
                .inputCustomerPassword("123456789")
                .addNewCustomerSubmitButtonClick();
        Assert.assertEquals("Customer Registered Successfully!!!", demoCustomerRegisteredPage.getRegisterTableHeaderMessage(), "Customer Information Table not loaded correctly!");
        Assert.assertEquals(userInfo.getCustomerName(), demoCustomerRegisteredPage.getCustomerLabelMessage("Customer Name"), "Customer Name not correct");
        if (userInfo.getIsCustomerMale()) Assert.assertTrue(userInfo.getIsCustomerMale());
        else Assert.assertFalse(userInfo.getIsCustomerMale());
        Assert.assertEquals(0, userInfo.getCustomerDateOfBirth("yyyy-MM-dd").compareTo(demoCustomerRegisteredPage.getCustomerLabelMessage("Birthdate")), "Birthdate not same!");
        Assert.assertEquals(userInfo.getCustomerAddress(), demoCustomerRegisteredPage.getCustomerLabelMessage("Address"), "Address not correct");
        Assert.assertEquals(userInfo.getCustomerCity(), demoCustomerRegisteredPage.getCustomerLabelMessage("City"), "City not correct");
        Assert.assertEquals(userInfo.getCustomerState(), demoCustomerRegisteredPage.getCustomerLabelMessage("State"), "State not correct");
        Assert.assertEquals(userInfo.getCustomerPIN(), demoCustomerRegisteredPage.getCustomerLabelMessage("Pin"), "Pin not correct");
        Assert.assertEquals(userInfo.getCustomerMobileNo(), demoCustomerRegisteredPage.getCustomerLabelMessage("Mobile No."), "Mobile No. not correct");
        Assert.assertEquals(userInfo.getCustomerEmail(), demoCustomerRegisteredPage.getCustomerLabelMessage("Email"), "Customer Email not correct");
    }
}
