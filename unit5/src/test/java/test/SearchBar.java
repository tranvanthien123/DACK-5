package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
@Test
public class SearchBar {
    public static void testUrlPageTitleHandle() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("https://www.lazada.vn");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id='q']")).clear();
        driver.findElement(By.xpath("//*[@id='q']")).sendKeys("Máy In");
        WebElement btnSearch = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".search-box__button--1oH7"))));
        btnSearch.click();
        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
        driver.close();
        driver.quit();


    }
}
