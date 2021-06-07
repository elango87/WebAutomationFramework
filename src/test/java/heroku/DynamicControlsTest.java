package heroku;

import annotations.MetaData;
import assertions.Validator;
import base.BaseTest;
import org.testng.annotations.Test;

public final class DynamicControlsTest extends BaseTest {

    @MetaData(authors = {"Deepan"}, categories = {"Regression"})
    @Test
    public void removeAddTest() {
        HerokuHomePage herokuHomePage = new HerokuHomePage();
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();

        herokuHomePage.openLink(HerokuHomePage.HomePageLinks.DYNAMIC_CONTROLS);
        dynamicControlsPage.clickOnRemove();

        Validator.assertTrue(dynamicControlsPage.isAddDisplayed(),
                "Add button is not displayed!",
                "Add button is displayed!");

        Validator.verifyTrue(dynamicControlsPage.isRemoveAddMessageDisplayed(),
                "Remove/Add message is not displayed!",
                "Remove/Add message is displayed!");
    }

    @MetaData(authors = {"Elango"}, categories = {"Regression"})
    @Test
    public void enableDisableTest() {
        HerokuHomePage herokuHomePage = new HerokuHomePage();
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();

        herokuHomePage.openLink(HerokuHomePage.HomePageLinks.DYNAMIC_CONTROLS);
        dynamicControlsPage.clickOnEnable();

        Validator.verifyTrue(dynamicControlsPage.isDisableDisplayed(),
                "Disable button not displayed!",
                "Disable button is displayed!");

        Validator.verifyTrue(dynamicControlsPage.isEnableDisableTextBoxEnabled(),
                "Enable/Disable text box is not enabled!",
                "Enabled/Disable text box is enabled!");
        Validator.verifyTrue(dynamicControlsPage.isEnableDisableMessageDisplayed(),
                "It's enabled message is not displayed!",
                "It's enabled message is displayed!");
    }
}