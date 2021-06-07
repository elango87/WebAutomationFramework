package driver;

import enums.ConfigProperties;
import exceptions.UnsupportedBrowserException;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.PropertyUtil;

import java.util.concurrent.TimeUnit;

public final class DriverManager {

    private DriverManager() {
    }

    public static void initDriver() {
        String browser = PropertyUtil.getProperty(ConfigProperties.BROWSER);
        var isHeadless = Boolean.parseBoolean(PropertyUtil.getProperty(ConfigProperties.BROWSER_HEADLESS));

        if (browser.equals("chrome")) {
            initChromeDriver(isHeadless);
        } else if (browser.equals("firefox")) {
            initFirefoxDriver(isHeadless);
        } else if (browser.equals("edge")) {
            initEdgeDriver();
        } else if (browser.equals("safari")) {
            initSafariDriver();
        } else {
            throw new UnsupportedBrowserException("Browser {" + browser + "} not supported!. " +
                    "Please check config.properties!");
        }
        driverCommonConfig();
    }

    private static void driverCommonConfig() {
        var pageLoadTimeOut = Integer.parseInt(PropertyUtil.getProperty(ConfigProperties.PAGE_LOAD_TIMEOUT));
        String appUrl = PropertyUtil.getProperty(ConfigProperties.URL);

        ThreadLocalDriver.getDriver().manage().window().maximize();
        ThreadLocalDriver.getDriver().manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
        ThreadLocalDriver.getDriver().get(appUrl);
    }

    private static void initChromeDriver(boolean isHeadless) {
        var options = new ChromeOptions();
        if (Boolean.TRUE.equals(isHeadless)) {
            options.setHeadless(true);
        }
        WebDriverManager.chromedriver().setup();
        ThreadLocalDriver.setDriver(new ChromeDriver(options));
    }

    private static void initFirefoxDriver(Boolean isHeadless) {
        var options = new FirefoxOptions();
        if (Boolean.TRUE.equals(isHeadless)) {
            options.setHeadless(true);
        }
        WebDriverManager.firefoxdriver().setup();
        ThreadLocalDriver.setDriver(new FirefoxDriver(options));
    }

    private static void initEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        ThreadLocalDriver.setDriver(new EdgeDriver());
    }

    private static void initSafariDriver() {
        if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
            throw new UnsupportedBrowserException("Safari is supported only on Mac. " +
                    "Please update the browser and try again!");
        }
        DriverManagerType safari = DriverManagerType.SAFARI;
        WebDriverManager.getInstance(safari).setup();
        try {
            Class<?> safariClass = Class.forName(safari.browserClass());
            ThreadLocalDriver.setDriver((WebDriver) safariClass.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            throw new UnsupportedBrowserException("Unable to open Safari browser!" + e.getMessage());
        }
    }

    public static void quitDriver() {
        ThreadLocalDriver.getDriver().quit();
        ThreadLocalDriver.unload();
    }
}