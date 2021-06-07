package base;

import driver.ThreadLocalDriver;
import enums.WaitStrategy;
import extent.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasePage {

    public void click(By by, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        element.click();
        ExtentReport.pass("{" + elementDescription + "} clicked!");
    }

    public void clear(By by, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        element.clear();
        ExtentReport.pass("Text in {" + elementDescription + "} cleared!");
    }

    public void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        element.sendKeys(value);
        ExtentReport.pass("{" + value + "} set as value in {" + elementDescription + "}");
    }

    public String getText(By by, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        String text = element.getText();
        ExtentReport.pass("Text in {" + elementDescription + "} is {" + text + "}");
        return text;
    }

    public String getAttribute(By by, String attribute, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        String attributeValue = element.getAttribute(attribute);
        ExtentReport.pass("Attribute {" + attribute + "} of {" + elementDescription + "} is {" + attributeValue + "}");
        return attributeValue;
    }

    public boolean isDisplayed(By by, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        boolean isDisplayed = element.isDisplayed();
        ExtentReport.pass("{" + elementDescription + "} is displayed {" + isDisplayed + "}");
        return isDisplayed;
    }

    public boolean isSelected(By by, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        boolean isSelected = element.isSelected();
        ExtentReport.pass("{" + elementDescription + "} is selected {" + isSelected + "}");
        return isSelected;
    }

    public boolean isEnabled(By by, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        boolean isEnabled = element.isEnabled();
        ExtentReport.pass("{" + elementDescription + "} is enabled {" + isEnabled + "}");
        return isEnabled;
    }

    protected void actionClick(By by, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        var actions = new Actions(ThreadLocalDriver.getDriver());
        actions.moveToElement(element)
                .click()
                .build()
                .perform();
        ExtentReport.pass("{" + elementDescription + "} clicked!");
    }

    protected void selectFromDropdownByValue(By by, String value, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        var select = new Select(element);
        try {
            select.selectByValue(value);
        } catch (NoSuchElementException e) {
            ExtentReport.fail("{" + value + "} is not present in {" + elementDescription + "} dropdown");
            throw new AssertionError("Dropdown with value {" + value + "} is not found in {" + elementDescription + "} dropdown!\n" +
                    "Values available are {" + getDropdownValues(by, waitStrategy, elementDescription) + "}");
        }
        ExtentReport.pass("{" + value + "} is selected from {" + elementDescription + "} dropdown");
    }

    protected void selectFromDropdownByIndex(By by, int index, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        var select = new Select(element);
        try {
            select.selectByIndex(index);
        } catch (NoSuchElementException e) {
            ExtentReport.fail("{" + index + "} is not present in {" + elementDescription + "} dropdown");
            throw new AssertionError("Index {" + index + "} not found in {" + elementDescription + "} dropdown!\n" +
                    "Please check! Size of the dropdown is {" + select.getOptions().size() + "}, " +
                    "Values are {" + getDropdownValues(by, waitStrategy, elementDescription) + "}");
        }
        String value = select.getFirstSelectedOption().getText();
        ExtentReport.pass("{" + value + "} is selected from {" + elementDescription + "}");
    }

    protected List<String> getDropdownValues(By by, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        var select = new Select(element);
        List<String> dropdownValuesList = new ArrayList<>();
        for (WebElement option : select.getOptions()) {
            dropdownValuesList.add(option.getText());
        }
        ExtentReport.info("Values in {" + elementDescription + "} dropdown are {" + dropdownValuesList + "}");
        return dropdownValuesList;
    }

    protected String getSelectedValueFromDropdown(By by, WaitStrategy waitStrategy, String elementDescription) {
        WebElement element = WaitUtil.waitFor(by, waitStrategy);
        var select = new Select(element);
        String selectedValue = select.getFirstSelectedOption().getText();
        ExtentReport.info("Selected value in {" + elementDescription + "} dropdown is {" + selectedValue + "}");
        return selectedValue;
    }

    protected String getWindowHandle() {
        String windowHandle = ThreadLocalDriver.getDriver().getWindowHandle();
        ExtentReport.pass("Window handle is {" + windowHandle + "}");
        return windowHandle;
    }

    protected Set<String> getWindowHandles() {
        Set<String> windowHandles = ThreadLocalDriver.getDriver().getWindowHandles();
        ExtentReport.pass("Window handles set {" + windowHandles + "}");
        return windowHandles;
    }

    protected void switchToWindow(String windowName) {
        ThreadLocalDriver.getDriver().switchTo().window(windowName);
        ExtentReport.pass("Switch to {" + windowName + "} window!");
    }

    protected void alertAccept() {
        ThreadLocalDriver.getDriver().switchTo().alert().accept();
        ExtentReport.pass("Alert accepted!");
    }

    protected void alertDismiss() {
        ThreadLocalDriver.getDriver().switchTo().alert().dismiss();
        ExtentReport.pass("Alert dismissed!");
    }

    protected String getAlertText() {
        String alertText = ThreadLocalDriver.getDriver().switchTo().alert().getText();
        ExtentReport.pass("Alert text is {" + alertText + "}");
        return alertText;
    }

    protected void enterAlertText(String value, String elementDescription) {
        ThreadLocalDriver.getDriver().switchTo().alert().sendKeys(value);
        ExtentReport.pass("{" + value + "} is set as value in to {" + elementDescription + "}");
    }

    protected String getPageTitle() {
        String title = ThreadLocalDriver.getDriver().getTitle();
        ExtentReport.pass("Page title is {" + title + "}");
        return title;
    }

    protected String getCurrentUrl() {
        String currentUrl = ThreadLocalDriver.getDriver().getCurrentUrl();
        ExtentReport.pass("Current Url is {" + currentUrl + "}");
        return currentUrl;
    }

    protected String getPageSource() {
        String pageSource = ThreadLocalDriver.getDriver().getPageSource();
        ExtentReport.pass("Page source is {" + pageSource + "}");
        return pageSource;
    }
}