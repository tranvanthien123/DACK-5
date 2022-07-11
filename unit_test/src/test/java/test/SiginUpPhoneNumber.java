package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test
public class SiginUpPhoneNumber {
    public static void testUrlPageTitleHandle(){
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("https://www.lazada.vn");
        driver.findElement(By.xpath("//div[1]/div[1]/div[1]/div[1]/div[7]/a[1]")).click();
        driver.findElement(By.xpath("//div[1]/div[1]/div[1]/input[1]")).clear();
        driver.findElement(By.xpath("//div[1]/div[1]/div[1]/input[1]")).sendKeys("123456789");
        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
        driver.close();
        driver.quit();
    }
}
