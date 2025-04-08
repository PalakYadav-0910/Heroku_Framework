package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.net.URL;
import java.util.HashMap;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        try {
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("latest");

            HashMap<String, Object> ltOptions = new HashMap<>();
            ltOptions.put("username", System.getenv("LT_USERNAME"));
            ltOptions.put("accessKey", System.getenv("LT_ACCESS_KEY"));
            ltOptions.put("project", "Heroku Automation");
            ltOptions.put("selenium_version", "4.0.0");
            ltOptions.put("w3c", true);
            ltOptions.put("build", "Heroku Login Tests");
            ltOptions.put("name", this.getClass().getSimpleName());

            browserOptions.setCapability("LT:Options", ltOptions);

            driver = new RemoteWebDriver(
                    new URL("https://hub.lambdatest.com/wd/hub"),
                    browserOptions
            );

            System.out.println("Session ID: " + ((RemoteWebDriver) driver).getSessionId());

        } catch (Exception e) {
            System.err.println("Driver setup failed:");
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}