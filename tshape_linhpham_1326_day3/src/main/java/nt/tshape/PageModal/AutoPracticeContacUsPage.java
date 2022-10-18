package nt.tshape.PageModal;

import nt.tshape.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoPracticeContacUsPage {
    public WebDriver driver;
    //locator
    private final String pageTitle = driver.getTitle();
    private final WebDriverWait wait;

    //contructor
    public AutoPracticeContacUsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Constant.LONG_TIME);
    }

    //method
    public String getPageTitle() {
        return this.pageTitle;
    }

    public void navigateBackButtonClick() {
        driver.navigate().back();
    }

    public void navigateForwardButtonClick() {
        driver.navigate().forward();
    }
}
