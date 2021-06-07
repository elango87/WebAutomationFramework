package heroku;

import base.BasePage;
import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class CheckboxesPage extends BasePage {

    private static final By checkboxCheckbox1 = By.xpath("//input[@type='checkbox'][1]");
    private static final By checkboxCheckbox2 = By.xpath("//input[@type='checkbox'][2]");

    public void clickCheckbox1() {
        click(checkboxCheckbox1, WaitStrategy.CLICKABLE, "Checkbox 1");
    }

    public void clickCheckbox2() {
        click(checkboxCheckbox2, WaitStrategy.CLICKABLE, "Checkbox 2");
    }

    public boolean isCheckbox1Checked() {
        return isSelected(checkboxCheckbox1, WaitStrategy.VISIBLE, "Checkbox 1");
    }

    public boolean isCheckbox2Checked() {
        return isSelected(checkboxCheckbox2, WaitStrategy.VISIBLE, "Checkbox 2");
    }
}