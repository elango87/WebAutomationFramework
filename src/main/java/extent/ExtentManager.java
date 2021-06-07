package extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.WAFConstants;
import enums.ConfigProperties;
import org.testng.Reporter;
import utils.PropertyUtil;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public final class ExtentManager {

    private static ExtentReports reports;

    private ExtentManager() {
    }

    public static void initExtentReport() {
        if (null == reports) {
            reports = new ExtentReports();
            var extentSparkReporter = new ExtentSparkReporter(WAFConstants.getExtentReportFilePath());
            reports.attachReporter(extentSparkReporter);

            extentSparkReporter.config().setTheme(Theme.DARK);
            extentSparkReporter.config().setReportName(PropertyUtil.getProperty(ConfigProperties.EXTENT_REPORT_NAME));
            extentSparkReporter.config().setDocumentTitle(PropertyUtil.getProperty(ConfigProperties.EXTENT_REPORT_TITLE));
        }
    }

    public static void flushExtentReport() {
        if (null != reports) {
            reports.flush();
            ThreadLocalExtentReport.unload();
            try {
                Desktop.getDesktop().browse(new File(WAFConstants.getExtentReportFilePath()).toURI());
            } catch (IOException e) {
                Reporter.log("Unable to launch extent report \n" + e.getMessage());
            }
        }
    }

    public static void createReport(String testName) {
        ThreadLocalExtentReport.setExtentTest(reports.createTest(testName));
    }

    public static void assignAuthors(String[] authors) {
        for (String author : authors) {
            ThreadLocalExtentReport.getExtentTest().assignAuthor(author);
        }
    }

    public static void assignCategories(String[] categories) {
        for (String category : categories) {
            ThreadLocalExtentReport.getExtentTest().assignCategory(category);
        }
    }

    public static void assignDevices(String[] devices) {
        for (String device : devices) {
            ThreadLocalExtentReport.getExtentTest().assignDevice(device);
        }
    }
}