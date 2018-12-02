package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import ru.stqa.selenium.factory.*;
import util.PropertyLoader;

import java.util.concurrent.TimeUnit;

public class TestBase {


    protected WebDriver driver;
    protected String baseUrl;
    @BeforeClass
    public void init() {
        System.out.println("init baseUrl");
        baseUrl = PropertyLoader.loadProperty("site.url");
        System.setProperty("webdriver.chrome.driver", "chromedriver_nix");

        System.out.println("init options");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1400,1400");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--dump-dom");
        options.addArguments("--disable-dev-shm-usage");



//        capabilities.setBrowserName(PropertyLoader.loadProperty("browser.name"));
//        capabilities.setVersion(PropertyLoader.loadProperty("browser.version"));
//        String platform = PropertyLoader.loadProperty("browser.platform");

        System.out.println("init driver");
        driver = SingleWebDriverPool.DEFAULT.getDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            SingleWebDriverPool.DEFAULT.dismissDriver(driver);
        }
    }

}
