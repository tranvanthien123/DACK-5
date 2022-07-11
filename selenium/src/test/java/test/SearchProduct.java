package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test
public class SearchProduct {
    public static void testLaunchBrowser() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("https://www.lazada.vn");
        driver.findElement(By.xpath("//div[1]/div[1]/input[1]")).clear();
        driver.findElement(By.xpath("//div[1]/div[1]/input[1]")).sendKeys("Áo chống nắng nam chất vải kim cương cao cấp, áo khoác chống nắng thun lạnh thời trang");
        driver.findElement(By.xpath("//div[1]/div[2]/button[1]")).click();

    }
}
