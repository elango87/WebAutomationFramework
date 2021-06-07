package heroku;

import annotations.MetaData;
import assertions.Validator;
import base.BaseTest;
import org.testng.annotations.Test;

public final class EntryAdTest extends BaseTest {

    @MetaData(authors = {"Deepan"}, categories = {"Regression"})
    @Test
    public void entryAdTest() {
        HerokuHomePage herokuHomePage = new HerokuHomePage();
        EntryAdPage entryAdPage = new EntryAdPage();

        herokuHomePage.openLink(HerokuHomePage.HomePageLinks.ENTRY_AD);

        Validator.assertTrue(entryAdPage.isModalDisplayed(),
                "Modal not displayed!",
                "Modal is displayed!");

        Validator.assertTrue(entryAdPage.clickOnClose()
                        .clickOnClickHere()
                        .isModalDisplayed(),
                "Modal not displayed!",
                "Modal is displayed!");

    }
}