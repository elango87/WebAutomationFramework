package utils;

import driver.ThreadLocalDriver;
import enums.ConfigProperties;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WaitUtil {

    private WaitUtil() {
    }

    public static WebElement waitFor(By by, WaitStrategy waitStrategy) {
        var waitTimeOut = Integer.parseInt(PropertyUtil.getProperty(ConfigProperties.ELEMENT_LOAD_TIMEOUT));
        switch (waitStrategy) {
            case CLICKABLE, ENABLED:
                return new WebDriverWait(ThreadLocalDriver.getDriver(), waitTimeOut)
                        .until(ExpectedConditions.elementToBeClickable(by));
            case VISIBLE:
                return new WebDriverWait(ThreadLocalDriver.getDriver(), waitTimeOut)
                        .until(ExpectedConditions.visibilityOfElementLocated(by));
            case INVISIBLE:
                new WebDriverWait(ThreadLocalDriver.getDriver(), waitTimeOut)
                        .until(ExpectedConditions.invisibilityOfElementLocated(by));
                return ThreadLocalDriver.getDriver().findElement(by);
            case NONE:
            default:
                return ThreadLocalDriver.getDriver().findElement(by);
        }
    }
}