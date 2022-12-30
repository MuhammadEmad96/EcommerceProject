package org.example.stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class D03_currenciesStepDef {
    P03_homePage mouse = new P03_homePage();

    @Given("navigate to home page")
    public void homePage(){mouse.Currency().click();}
    @When("select euro currency")
    public void EuroCurrency(){mouse.euroCurrency().click();}
    @Then("all 4 products appear with euro sign")
    public void euroSymbol(){
       String product1 = mouse.products().get(0).getText();
       String product2 = mouse.products().get(1).getText();
       String product3 = mouse.products().get(2).getText();
       String product4 = mouse.products().get(3).getText();
       String expected = "€";
        Assert.assertTrue(product1.contains(expected));
        Assert.assertTrue(product2.contains(expected));
        Assert.assertTrue(product3.contains(expected));
        Assert.assertTrue(product4.contains(expected));
    }
}
