package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private static final int maxRetry = 2;
    private int retryCount = 0;

    public boolean retry(ITestResult result) {
        if (retryCount < maxRetry) {
            retryCount++;
            return true;
        }
        return false;
    }
}