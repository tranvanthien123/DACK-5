package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class test3 {
    public static void test() throws InterruptedException {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/index.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement btnTon = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".level0"))));
        btnTon.click();
        //test3
        driver.findElement(By.xpath("//li[3]/div[1]/div[3]/button[1]/span[1]/span[1]")).click();
        //test4
        WebElement qty = driver.findElement(By.xpath("//td[4]/input[1]"));
        // driver.findElement(By.xpath("//td[4]/input[1]")).click();
        // driver.findElement(By.xpath("//td[4]/input[1]")).clear();
        // driver.findElement(By.xpath("//td[4]/input[1]")).sendKeys("1000");
        // driver.findElement(By.xpath("//td[4]/input[1]")).click();
        qty.click();
        qty.clear();
        qty.sendKeys("1000");
        driver.findElement(By.xpath("//td[4]/button[1]/span[1]/span[1]")).click();
        //Steps 5: Verify the error message
        String sfaill = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[2]/p")).getText();
        System.out.println(sfaill);
        String pass = "* The requested quantity for Sony Xperia is not available.";
        Assert.assertEquals(pass, sfaill);
        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
        driver.close();
        driver.quit();
    }
}
