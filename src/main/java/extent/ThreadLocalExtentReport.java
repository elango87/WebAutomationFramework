package extent;

import com.aventstack.extentreports.ExtentTest;

public class ThreadLocalExtentReport {

    private static ThreadLocal<ExtentTest> threadLocalExtentTest = new ThreadLocal<>();

    private ThreadLocalExtentReport() {
    }

    public static ExtentTest getExtentTest() {
        return threadLocalExtentTest.get();
    }

    public static void setExtentTest(ExtentTest extentTest) {
        threadLocalExtentTest.set(extentTest);
    }

    public static void unload() {
        threadLocalExtentTest.remove();
    }
}