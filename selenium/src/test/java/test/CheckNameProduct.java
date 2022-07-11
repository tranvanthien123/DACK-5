package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class CheckNameProduct {
    public static void testLaunchBrowser() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("https://www.lazada.vn");
        driver.findElement(By.xpath("//div[1]/div[1]/input[1]")).clear();
        driver.findElement(By.xpath("//div[1]/div[1]/input[1]")).sendKeys("Áo chống nắng nam chất vải kim cương cao cấp, áo khoác chống nắng thun lạnh thời trang");
        driver.findElement(By.xpath("//div[1]/div[2]/button[1]")).click();
        WebElement PricePhoneSony= driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]"));
        String price= PricePhoneSony.getText();
        System.out.println("Price" + price);
        driver.findElement(By.xpath("//div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/img[1]")).click();
        WebElement PriceDetails= driver.findElement(By.xpath("//div[1]/h1[1]"));
        String PriceDetail= PriceDetails.getText();
        System.out.println("PriceDetails" + PriceDetail);
        System.out.println( PriceDetail +"và" + price + price.equals(PriceDetail));

        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
        driver.close();
        driver.quit();


    }
}
