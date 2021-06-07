package heroku;

import base.BaseTest;
import driver.ThreadLocalDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public final class HomePageTest extends BaseTest {

    @Test
    public void homePageTest() {
        List<WebElement> linkList = ThreadLocalDriver.getDriver().findElements(By.xpath("//a"));

        for (WebElement e : linkList) {
            String linkText = e.getText();
            System.out.println(linkText.toUpperCase().replaceAll(" ", "_") + "(\"" + e.getText() + "\"),");
        }
    }

    @Test
    public void clickOnLinkTest() {
        HerokuHomePage homePage = new HerokuHomePage();
        homePage.clickOnLink(HerokuHomePage.HomePageLinks.A_B_TESTING);
    }
}