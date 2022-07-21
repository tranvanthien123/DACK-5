package test;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test
public class CheckTitle {
    public static void testUrlPageTitleHandle() {

        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("https://www.lazada.vn/?spm=a2o4n.home.header.dhome.1905e1826ttg38");
            String pageURL = driver.getCurrentUrl();
            String pageTitle = driver.getTitle();

            System.out.println(pageURL);
            System.out.println(pageTitle);

            //debug purpose only
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //7. Quit browser session
        driver.quit();
    }
}
