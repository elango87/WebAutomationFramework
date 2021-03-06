package base;

import driver.DriverManager;
import enums.ConfigProperties;
import listeners.TestNGListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import utils.PropertyUtil;

@Listeners({TestNGListener.class})
public class BaseTest {

    @BeforeMethod
    @Parameters({"browserName"})
    public void setUp(String browserName) {
        PropertyUtil.setProperty(ConfigProperties.BROWSER, browserName);
        DriverManager.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}