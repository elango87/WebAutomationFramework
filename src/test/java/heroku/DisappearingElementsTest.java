package heroku;

import annotations.MetaData;
import base.BaseTest;
import org.testng.annotations.Test;

public class DisappearingElementsTest extends BaseTest {

    @MetaData(authors = {"Elango"}, categories = {"Regression"})
    @Test
    public void disappearingElementsTest() {
        HerokuHomePage herokuHomePage = new HerokuHomePage();
        DisappearingElementsPage disappearingElementsPage = new DisappearingElementsPage();

        herokuHomePage.openLink(HerokuHomePage.HomePageLinks.DISAPPEARING_ELEMENTS);
        disappearingElementsPage.clickOnLink(DisappearingElementsPage.DisappearingLinks.ABOUT);

        System.out.println();

        // Implementation pending
        // Validate 404
    }
}
