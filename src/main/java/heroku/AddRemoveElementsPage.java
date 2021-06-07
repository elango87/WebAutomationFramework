package heroku;

import base.BasePage;
import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class AddRemoveElementsPage extends BasePage {

    public static By buttonAddElement = By.xpath("//button[text()='Add Element']");
    public static By buttonDelete = By.xpath("//button[text()='Delete']");

    public AddRemoveElementsPage clickOnAddElement() {
        click(buttonAddElement, WaitStrategy.CLICKABLE, "Add Element");
        return this;
    }

    public AddRemoveElementsPage clickOnDelete() {
        click(buttonDelete, WaitStrategy.CLICKABLE, "Delete");
        return this;
    }

    public boolean isDeleteDisplayed() {
        return isDisplayed(buttonDelete, WaitStrategy.VISIBLE, "Delete");
    }
}
