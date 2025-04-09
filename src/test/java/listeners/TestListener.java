package listeners;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import utils.ScreenshotUtil;

public class TestListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        Object obj = result.getInstance();
        WebDriver driver = ((BaseTest) obj).getDriver();
        ScreenshotUtil.takeScreenshot(driver, result.getName());
    }
}