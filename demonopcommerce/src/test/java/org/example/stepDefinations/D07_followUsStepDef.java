package org.example.stepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class D07_followUsStepDef {
    P03_homePage mouse = new P03_homePage();
    @When("user opens facebook link")
    public void openFacebookPage(){
        mouse.facebookPage().click();
    }
    @When("user opens twitter link")
    public void openTwitterPage(){
        mouse.twitterPage().click();
    }
    @When("user opens rss link")
    public void openRssLink(){
        String clicklnk = Keys.chord(Keys.CONTROL,Keys.ENTER);
        mouse.rssLink().sendKeys(clicklnk);
    }
    @When("user opens youtube link")
    public void openYoutubePage(){
        mouse.youtubePage().click();
    }


    @Then("^\"(.*)\" is opened in new tab$")
    public void secondTab(String expected) throws InterruptedException {
        String oldTab = Hooks.driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<String>(Hooks.driver.getWindowHandles());
        newTab.remove(oldTab);
        Hooks.driver.switchTo().window(newTab.get(0));
        Thread.sleep(2000);
        String actual = mouse.currentURL();
        Assert.assertEquals(actual,expected);
        Hooks.driver.close();
        Hooks.driver.switchTo().window(oldTab);
    }
}
