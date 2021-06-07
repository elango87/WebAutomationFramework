package base;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import utils.WaitUtil;

public class BasePage {

    public void click(By by, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        element.click();
        Reporter.log("{" + elementDescription + "} clicked!", true);
    }

    public void clear(By by, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        element.clear();
        Reporter.log("Text in {" + elementDescription + "} cleared!");
    }

    public void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        element.sendKeys(value);
        Reporter.log("{" + value + "} set as value in {" + elementDescription + "}");
    }

    public String getText(By by, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        String text = element.getText();
        Reporter.log("Text in {" + elementDescription + "} is {" + text + "}");
        return text;
    }

    public String getAttribute(By by, String attribute, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        String attributeValue = element.getAttribute(attribute);
        Reporter.log("Attribute {" + attribute + "} of {" + elementDescription + "} is {" + attributeValue + "}");
        return attributeValue;
    }

    public boolean isDisplayed(By by, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        boolean isDisplayed = element.isDisplayed();
        Reporter.log("{" + elementDescription + "} is displayed {" + isDisplayed + "}");
        return isDisplayed;
    }

    public boolean isSelected(By by, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        boolean isSelected = element.isSelected();
        Reporter.log("{" + elementDescription + "} is displayed {" + isSelected + "}");
        return isSelected;
    }

    public boolean isEnabled(By by, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        boolean isEnabled = element.isEnabled();
        Reporter.log("{" + elementDescription + "} is displayed {" + isEnabled + "}");
        return isEnabled;
    }
}