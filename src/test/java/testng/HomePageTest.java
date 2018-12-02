package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends TestBase {

    HomePage homepage;

    @BeforeClass
    public void testInit() {
        System.out.println("test init base url");
        driver.navigate().to(baseUrl);
        System.out.println("page factory start");
        homepage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void testH1Existing() throws InterruptedException {
        System.out.println("click on menu 1");
        driver.findElement(By.cssSelector("#menu-catalog > li:nth-child(2) > a")).click();

        System.out.println("click on menu 2");
        driver.findElement(By.cssSelector("body > div.container > main > div.category-items-desktop > a:nth-child(2)")).click();

        System.out.println("click on menu 3");
        driver.findElement(By.cssSelector("body > div.container > main > div.category-items-desktop > a:nth-child(2)")).click();

        System.out.println("click on sort button");
        driver.findElement(By.cssSelector("#sort-filter > div:nth-child(1) > div > button")).click();

        System.out.println("select button");
        driver.findElement(By.cssSelector("#sort-filter > div:nth-child(1) > div > ul > li:nth-child(2) > a")).click();

        System.out.println("sleep 1s");
        Thread.sleep(1000);

        System.out.println("initialize 2 web element");
        WebElement webElement1 = driver.findElement(By.cssSelector("#catalog-items-page > div.page-content-container > div.catalog-category-wrapper > div.catalog-items > div.catalog-items-list.view-list > div:nth-child(2) > div > div.product-info > div.title > a"));
        WebElement webElement2 = driver.findElement(By.cssSelector("#catalog-items-page > div.page-content-container > div.catalog-category-wrapper > div.catalog-items > div.catalog-items-list.view-list > div:nth-child(3) > div > div.product-info > div.title > a"));

        System.out.println("initialize js");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        System.out.println("exec script scroll to element 1");
        js.executeScript("arguments[0].scrollIntoView();", webElement1);

        System.out.println("click element 2");
        webElement2.click();

        System.out.println("initialize variables");
        String name;
        String cost;

        System.out.println("setup variables");
        name = driver.findElement(By.cssSelector("#product-page > h1")).getText();
        cost = driver.findElement(By.cssSelector("#product-page > div.price-item.ec-price-item > div.node-block > div.item-header.with-tabs > div.col-header.col-order > div.clearfix > div.hidden-xs.hidden-sm.price-block-wrap.price-block-wrap_view_desktop > div > div > div > div.price_g > span")).getText();

        System.out.println("go to main page");
        driver.get(baseUrl);

        System.out.println("menu 1");
        driver.findElement(By.cssSelector("#menu-catalog > li:nth-child(2) > a")).click();

        System.out.println("menu 2");
        driver.findElement(By.cssSelector("body > div.container > main > div.category-items-desktop > a:nth-child(2)")).click();

        System.out.println("menu 3");
        driver.findElement(By.cssSelector("body > div.container > main > div.category-items-desktop > a:nth-child(2)")).click();

        System.out.println("sort button click");
        driver.findElement(By.cssSelector("#sort-filter > div:nth-child(1) > div > button")).click();

        System.out.println("sort select");
        driver.findElement(By.cssSelector("#sort-filter > div:nth-child(1) > div > ul > li:nth-child(1) > a")).click();

        System.out.println("sleep 1s");
        Thread.sleep(1000);

        System.out.println("initialize web element end page");
        WebElement webElementEndPage = driver.findElement(By.cssSelector("#catalog-items-page > div.page-content-container > div.catalog-category-wrapper > div.catalog-items > div.catalog-items-list.view-list > div:nth-child(21) > div > div.product-info > div.title > a"));

        System.out.println("scroll to end page");
        js.executeScript("arguments[0].scrollIntoView();", webElementEndPage);

        System.out.println("sleep 1s");
        Thread.sleep(1000);

        System.out.println("click button to end");
        driver.findElement(By.cssSelector("#catalog-items-page > div.page-content-container > div.catalog-category-wrapper > div.catalog-items > div.pagination-container > div > span:nth-child(10)")).click();

        System.out.println("sleep 1.5s");
        Thread.sleep(1500);

        System.out.println("initialize webelement product");
        WebElement webElement3 = driver.findElement(By.cssSelector("#catalog-items-page > div.page-content-container > div.catalog-category-wrapper > div.catalog-items > div.catalog-items-list.view-list > div:nth-child(4)"));

        System.out.println("scroll to product");
        js.executeScript("arguments[0].scrollIntoView();", webElement3);

        System.out.println("sleep 1s");
        Thread.sleep(1000);

        System.out.println("click on product");
        driver.findElement(By.cssSelector("#catalog-items-page > div.page-content-container > div.catalog-category-wrapper > div.catalog-items > div.catalog-items-list.view-list > div:nth-child(5) > div > div.product-info > div.title > a")).click();

        System.out.println("sleep 1s");
        Thread.sleep(1000);

        System.out.println("assert");
        Assert.assertEquals(name, driver.findElement(By.cssSelector("#product-page > h1")).getText());
        Assert.assertEquals(cost, driver.findElement(By.cssSelector("#product-page > div.price-item.ec-price-item > div.node-block > div.item-header.with-tabs > div.col-header.col-order > div.clearfix > div.hidden-xs.hidden-sm.price-block-wrap.price-block-wrap_view_desktop > div > div > div > div.price_g > span")).getText());

    }

}
