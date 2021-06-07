package heroku;

import annotations.MetaData;
import assertions.Validator;
import base.BaseTest;
import org.testng.annotations.Test;

public class DropdownListTest extends BaseTest {

    @MetaData(authors = {"Deepan"}, categories = {"Regression"})
    @Test
    public void dropdownListTest() {
        HerokuHomePage herokuHomePage = new HerokuHomePage();
        DropdownListPage dropdownListPage = new DropdownListPage();

        herokuHomePage.openLink(HerokuHomePage.HomePageLinks.DROPDOWN);

        String dropdownOption = "Option 2";
        dropdownListPage.selectFromDropdownByIndex(2);

        Validator.assertEquals(dropdownListPage.getSelectedOptionFromDropdown(), dropdownOption,
                "Dropdown option is not {" + dropdownOption + "}",
                "Dropdown option is {" + dropdownOption + "}");
    }
}