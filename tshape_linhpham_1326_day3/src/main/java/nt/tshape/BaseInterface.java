package nt.tshape.PageModal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseInterface {
    public WebDriver driver;

    @BeforeClass
    public void loadWebDriver(String browserName){
        if (browserName.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\linhpham\\Documents\\Tshape Training\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();

            driver
                    .manage()
                    .window()
                    .maximize();
        }
    }
}
