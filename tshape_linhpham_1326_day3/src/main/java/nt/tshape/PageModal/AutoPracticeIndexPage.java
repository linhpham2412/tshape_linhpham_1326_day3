package nt.tshape.PageModal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoPracticeIndexPage {
    //locator
    private final By contactUsLink = By.xpath("\"//div[@id=\\\"contact-link\\\"]//a\"");
    public WebDriver driver;
    private final WebDriverWait wait;

    //contructor
    public AutoPracticeIndexPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    //method
    public AutoPracticeIndexPage openPage() {
        driver.get("http://automationpractice.com/index.php");
        return this;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void contactUSLinkClick() {
        try {
            driver.findElement(contactUsLink).click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(contactUsLink)));
            driver.findElement(contactUsLink).click();
        }
    }

    public void navigateBackButtonClick() {
        driver.navigate().back();
    }

    public void navigateForwardButtonClick() {
        driver.navigate().forward();
    }
}
