package driver;

import org.openqa.selenium.WebDriver;

public final class ThreadLocalDriver {

    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    private ThreadLocalDriver() {
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public static void setDriver(WebDriver driver) {
        threadLocalDriver.set(driver);
    }

    public static void unload() {
        threadLocalDriver.remove();
    }
}