package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

/* Verify user is able to purchase product using registered email id(USE CHROME BROWSER)
Test Steps:
1. Go to http://live.techpanda.org/
2. Click on my account link
3. Login in application using previously created credential
4. Click on MY WISHLIST link
5. In next page, Click ADD TO CART link
6. Enter general shipping country, state/province and zip for the shipping cost estimate
7. Click Estimate
8. Verify Shipping cost generated
9. Select Shipping Cost, Update Total
10. Verify shipping cost is added to total
11. Click "Proceed to Checkout"
12a. Enter Billing Information, and click Continue
12b. Enter Shipping Information, and click Continue
13. In Shipping Method, Click Continue
14. In Payment Information select 'Check/Money Order' radio button. Click Continue
15. Click 'PLACE ORDER' button
16. Verify Oder is generated. Note the order number

NOTE: PROCEED TO CHECKOUT (step 6 ) was taken out, so as to allow the Estimate button step to get processed.
Rest of the steps renumbered accordingly.
*/
@Test
public class test5 {
    public static void testLaunchBrowser() throws InterruptedException {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/index.php");
        driver.findElement(By.xpath("//header[1]/div[1]/div[2]/div[1]/a[1]")).click();
        driver.findElement(By.xpath("//div[1]/ul[1]/li[1]/a[1]")).click();
        driver.findElement(By.xpath("//*[@id='email']")).clear();
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("thientran1@gmail.com");

        driver.findElement(By.xpath("//*[@id='pass']")).clear();
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("123456");

        driver.findElement(By.xpath("//div[2]/button[1]/span[1]/span[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ol[1]/li[2]/a[1]")).click();
        driver.findElement(By.xpath("//li[1]/div[1]/div[3]/ul[1]/li[1]/a[1]")).click();
        driver.findElement(By.xpath("//td[5]/div[1]/button[1]")).click();
        WebElement dropdownElement = driver.findElement(By.xpath("//li[1]/div[1]/select[1]"));
        Select selectOption = new Select(dropdownElement);
        selectOption.selectByVisibleText("Vietnam");
        new Select(driver.findElement(By.cssSelector("select[title=\"Country\"]"))).selectByVisibleText("Vietnam");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"region\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"region\"]")).sendKeys("HCM");
        driver.findElement(By.xpath("//*[@id=\"postcode\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys("123");
        driver.findElement(By.xpath("//div[1]/form[1]/div[1]/button[1]/span[1]/span[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[1]/input[1]")).click();
        driver.findElement(By.xpath("//form[2]/div[1]/button[1]")).click();
        driver.findElement(By.xpath("//div[3]/div[1]/ul[1]/li[1]/button[1]")).click();


        driver.findElement(By.xpath("//*[@id='billing:firstname']")).clear();
        driver.findElement(By.xpath("//*[@id='billing:firstname']")).sendKeys("tran");

        driver.findElement(By.xpath("//*[@id='billing:middlename']")).clear();
        driver.findElement(By.xpath("//*[@id='billing:middlename']")).sendKeys("van");


        driver.findElement(By.xpath("//*[@id='billing:lastname']")).clear();
        driver.findElement(By.xpath("//*[@id='billing:lastname']")).sendKeys("thien");
        driver.findElement(By.xpath("//*[@id='billing:company']")).clear();
        driver.findElement(By.xpath("//*[@id='billing:company']")).sendKeys("ITC");

        driver.findElement(By.xpath("//*[@id='billing:street1']")).clear();
        driver.findElement(By.xpath("//*[@id='billing:street1']")).sendKeys("Tân Phú");


        driver.findElement(By.xpath("//*[@id='billing:street2']")).clear();
        driver.findElement(By.xpath("//*[@id='billing:street2']")).sendKeys("hoàng xuân hành");


        driver.findElement(By.xpath("//*[@id='billing:city']")).clear();
        driver.findElement(By.xpath("//*[@id='billing:city']")).sendKeys("HCM");

        WebElement dropdownElementConty = driver.findElement(By.xpath("//*[@id='billing:country_id']"));
        Select selectOptionConty = new Select(dropdownElementConty);
        selectOptionConty.selectByVisibleText("Vietnam");
        new Select(driver.findElement(By.xpath("//*[@id='billing:country_id']"))).selectByVisibleText("Vietnam");

        driver.findElement(By.xpath("//*[@id='billing:region']")).clear();
        driver.findElement(By.xpath("//*[@id='billing:region']")).sendKeys("HCM");

        driver.findElement(By.xpath("//*[@id=\"billing:postcode\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"billing:postcode\"]")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"billing:telephone\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"billing:telephone\"]")).sendKeys("INFOTHIEN");
        driver.findElement(By.xpath("//*[@id='billing:fax']")).clear();
        driver.findElement(By.xpath("//*[@id='billing:fax']")).sendKeys("INFOTHIEN");
        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button/span/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"dt_method_checkmo\"]/label")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"payment-buttons-container\"]/button/span/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"review-buttons-container\"]/button/span/span")).click();

        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }

    }
}
