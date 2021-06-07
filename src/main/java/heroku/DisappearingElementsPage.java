package heroku;

import base.BasePage;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import utils.XPathUtil;

public class DisappearingElementsPage extends BasePage {

    private static By linkHome = By.xpath("//a[text()='Home']");
    private static By linkAbout = By.xpath("//a[text()='About']");
    private static By linkContactUs = By.xpath("//a[text()='Contact Us']");
    private static By linkPortfolio = By.xpath("//a[text()='Portfolio']");
    private static By linkGallery = By.xpath("//a[text()='Gallery']");

    public void clickOnLink(DisappearingLinks linkText) {
        String xpath = "//a[text()='%s']";
        By dynamicBy = XPathUtil.getXPath(xpath, linkText.getProperty());
        click(dynamicBy, WaitStrategy.CLICKABLE, linkText.getProperty());
    }

    public enum DisappearingLinks {
        HOME("Home"),
        ABOUT("About"),
        CONTACTUS("Contact Us"),
        PORTFOLIO("Portfolio"),
        GALLERY("Gallery");

        private String property;

        DisappearingLinks(String property) {
            this.property = property;
        }

        public String getProperty() {
            return this.property;
        }
    }
}