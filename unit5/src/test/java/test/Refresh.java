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
public class Refresh {
    public static void testUrlPageTitleHandle() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("https://www.lazada.vn");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement btnTon = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".lzd-logo-content"))));
        btnTon.click();
        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
        driver.close();
        driver.quit();
    }
}
