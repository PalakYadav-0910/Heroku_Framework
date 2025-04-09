package tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import retry.RetryAnalyzer;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testValidLogin() {
        String username = ConfigReader.getUsername();
        String password = ConfigReader.getPassword();
        logger.info("Opening login page");
        driver.get("https://the-internet.herokuapp.com/login");
        new LoginPage(driver).login(username, password);
        logger.info("Login attempted");
        Assert.assertTrue(driver.getPageSource().contains("You logged into a secure area!"));
        logger.info("Login is successful");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testInvalidLogin() {
        logger.info("Opening login page");
        driver.get("https://the-internet.herokuapp.com/login");
        new LoginPage(driver).login("invalid", "invalid");
        logger.info("Login attempted");
        Assert.assertTrue(driver.getPageSource().contains("Your username is invalid!"));
        logger.info("Invalid Credentials");
    }
}