package heroku;

import base.BasePage;
import enums.WaitStrategy;
import org.openqa.selenium.By;

public class EntryAdPage extends BasePage {

    private static final By linkClickHere = By.id("restart-ad");
    private static final By textModalTitle = By.className("modal-title");
    private static final By textModalBody = By.className("modal-body");
    private static final By textModalFooter = By.className("modal-footer");
    private static final By linkClose = By.xpath("//p[contains(text(),'Close')]");


    public EntryAdPage clickOnClickHere() {
        click(linkClickHere, WaitStrategy.CLICKABLE, "click here");
        return this;
    }

    public boolean isModalDisplayed() {
        return isDisplayed(textModalTitle, WaitStrategy.VISIBLE, "Modal Window");
    }

    public EntryAdPage clickOnClose() {
        click(linkClose, WaitStrategy.CLICKABLE, "Close");
        return this;
    }
}