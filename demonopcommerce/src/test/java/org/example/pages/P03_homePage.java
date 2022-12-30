package org.example.pages;

import org.example.stepDefinations.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class P03_homePage {
    String oldTab = Hooks.driver.getWindowHandle();
    public void homePage() {
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
    }

    public WebElement Currency() {
        return Hooks.driver.findElement(By.id("customerCurrency"));
    }

    public WebElement euroCurrency() {
        return Hooks.driver.findElement(By.cssSelector("option[value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]"));
    }

    public ArrayList<WebElement> products() {
        ArrayList<WebElement> product = new ArrayList<WebElement>();
        product.add(Hooks.driver.findElement(By.xpath("//span[text()='€1032.00']")));
        product.add(Hooks.driver.findElement(By.xpath("//span[text()='€1548.00']")));
        product.add(Hooks.driver.findElement(By.xpath("//span[text()='€210.70']")));
        product.add(Hooks.driver.findElement(By.xpath("//span[text()='€21.50']")));
        return product;
    }

    public WebElement SearchBox() {
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }

    public WebElement Search() {
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));
    }

    public String currentURL() {
        return Hooks.driver.getCurrentUrl();
    }

    public String product() {
        return String.valueOf(Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).size());
    }

    public List<String> productName() {
        int size = 0;
        int size2 = 0;
        WebElement productName = Hooks.driver.findElement(By.xpath("//div[@class=\"item-grid\"]"));
        List<WebElement> products = productName.findElements(By.xpath("*"));
        int size1 = products.size();
        List<String> names1 = new ArrayList<>();
        for (int i = 1; i <= size1; i++) {
            names1.add(Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[" + i + "]/div/div[2]/h2/a")).getText());
        }
        try {
            if (Hooks.driver.findElement(By.className("next-page")).isDisplayed()) {
                Hooks.driver.findElement(By.xpath("//a[@data-page=\"2\"]")).click();
                Thread.sleep(1000);
                WebElement productName2 = Hooks.driver.findElement(By.xpath("//div[@class=\"item-grid\"]"));
                List<WebElement> products2 = productName2.findElements(By.xpath("*"));
                size2 = products2.size();
                size = size1 + size2;
                for (int i = 1; i <= size2; i++) {
                    names1.add(Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[" + i + "]/div/div[2]/h2/a")).getText());
                }
            }
        } catch (Exception e) {
            size = size1;
        }
        return names1;
    }

    public String mainCateogory() {
        WebElement itemsMain = Hooks.driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"]"));
        List<WebElement> items = itemsMain.findElements(By.xpath("*"));
        int size = items.size();
        int randNum = ThreadLocalRandom.current().nextInt(0, size);
        WebElement item = items.get(randNum);
        String selectedElement = item.getText();
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(item).click().build().perform();
        if (randNum < 3) {
            int sizeSub = 3;
            int randNum2 = ThreadLocalRandom.current().nextInt(0, sizeSub);
            switch (randNum2) {
                case 1: {
                    WebElement subItem = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/h2/a"));
                    selectedElement = subItem.getText();
                    action.moveToElement(subItem).click().build().perform();

                    break;
                }
                case 2: {
                    WebElement subItem = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[2]/div/h2/a"));
                    selectedElement = subItem.getText();
                    action.moveToElement(subItem).click().build().perform();
                    break;
                }
                case 3: {
                    WebElement subItem = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[3]/div/h2/a"));
                    selectedElement = subItem.getText();
                    action.moveToElement(subItem).click().build().perform();

                    break;
                }
            }
        } else {
            action.click().build().perform();
        }
        return selectedElement;
    }

    public WebElement headerName() {
        return Hooks.driver.findElement(By.xpath("//div[@class=\"page-title\"]"));
    }

    public WebElement skuItem() {
        WebElement item = Hooks.driver.findElement(By.xpath("//h2[@class=\"product-title\"]"));
        return item.findElement(By.xpath("*"));
    }

    public WebElement skuName() {
   return Hooks.driver.findElement(By.xpath("//div[@class=\"sku\"]//span[@class=\"value\"]"));
    }
    public List<WebElement> iphoneSlider(){
        List<WebElement> iphoneSliderList = new ArrayList<>();
        iphoneSliderList.add(Hooks.driver.findElement(By.cssSelector("a[rel=\"0\"]")));
        iphoneSliderList.add(Hooks.driver.findElement(By.id("nivo-slider")));
        return iphoneSliderList;
    }
    public String iphonePage(){
        return "https://demo.nopcommerce.com/iphone-14";
    }
    public List<WebElement> galaxySlider(){
        List<WebElement> galaxySliderList = new ArrayList<>();
        galaxySliderList.add(Hooks.driver.findElement(By.cssSelector("a[rel=\"1\"]")));
        galaxySliderList.add(Hooks.driver.findElement(By.id("nivo-slider")));
        return galaxySliderList;
    }
    public String galaxyPage(){
        return "https://demo.nopcommerce.com/nokia-lumia-1020";
    }
    public WebElement facebookPage(){
        return Hooks.driver.findElement(By.xpath("(//a[@target=\"_blank\"])[1]"));
    }
    public WebElement twitterPage(){
        return Hooks.driver.findElement(By.xpath("(//a[@target=\"_blank\"])[2]"));
    }
    public WebElement youtubePage(){
        return Hooks.driver.findElement(By.xpath("(//a[@target=\"_blank\"])[3]"));
    }
    public WebElement rssLink(){
        return Hooks.driver.findElement(By.xpath("//a[text()='RSS']"));
    }
    public WebElement addToWishlist(){
        return Hooks.driver.findElement(By.xpath("(//button[@class=\"button-2 add-to-wishlist-button\"])[3]"));}
    public WebElement addedSuccessfullyMsg(){return Hooks.driver.findElement(By.xpath("//p[@class=\"content\"]"));}
    public WebElement backgroundColor(){
        return Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }
    public WebElement wishList(){
        return Hooks.driver.findElement(By.cssSelector("span[class=\"wishlist-qty\"]"));
    }
}
