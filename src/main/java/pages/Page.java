package pages;

import org.openqa.selenium.WebDriver;

public class Page {

    protected WebDriver webDriver;

    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

}
