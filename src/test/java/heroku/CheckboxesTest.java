package heroku;

import annotations.MetaData;
import base.BaseTest;
import org.testng.annotations.Test;

public final class CheckboxesTest extends BaseTest {

    @MetaData(authors = {"Elango"}, categories = {"Regression"})
    @Test
    public void checkboxesTest() {
        HerokuHomePage herokuHomePage = new HerokuHomePage();
        CheckboxesPage checkboxesPage = new CheckboxesPage();

        herokuHomePage.openLink(HerokuHomePage.HomePageLinks.CHECKBOXES);
        checkboxesPage.clickCheckbox1();
    }
}