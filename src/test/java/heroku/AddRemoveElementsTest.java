package heroku;

import annotations.MetaData;
import assertions.Validator;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class AddRemoveElementsTest extends BaseTest {

    @MetaData(authors = {"Elango"}, categories = {"Regression"})
    @Test
    public void addElementTest() {
        HerokuHomePage herokuHomePage = new HerokuHomePage();
        AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage();

        herokuHomePage.openLink(HerokuHomePage.HomePageLinks.ADD_REMOVE_ELEMENTS);

        addRemoveElementsPage.clickOnAddElement();

        Validator.assertTrue(addRemoveElementsPage.isDeleteDisplayed(),
                "Delete button is Not displayed!",
                "Delete button is displayed!");
    }

    @MetaData(authors = {"Elango"}, categories = {"Regression"})
    @Test()
    public void deleteElementTest() {
        HerokuHomePage herokuHomePage = new HerokuHomePage();
        AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage();

        herokuHomePage.openLink(HerokuHomePage.HomePageLinks.ADD_REMOVE_ELEMENTS);
        addRemoveElementsPage.clickOnAddElement();

        addRemoveElementsPage.clickOnDelete();
        Assert.assertFalse(addRemoveElementsPage.isDeleteDisplayed());
        Validator.assertFalse(addRemoveElementsPage.isDeleteDisplayed(),
                "Delete button is displayed!",
                "Delete button is not displayed!");
    }
}
