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
public class Changelanguage {
    public static void testUrlPageTitleHandle() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("https://www.lazada.vn");
        WebDriverWait waitBtnLanguage = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement btnLanguage= waitBtnLanguage.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#topActionSwitchLang"))));
        btnLanguage.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement btnChange= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".lzd-switch-item:not(.currentSelected)"))));
        btnChange.click();
        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
        driver.close();
        driver.quit();
    }
}
