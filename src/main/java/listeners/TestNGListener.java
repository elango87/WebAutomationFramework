package listeners;

import annotations.MetaData;
import extent.ExtentManager;
import extent.ExtentReport;
import org.testng.*;

public class TestNGListener implements ISuiteListener, ITestListener {

    public void onStart(ISuite suite) {
        ExtentManager.initExtentReport();
    }

    public void onFinish(ISuite suite) {
        ExtentManager.flushExtentReport();
    }

    public void onTestStart(ITestResult result) {
        ExtentManager.createReport(result.getMethod().getMethodName());
        ExtentManager.assignAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(MetaData.class).authors());
        ExtentManager.assignCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(MetaData.class).categories());
        ExtentManager.assignDevices(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(MetaData.class).devices());
        ExtentReport.info("Starting test {" + result.getMethod().getMethodName() + "}...");
    }

    public void onTestSuccess(ITestResult result) {
        ExtentReport.pass("Test {" + result.getMethod().getMethodName() + "} passed!");
    }

    public void onTestFailure(ITestResult result) {
        ExtentReport.fail("Test {" + result.getMethod().getMethodName() + "} failed!");
    }

    public void onTestSkipped(ITestResult result) {
        ExtentReport.skip("Test {" + result.getMethod().getMethodName() + "} skipped!");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }
}