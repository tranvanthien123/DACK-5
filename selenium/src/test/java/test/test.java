package test;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
/*
Test Steps:
1. Goto http://live.techpanda.org/2. Click on �MOBILE� menu
3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
4. Click on Sony Xperia mobile
5. Read the Sony Xperia mobile from detail page. 6. Compare Product value in list and details page should be equal ($100).
*/
@Test
public class test {
    public static void test() {
        //test1
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/index.php");
        //test2
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement btnTon = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".level0"))));
        btnTon.click();
        //test2
        WebElement PricePhoneSony = driver.findElement(By.xpath("//ul[1]/li[3]/div[1]/div[1]/span[1]/span[1]"));
        String pricePhoneSony = PricePhoneSony.getText();
        System.out.println("Price Sony" + pricePhoneSony);
        //test4
        driver.findElement(By.xpath("//div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[3]/div[1]/div[3]/ul[1]/li[2]/a[1]")).click();
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement btnTonImg = waits.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#product-collection-image-1"))));
        btnTonImg.click();
        //test4
        WebElement PricePhoneSonyDetails = driver.findElement(By.xpath("//div[1]/span[1]/span[1]"));
        String PriceSonyDetail = PricePhoneSonyDetails.getText();
        System.out.println("Price Sony details : " + PriceSonyDetail);
        System.out.println(pricePhoneSony + "và" + PriceSonyDetail + pricePhoneSony.equals(PriceSonyDetail));
        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
        driver.close();
        driver.quit();
    }
}