package listeners;

import enums.ConfigProperties;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.PropertyUtil;

public class RetryListener implements IRetryAnalyzer {

    private static final boolean RETRY = Boolean.parseBoolean(PropertyUtil.getProperty(ConfigProperties.RETRY));
    private static final int MAX_RETRY_COUNT = Integer.parseInt(PropertyUtil.getProperty(ConfigProperties.RETRY_COUNT));
    int count = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (RETRY && (count < MAX_RETRY_COUNT)) {
            count++;
            return true;
        }
        return false;
    }
}