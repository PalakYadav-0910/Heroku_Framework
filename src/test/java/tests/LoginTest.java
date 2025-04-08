package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testValidLogin() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys(ConfigReader.getUsername());
        driver.findElement(By.id("password")).sendKeys(ConfigReader.getPassword());
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assert.assertTrue(driver.getPageSource().contains("You logged into a secure area!"));
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testInvalidLogin() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("invalid");
        driver.findElement(By.id("password")).sendKeys("invalid");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assert.assertTrue(driver.getPageSource().contains("Your username is invalid!"));
    }
}