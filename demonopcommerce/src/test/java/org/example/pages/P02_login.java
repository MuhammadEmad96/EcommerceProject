package org.example.pages;
import org.example.stepDefinations.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_login {
    public WebElement loginPage (){
        return Hooks.driver.findElement(By.className("ico-login"));}
    public WebElement loginEmail(){
        return Hooks.driver.findElement(By.id("Email"));
    }
    public WebElement loginPassword(){
        return Hooks.driver.findElement(By.id("Password"));
    }
    public WebElement loginButton(){return Hooks.driver.findElement(By.linkText("Log in"));}
    public String getUrl(){return Hooks.driver.getCurrentUrl();}
    public WebElement myAccount(){return Hooks.driver.findElement(By.cssSelector("a[href=\"/customer/info\"]"));}
    public WebElement failToLogin()  {
        return Hooks.driver.findElement(By.xpath("//div[text()='Login was unsuccessful. Please correct the errors and try again.']"));}
}
