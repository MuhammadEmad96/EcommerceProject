package org.example.stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D06_homeSlidersStepDef {
    P03_homePage mouse = new P03_homePage();
    @Given("when home page is loaded")
    public void homePage(){}
    @When("you select slider image of iphone 14 pro and press on it")
    public void iphoneSlider() throws InterruptedException {
        mouse.iphoneSlider().get(0).click();
        mouse.iphoneSlider().get(1).click();
    }
    @When("you select slider image of Galaxy S22 ultra and press on it")
    public void galaxySlider() throws InterruptedException {
        mouse.galaxySlider().get(0).click();
        mouse.galaxySlider().get(1).click();
    }
    @Then("you should navigate to iphone 14 pro product page")
    public void iphonePage(){
        String expected = mouse.iphonePage();
        String actual = Hooks.driver.getCurrentUrl();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expected));
        Assert.assertTrue(actual.contains(expected),"you didn't navigate to selected url correctly");
    }
    @Then("you should navigate to Galaxy S22 ultra product page")
    public void galaxyPage(){
        String expected = mouse.galaxyPage();
        String actual = Hooks.driver.getCurrentUrl();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expected));
        Assert.assertTrue(actual.contains(expected),"you didn't navigate to selected url correctly");
    }
}
