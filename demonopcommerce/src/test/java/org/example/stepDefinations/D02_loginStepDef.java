package org.example.stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class D02_loginStepDef {
    P02_login login = new P02_login();

    @Given("user go to login page")
    public void loginPage(){ login.loginPage().click();}

    @When("^user login with \"(.*)\" and \"(.*)\"$")
    public void login(String email , String Password)  {
    login.loginEmail().sendKeys(email);
    login.loginPassword().sendKeys(Password);

    }
    @And("user press on login button")
    public void pressLogin() throws InterruptedException {
        login.loginPassword().sendKeys(Keys.ENTER);
    }
    @Then("user login to the system successfully")
    public void successLogin() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        String current_URL = login.getUrl();
        String expected_URL = "https://demo.nopcommerce.com/";
        soft.assertEquals(current_URL,expected_URL);
        soft.assertTrue(login.myAccount().isDisplayed());
        soft.assertAll();
    }
    @Then("user could not login to system")
    public void failLogin() throws InterruptedException {
       String expected = "Login was unsuccessful. Please correct the errors and try again.";
       String actual = login.failToLogin().getText();
       SoftAssert soft = new SoftAssert();
       String color = login.failToLogin().getCssValue("color");
       soft.assertEquals(color,"rgba(228, 67, 75, 1)");
       soft.assertTrue(actual.contains(expected));
       soft.assertAll();
    }
}
