package heroku;

import base.BasePage;
import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class DynamicControlsPage extends BasePage {

    private static final By checkboxACheckbox = By.xpath("//input[@label='blah']");
    private static final By buttonAdd = By.xpath("//button[text()='Add']");
    private static final By buttonRemove = By.xpath("//button[text()='Remove']");
    private static final By textRemoveAddMessage = By.xpath("//form[@id='checkbox-example']//p[@id='message']");

    private static final By buttonEnable = By.xpath("//button[text()='Enable']");
    private static final By buttonDisable = By.xpath("//button[text()='Disable']");
    private static final By textBoxEnableDisable = By.xpath("//form[@id='input-example']//input");
    private static final By textEnableDisableMessage = By.xpath("//form[@id='input-example']//p[@id='message']");


    public void clickOnRemove() {
        click(buttonRemove, WaitStrategy.CLICKABLE, "Remove");
    }

    public boolean isAddDisplayed() {
        return isDisplayed(buttonAdd, WaitStrategy.CLICKABLE, "Add");
    }

    public boolean isRemoveAddMessageDisplayed() {
        return isDisplayed(textRemoveAddMessage, WaitStrategy.VISIBLE, "It's gone!");
    }

    public void clickOnEnable() {
        click(buttonEnable, WaitStrategy.CLICKABLE, "Enable");
    }

    public boolean isDisableDisplayed() {
        return isDisplayed(buttonDisable, WaitStrategy.CLICKABLE, "Disable");
    }

    public boolean isEnableDisableMessageDisplayed() {
        return isDisplayed(textEnableDisableMessage, WaitStrategy.VISIBLE, "It's enabled!");
    }

    public boolean isEnableDisableTextBoxEnabled() {
        return isEnabled(textBoxEnableDisable, WaitStrategy.ENABLED, "Enable/Disable text box");
    }
}