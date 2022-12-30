package org.example.stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class D05_hoverCategoriesStepDef {
    P03_homePage mouse = new P03_homePage();
    String expected=null;
    @When("Select a category and a sub category")
    public void Category(){
       // String expected =
       expected = mouse.mainCateogory();
       expected.toLowerCase().trim();
        //System.out.println(expected);
    }
    @Then("compare the selected category with header title")
    public void headerName(){
        String actual = mouse.headerName().getText();
        actual.toLowerCase().trim();
        Assert.assertEquals(actual,expected);
    }
}
