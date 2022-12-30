package org.example.stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    P01_register register = new P01_register();
    @Given("user go to register page")
    public void goRegisterPage()
    {
        register.registerlink().click();
    }
    @When("user select gender type")
    public void genderSelection(){register.gender().click();}

    @And("user enter his first name")
    public void firstNameEntering(){register.firstName().sendKeys("automation");}
    @And("user enter his  last name")
    public void lastNameEntering(){register.lastName().sendKeys("tester");}
    @And("user enter his birth date")
    public void dateSelection(){
        register.dayDate().selectByValue("1");
        register.monthDate().selectByValue("12");
        register.yearDate().selectByValue("1996");
    }
    @And("user enter his email")
    public void mailEntering(){
        register.mail().sendKeys("test01@example.com");
    }
    @And("user enter his password")
    public void passwordEntering(){
        register.password().sendKeys("P@ssw0rd");
        register.confirmPassword().sendKeys("P@ssw0rd");
    }
    @And("user press on Register button")
    public void accountCreation(){
        register.pressLogin().click();
    }
    @Then("Success Msg is displayed")
    public void successCreation(){
       String expectedResult = "Your registration completed";
       String actualResult = register.success().getText();
       String expectedColor = Hooks.driver.findElement(By.className("result")).getCssValue("color");
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(expectedColor,"rgba(76, 177, 124, 1)");
        soft.assertTrue(actualResult.contains(expectedResult));
        soft.assertAll();
    }
}
