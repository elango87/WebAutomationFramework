package extent;

import com.aventstack.extentreports.MediaEntityBuilder;
import driver.ThreadLocalDriver;
import enums.ConfigProperties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import utils.PropertyUtil;

public final class ExtentReport {

    private static boolean isScreenshotRequired = PropertyUtil.getProperty(ConfigProperties.SCREENSHOT_REQUIRED).equalsIgnoreCase("true");

    private ExtentReport() {
    }

    public static void pass(String message) {
        if (ThreadLocalDriver.getDriver() != null && ThreadLocalExtentReport.getExtentTest() != null) {
            if (isScreenshotRequired
                    && PropertyUtil.getProperty(ConfigProperties.SCREENSHOT_PASS).equalsIgnoreCase("true")) {
                ThreadLocalExtentReport.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64String()).build());
            } else {
                ThreadLocalExtentReport.getExtentTest().pass(message);
            }
        }
        Reporter.log(message, true);
    }

    public static void fail(String message) {
        if (ThreadLocalDriver.getDriver() != null && ThreadLocalExtentReport.getExtentTest() != null) {
            if (isScreenshotRequired
                    && PropertyUtil.getProperty(ConfigProperties.SCREENSHOT_FAIL).equalsIgnoreCase("true")) {
                ThreadLocalExtentReport.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64String()).build());
            } else {
                ThreadLocalExtentReport.getExtentTest().fail(message);
            }
        }
        Reporter.log(message, true);
    }

    public static void skip(String message) {
        if (ThreadLocalDriver.getDriver() != null && ThreadLocalExtentReport.getExtentTest() != null) {
            if (isScreenshotRequired
                    && PropertyUtil.getProperty(ConfigProperties.SCREENSHOT_SKIP).equalsIgnoreCase("true")) {
                ThreadLocalExtentReport.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64String()).build());
            } else {
                ThreadLocalExtentReport.getExtentTest().skip(message);
            }
        }
        Reporter.log(message, true);
    }

    public static void info(String message) {
        ThreadLocalExtentReport.getExtentTest().info(message);
        Reporter.log(message, true);
    }

    private static String getBase64String() {
        return ((TakesScreenshot) ThreadLocalDriver.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}