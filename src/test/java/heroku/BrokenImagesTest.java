package heroku;

import annotations.MetaData;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public final class BrokenImagesTest extends BaseTest {

    @MetaData(authors = {"Elango"}, categories = {"Regression"})
    @Test
    public void brokenImagesTest() {
        HerokuHomePage herokuHomePage = new HerokuHomePage();
        BrokenImagesPage brokenImagesPage = new BrokenImagesPage();

        herokuHomePage.openLink(HerokuHomePage.HomePageLinks.BROKEN_IMAGES);
        List<WebElement> elementList = brokenImagesPage.getImagesList();

        int brokenCount = 0;
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getAttribute("naturalWidth").equals("0")) {
                System.out.println(elementList.get(i).getAttribute("outerHTML") + "is broken");
                brokenCount++;
            }
        }

        Assert.assertTrue(elementList.size() == brokenCount,
                "{" + brokenCount + "} out of {" + elementList.size() + "} image links are broken");
    }
}
