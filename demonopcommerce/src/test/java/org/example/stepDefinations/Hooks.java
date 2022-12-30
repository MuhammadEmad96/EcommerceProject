package org.example.stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void starting(){
        //1-Bridge
        String myPath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe" ;
        System.setProperty("webdriver.chrom.driver",myPath);
        //2-Object creation
        driver = new ChromeDriver();
        //3-Configuration
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //4-navigate to url
        driver.navigate().to("https://demo.nopcommerce.com/");
        }
    @After
    public static void quitBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
