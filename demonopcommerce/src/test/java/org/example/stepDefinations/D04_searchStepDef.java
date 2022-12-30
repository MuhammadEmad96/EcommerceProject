package org.example.stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class D04_searchStepDef {
    P03_homePage mouse = new P03_homePage();
    @Given("navigate to home page2")
    public void homePage(){
    }
    @When("^Entering product name in search box as \"([^\"]*)\"$")
    public void searchBoxName(String product){
        mouse.SearchBox().sendKeys(product);
    }
    @When("^Entering product sku in search box as \"([^\"]*)\"$")
    public void searchBoxSku(String sku){mouse.SearchBox().sendKeys(sku);}
    @And("press on search")
    public void search() throws InterruptedException {
        mouse.Search().click();
    }
    @Then("^sku shown in page must be the same as one used for search \"([^\"]*)\"$")
    public void sku (String expected){
        mouse.skuItem().click();
       String actual = mouse.skuName().getText();
       Assert.assertEquals(actual,expected);
    }
    @Then("^search shows relevant results as inserted word \"([^\"]*)\"$")
    public void products(String insertedName){
    List<String>productNames = mouse.productName();
       SoftAssert soft = new SoftAssert();
    for(int i=0;i<productNames.size();i++){
        String actual = insertedName.toLowerCase();
        String expected = productNames.get(i).toLowerCase();
        soft.assertTrue(expected.contains(actual));
    }
    }
    @And("navigate to correct URL")
    public void correctURL(){
        String expectedURL="https://demo.nopcommerce.com/search?";
        Assert.assertTrue(mouse.currentURL().contains(expectedURL));
    }
}
