package heroku;

import base.BasePage;
import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class DropdownListPage extends BasePage {

    private static final By dropdown = By.id("dropdown");

    public void selectFromDropdownByIndex(int index) {
        selectFromDropdownByIndex(dropdown, index, WaitStrategy.CLICKABLE, "Dropdown");
    }

    public String getSelectedOptionFromDropdown() {
        return getSelectedValueFromDropdown(dropdown, WaitStrategy.VISIBLE, "Dropdown");
    }
}