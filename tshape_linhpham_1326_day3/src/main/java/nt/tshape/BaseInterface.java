package nt.tshape;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BaseInterface {
    public WebDriver driver;

    @Parameters({"browser"})
//    @BeforeClass
    public void loadWebDriver(@Optional("chrome") String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\linhpham\\Documents\\Tshape_Training\\Webdriver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized"); // open Browser in maximized mode
            options.addArguments("disable-infobars"); // disabling infobars
            options.addArguments("--disable-extensions"); // disabling extensions
            options.addArguments("--disable-gpu"); // applicable to windows os only
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--no-sandbox"); // Bypass OS security model
            driver = new ChromeDriver(options);
        }
        if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\linhpham\\Documents\\Tshape_Training\\Webdriver\\geckodriver.exe");
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        }
        driver
                .manage()
                .window()
                .maximize();
    }

    @Parameters({"browser"})
//    @BeforeClass
    public void loadLocalGridWebDriver(@Optional("chrome") String browser) throws MalformedURLException {
        String hubUrl = "http://localhost:4444/wd/hub";
        if (browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized"); // open Browser in maximized mode
            options.addArguments("disable-infobars"); // disabling infobars
            options.addArguments("--disable-extensions"); // disabling extensions
            options.addArguments("--disable-gpu"); // applicable to windows os only
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--no-sandbox"); // Bypass OS security model
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName(browser);
            capabilities.setPlatform(Platform.WINDOWS);
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new RemoteWebDriver(capabilities);
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\linhpham\\Documents\\Tshape_Training\\Webdriver\\chromedriver.exe");
            driver = new RemoteWebDriver(options);
            driver
                    .manage()
                    .window()
                    .maximize();
        }
        if (browser.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setBrowserName(browser);
            capabilities.setPlatform(Platform.WINDOWS);
            capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
            driver = new RemoteWebDriver(capabilities);
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\linhpham\\Documents\\Tshape_Training\\Webdriver\\geckodriver.exe");
            driver = new RemoteWebDriver(options);
            driver
                    .manage()
                    .window()
                    .maximize();
        }
    }

    @Parameters({"browser"})
    @BeforeClass
    public void loadBrowserStackWebDriver(@Optional("chrome") String browser) throws MalformedURLException {
        String username = "phamlinh15";
        String accessKey = "3r8Un6KQDkGhyqsZqxPq";
        if (browser.equals("chrome")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", browser);
            HashMap<String, Object> browserStackOptions = new HashMap<String, Object>();
            browserStackOptions.put("os", "windows");
            browserStackOptions.put("osVersion", "10");
            browserStackOptions.put("sessionName", "BrowserStack Check");
            browserStackOptions.put("seleniumVersion", "3.141.59");
            capabilities.setCapability("bstack:options", browserStackOptions);
            driver = new RemoteWebDriver(new URL("https://" +username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
            driver
                    .manage()
                    .window()
                    .maximize();
        } if (browser.equals("firefox")){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", browser);
            HashMap<String, Object> browserStackOptions = new HashMap<String, Object>();
            browserStackOptions.put("os", "windows");
            browserStackOptions.put("osVersion", "10");
            browserStackOptions.put("sessionName", "BrowserStack Check");
            browserStackOptions.put("seleniumVersion", "3.141.59");
            capabilities.setCapability("bstack:options", browserStackOptions);
            driver = new RemoteWebDriver(new URL("https://" +username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
            driver
                    .manage()
                    .window()
                    .maximize();
        }
    }
}
