package nt.tshape;

import nt.tshape.PageModal.DemoIndexPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

public class test_day1 extends BaseInterface{

    private String testEmail(){
        Random emailRandIndex = new Random();
        return "linh_test_email"+emailRandIndex.ints().toString()+"@mail.com";
    }

    @Test
    public void registerNewAccount(){
        DemoIndexPage demoIndexPage = new DemoIndexPage(driver);

        demoIndexPage
                .openPage()
                .clickOnCreateAccountLink()
                .clickToSkipAds();
    }
}
