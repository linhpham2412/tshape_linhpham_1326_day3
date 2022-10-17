package nt.tshape.Test;

import nt.tshape.BaseInterface;
import nt.tshape.PageModal.DemoAccessDetailsPage;
import nt.tshape.PageModal.DemoIndexPage;
import nt.tshape.PageModal.DemoInputEmailPage;
import nt.tshape.PageModal.DemoManagerHomePage;
import nt.tshape.UserInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

import static nt.tshape.Utils.*;

public class Test_Day1 extends BaseInterface {

    public static UserInfo userInfo = new UserInfo();

    public UserInfo getUserInfo(){
        return userInfo;
    }

    @Test
    public void registerNewAccount(){
        DemoIndexPage demoIndexPage = new DemoIndexPage(driver);
        DemoInputEmailPage demoInputEmailpage = new DemoInputEmailPage(driver);
        DemoAccessDetailsPage demoAccessDetailsPage = new DemoAccessDetailsPage(driver);

        demoIndexPage
                .openPage()
                .clickOnCreateAccountLink()
                .clickToSkipAds();
        demoInputEmailpage
                .inputEmailID(generateTestEmail())
                .submitEmailButtonClick();
        demoAccessDetailsPage
                .saveEmailID()
                .savePassword();
        userInfo.setEmailID(demoAccessDetailsPage.userInfo.getEmailID());
        userInfo.setPassword(demoAccessDetailsPage.userInfo.getPassword());
    }

    @Test
    public void verifyNewAccount(){
        DemoIndexPage demoIndexPage = new DemoIndexPage(driver);
        DemoManagerHomePage demoManagerHomePage = new DemoManagerHomePage(driver);

        demoIndexPage
                .openPage()
                .inputUserID(userInfo.getEmailID())
                .inputPassword(userInfo.getPassword())
                .loginButtonClick();
        Assert.assertEquals(demoManagerHomePage.getUserID(),"Manger Id : "+userInfo.getEmailID(),"UserID is not same with created one!");
    }
}
