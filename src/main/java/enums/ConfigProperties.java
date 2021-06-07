package enums;

public enum ConfigProperties {
    URL("app.url"),
    PAGE_LOAD_TIMEOUT("app.pageLoad.timeOut"),
    ELEMENT_LOAD_TIMEOUT("app.elementLoad.timeOut"),
    BROWSER("browser"),
    BROWSER_HEADLESS("browser.headless"),
    RETRY("retry"),
    RETRY_COUNT("retry.count"),
    EXTENT_REPORT_NAME("extent.report.name"),
    EXTENT_REPORT_TITLE("extent.report.title"),
    SCREENSHOT_REQUIRED("extent.screenshot.required"),
    SCREENSHOT_PASS("extent.screenshot.onPass"),
    SCREENSHOT_FAIL("extent.screenshot.onFail"),
    SCREENSHOT_SKIP("extent.screenshot.onSkip");

    private final String config;

    ConfigProperties(String config) {
        this.config = config;
    }

    public String getConfig() {
        return config;
    }
}