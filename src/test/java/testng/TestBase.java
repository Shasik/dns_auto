package testng;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import ru.stqa.selenium.factory.*;
import util.PropertyLoader;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {


    protected WebDriver driver;
    protected URL gridHubUrl;
    protected String baseUrl;
    @BeforeClass
    public void init() {
        baseUrl = PropertyLoader.loadProperty("site.url");
        System.setProperty("webdriver.chrome.driver", "chromedriver_nix");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setBrowserName(PropertyLoader.loadProperty("browser.name"));
//        capabilities.setVersion(PropertyLoader.loadProperty("browser.version"));
        String platform = PropertyLoader.loadProperty("browser.platform");
        if (!(null == platform || "".equals(platform))) {
            capabilities.setPlatform(Platform.valueOf(PropertyLoader.loadProperty("browser.platform")));
        }
        if (!(null == gridHubUrl || "".equals(gridHubUrl))) {
            driver = SingleWebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
        } else {
            driver = SingleWebDriverPool.DEFAULT.getDriver(capabilities);
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            SingleWebDriverPool.DEFAULT.dismissDriver(driver);
        }
    }

}
