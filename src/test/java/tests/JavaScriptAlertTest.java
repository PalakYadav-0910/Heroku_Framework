package tests;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlertTest extends BaseTest {

    @Test
    public void handleJSAlerts() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 1. JS Alert - Accept
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert jsAlert = driver.switchTo().alert();
        Assert.assertEquals(jsAlert.getText(), "I am a JS Alert");
        jsAlert.accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You successfully clicked an alert");

        // 2. JS Confirm - Dismiss
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert jsConfirm = driver.switchTo().alert();
        Assert.assertEquals(jsConfirm.getText(), "I am a JS Confirm");
        jsConfirm.dismiss();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");

        // 3. JS Prompt - Send Text and Accept
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert jsPrompt = driver.switchTo().alert();
        Assert.assertEquals(jsPrompt.getText(), "I am a JS prompt");
        String inputText = "Hello World";
        jsPrompt.sendKeys(inputText);
        jsPrompt.accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: " + inputText);
    }
}