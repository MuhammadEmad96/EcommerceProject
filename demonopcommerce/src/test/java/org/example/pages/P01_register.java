package org.example.pages;
import org.example.stepDefinations.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class P01_register {
    public WebElement registerlink()
    {
        return Hooks.driver.findElement(By.className("ico-register"));
    }
    public WebElement gender(){return Hooks.driver.findElement(By.id("gender-male")); }
    public WebElement firstName(){return Hooks.driver.findElement(By.name("FirstName"));}
    public WebElement lastName(){return Hooks.driver.findElement(By.name("LastName"));}
    public Select dayDate(){
        Select daySelect = new Select(Hooks.driver.findElement(By.name("DateOfBirthDay")));
        return daySelect ;}
    public Select monthDate(){
        Select monthSelect = new Select(Hooks.driver.findElement(By.name("DateOfBirthMonth")));
        return monthSelect ;}
    public Select yearDate(){
        Select yearSelect = new Select(Hooks.driver.findElement(By.name("DateOfBirthYear")));
        return yearSelect ; }
    public WebElement mail(){return Hooks.driver.findElement(By.id("Email"));}
    public WebElement password(){return Hooks.driver.findElement(By.id("Password"));}
    public WebElement confirmPassword(){return Hooks.driver.findElement(By.id("ConfirmPassword"));}

    public WebElement pressLogin(){return Hooks.driver.findElement(By.xpath("//button [@class=\"button-1 register-next-step-button\"]"));}
    public WebElement success(){return Hooks.driver.findElement(By.className("result"));}


}
