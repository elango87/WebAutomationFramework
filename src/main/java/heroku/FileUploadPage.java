package heroku;

import base.BasePage;
import enums.WaitStrategy;
import org.openqa.selenium.By;

public class FileUploadPage extends BasePage {

    private static final By buttonUpload = By.id("file-submit");
    private static final By buttonChooseFile = By.xpath("//input[@id='file-upload']");
    private static final By dragDropUpload = By.id("drag-drop-upload");

    public FileUploadPage clickOnUpload() {
        click(buttonUpload, WaitStrategy.CLICKABLE, "Upload");
        return this;
    }

    public FileUploadPage clickOnChooseFile() {
        actionClick(buttonChooseFile, WaitStrategy.CLICKABLE, "Choose File");
        return this;
    }

    public boolean isChooseFileDisplayed() {
        return isDisplayed(buttonChooseFile, WaitStrategy.VISIBLE, "Choose file");
    }

    public FileUploadPage clickOnDragDropUpload() {
        click(dragDropUpload, WaitStrategy.VISIBLE, "Drag and Drop Upload");
        return this;
    }
}