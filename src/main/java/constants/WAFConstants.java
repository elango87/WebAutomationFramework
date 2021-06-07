package constants;

import java.time.LocalDate;
import java.time.LocalTime;

public final class WAFConstants {

    private static final String DIRECTORY_PATH = System.getProperty("user.dir");
    private static final String RESOURCES_DIRECTORY_PATH = DIRECTORY_PATH + "/src/test/resources/";
    private static final String CONFIG_FILE_PATH = RESOURCES_DIRECTORY_PATH + "config/config.properties";
    private static final String EXTENT_REPORTS_DIRECTORY = DIRECTORY_PATH + "/test-output-extent-report/";

    private static String extentReportFilePath;

    private WAFConstants() {
    }

    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }

    public static String getExtentReportFilePath() {
        // Replacing : with _ as jenkins doesn't accept :
        String randomFileName = LocalTime.now().toString().replaceAll(":", "_");
        if (null == extentReportFilePath) {
            extentReportFilePath = EXTENT_REPORTS_DIRECTORY + LocalDate.now() +
                    "/Report_" + randomFileName + ".html";
        }
        return extentReportFilePath;
    }
}