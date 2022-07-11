package test;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.AssertJUnit.assertEquals;
/*
Test Steps:
1. Goto http://live.techpanda.org/2. Click on �MOBILE� menu
3. In mobile products list , click on �Add To Compare� for 2 mobiles (Sony Xperia & Iphone)
4. Click on �COMPARE� button. A popup window opens
5. Verify the pop-up window and check that the products are reflected in it
Heading "COMPARE PRODUCTS" with selected products in it.
6. Close the Popup Windows
*/
@Test
public class test2 {
    public static void testLaunchBrowser() throws InterruptedException {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/index.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement btnTon = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".level0"))));
        btnTon.click();
        WebElement TitleSony= driver.findElement(By.xpath("//li[3]/div[1]/h2[1]/a[1]"));
        System.out.println("Sony Title : " + TitleSony.getText());
        WebElement TitleSamSung= driver.findElement(By.xpath("//ul[1]/li[2]/div[1]/h2[1]/a[1]"));
        System.out.println("Samsung Title : " + TitleSamSung.getText());
        driver.findElement(By.xpath("//li[3]/div[1]/div[3]/ul[1]/li[2]/a[1]")).click();
        driver.findElement(By.xpath("//li[2]/div[1]/div[3]/ul[1]/li[2]/a[1]")).click();
        driver.findElement(By.xpath("//div[2]/div[1]/button[1]")).click();
        driver.findElement(By.xpath("//button[@title='Compare']")).click();
        driver.findElement(By.xpath("//div[2]/div[1]/button[1]/span[1]/span[1]")).click();
        Thread.sleep(2000);
// switching to new window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
// 5. Verify the pop-up window and check that the products are reflected in it
//    Heading "COMPARE PRODUCTS" with selected products in it.
        String strHead = ("COMPARE PRODUCTS");
        String compHead = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[1]/h1")).getText();
        System.out.println("compHead = "+compHead);
        String popupMobile1 = driver.findElement(By.xpath("//h2/a[@title='Samsung Galaxy']")).getText();  // text captured is "SAMSUNG" in uppercase
        String popupMobile2 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();  // text captured "SONY XPERIA" in uppercase
        System.out.println("popupMobile1 = "+popupMobile1);
        System.out.println("popupMobile2 = "+popupMobile2);
        Thread.sleep(2000);
// to check the popup heading/title
        try {
            assertEquals(strHead, compHead);
        } catch (Exception e) {
            e.printStackTrace();
        }
// to check the 2 mobiles selected are the two in the popup - this is tp check the IPhone
        try {
            assertEquals(TitleSamSung.getText(), popupMobile1);
        } catch (Exception e) {
            e.printStackTrace();
        }
// to check the 2 mobiles selected are the two in the popup - this is to check Sony X
        try {
            assertEquals(TitleSony.getText(), popupMobile2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(2000);
        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
        driver.close();
        driver.quit();
    }
}