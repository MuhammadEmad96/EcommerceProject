package org.example.stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D08_WishlistStepDef {
    P03_homePage mouse = new P03_homePage();
    @When("you press on heart button for product")
    public void selectProduct(){
        mouse.addToWishlist().click();
    }
    @Then("^you will see success message \"(.*)\"$")
    public void addedSuccessfully(String expected){
        String actual = mouse.addedSuccessfullyMsg().getText();
        Assert.assertTrue(actual.contains(expected));
    }
    @And("Message color has green background")
    public void successMsgColor(){
        String expected = "rgba(75, 176, 122, 1)";
        String actual = mouse.backgroundColor().getCssValue("background-color");
        Assert.assertEquals(actual,expected);
    }

    @And("success message disappears")
    public void successMsgDisappear(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(mouse.addedSuccessfullyMsg()));
    }
    @When("you hover on wishlist icon")
    public void wishListIcon(){
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(mouse.wishList()).perform();
    }
    @Then("quantity value should be more than 0")
    public void wishListQuantity(){
        String actual = mouse.wishList().getText();
        Assert.assertTrue(actual !="0");
    }
}
