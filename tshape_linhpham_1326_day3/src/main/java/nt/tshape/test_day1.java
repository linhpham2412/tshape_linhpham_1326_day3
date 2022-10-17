package nt.tshape;

import nt.tshape.PageModal.DemoAccessDetailsPage;
import nt.tshape.PageModal.DemoIndexPage;
import nt.tshape.PageModal.DemoInputEmailPage;
import nt.tshape.PageModal.DemoManagerHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class test_day1 extends BaseInterface{

    private String testEmail(){
        Random emailRandIndex = new Random();
        return "linh_test_email"+emailRandIndex.nextInt()+"@mail.com";
    }

    @Test
    public void registerNewAccount(){
        DemoIndexPage demoIndexPage = new DemoIndexPage(driver);
        DemoInputEmailPage demoInputEmailpage = new DemoInputEmailPage(driver);
        DemoAccessDetailsPage demoAccessDetailsPage = new DemoAccessDetailsPage(driver);
        DemoManagerHomePage demoManagerHomePage = new DemoManagerHomePage(driver);

        demoIndexPage
                .openPage()
                .clickOnCreateAccountLink()
                .clickToSkipAds();
        demoInputEmailpage
                .inputEmailID(testEmail())
                .submitEmailButtonClick();
        demoAccessDetailsPage
                .saveEmailID()
                .savePassword()
                .navigateBackButtonClick();
        demoInputEmailpage
                .navigateBackButtonClick();
        demoIndexPage
                .inputUserID(demoAccessDetailsPage.userInfo.getEmailID())
                .inputPassword(demoAccessDetailsPage.userInfo.getPassword())
                .loginButtonClick();
        Assert.assertEquals(demoManagerHomePage.getUserID(),"Manger Id : "+demoAccessDetailsPage.userInfo.getEmailID(),"UserID is not same with created one!");
    }
}
