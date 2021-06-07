package enums;

public enum Config {
    URL("app.url"),
    PAGE_LOAD_TIMEOUT("app.pageLoad.timeOut"),
    ELEMENT_LOAD_TIMEOUT("app.elementLoad.timeOut"),
    BROWSER("browser"),
    BROWSER_HEADLESS("browser.headless");

    private final String config;

    Config(String config) {
        this.config = config;
    }

    public String getConfig() {
        return config;
    }
}