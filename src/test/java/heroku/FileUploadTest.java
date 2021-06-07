package heroku;

import annotations.MetaData;
import assertions.Validator;
import base.BaseTest;
import driver.ThreadLocalDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class FileUploadTest extends BaseTest {

    @MetaData(authors = {"Deepan"}, categories = {"Regression"})
    @Test(enabled = false)
    public void fileUploadTest() throws AWTException {
        HerokuHomePage herokuHomePage = new HerokuHomePage();
        FileUploadPage fileUploadPage = new FileUploadPage();

        herokuHomePage.openLink(HerokuHomePage.HomePageLinks.FILE_UPLOAD);

        Validator.verifyTrue(fileUploadPage.isChooseFileDisplayed(),
                "Choose file not displayed!",
                "choose file displayed!");

        fileUploadPage.clickOnChooseFile();

        File file = new File(System.getProperty("user.dir") + "src/test/resources/fileupload/luminoslogo.png");
        StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        ThreadLocalDriver.getDriver().switchTo().window(ThreadLocalDriver.getDriver().getWindowHandle());

        Robot robot = new Robot();

        //Open Goto window
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);

        //Paste the clipboard value
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);

        //Press Enter key to close the Goto window and Upload window
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        fileUploadPage.clickOnUpload();
        System.out.println();
    }
}
