package heroku;

import base.BasePage;
import driver.ThreadLocalDriver;
import extent.ThreadLocalExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.DriverManager;
import java.util.List;

public final class BrokenImagesPage extends BasePage {

    public List<WebElement> getImagesList() {
        return ThreadLocalDriver.getDriver().findElements(By.xpath("//img"));
    }
}