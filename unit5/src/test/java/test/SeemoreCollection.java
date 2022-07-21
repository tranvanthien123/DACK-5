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
public class SeemoreCollection {
    public static void testUrlPageTitleHandle(){
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("https://www.lazada.vn");
        driver.findElement(By.xpath("//a[contains(@class, 'card-fs-content-button')]")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
        driver.close();
        driver.quit();;
    }
}
