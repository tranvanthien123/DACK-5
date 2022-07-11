package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class CheckPrice {
    public static void testLaunchBrowser() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("https://www.lazada.vn");
        driver.findElement(By.xpath("//div[1]/div[1]/input[1]")).clear();
        driver.findElement(By.xpath("//div[1]/div[1]/input[1]")).sendKeys("[Có Bán sỉ] ÁO THUN S.A.d.b.o.i.z chữ 7 màu TAY LỠ FORM RỘNG HOT NHẤT HÈ 2022 CHẤT LIỆU COTTON 100% CÓ ẢNH THẬT");
        driver.findElement(By.xpath("//div[1]/div[2]/button[1]")).click();
        WebElement PricePhoneSony= driver.findElement(By.xpath("//div[1]/div[2]/div[3]/span[1]"));
        String price= PricePhoneSony.getText();
        System.out.println("Price" + price);
        driver.findElement(By.xpath("//div[1]/div[1]/div[1]/a[1]/div[1]/img[1]")).click();
        WebElement PriceDetails= driver.findElement(By.xpath("//div[8]/div[1]/div[1]/span[1]"));
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
