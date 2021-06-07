package heroku;

import base.BasePage;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import utils.XPathUtil;

public final class HerokuHomePage extends BasePage {

    private static final String linkNavigationText = "//a[text()='%s']";

    public void openLink(HomePageLinks links) {
        String homePageLinkText = links.getLink();
        By xpath = XPathUtil.getXPath(linkNavigationText, homePageLinkText);
        click(xpath, WaitStrategy.CLICKABLE, homePageLinkText);
    }

    public enum HomePageLinks {
        A_B_TESTING("A/B Testing"),
        ADD_REMOVE_ELEMENTS("Add/Remove Elements"),
        BASIC_AUTH("Basic Auth"),
        BROKEN_IMAGES("Broken Images"),
        CHALLENGING_DOM("Challenging DOM"),
        CHECKBOXES("Checkboxes"),
        CONTEXT_MENU("Context Menu"),
        DIGEST_AUTHENTICATION("Digest Authentication"),
        DISAPPEARING_ELEMENTS("Disappearing Elements"),
        DRAG_AND_DROP("Drag and Drop"),
        DROPDOWN("Dropdown"),
        DYNAMIC_CONTENT("Dynamic Content"),
        DYNAMIC_CONTROLS("Dynamic Controls"),
        DYNAMIC_LOADING("Dynamic Loading"),
        ENTRY_AD("Entry Ad"),
        EXIT_INTENT("Exit Intent"),
        FILE_DOWNLOAD("File Download"),
        FILE_UPLOAD("File Upload"),
        FLOATING_MENU("Floating Menu"),
        FORGOT_PASSWORD("Forgot Password"),
        FORM_AUTHENTICATION("Form Authentication"),
        FRAMES("Frames"),
        GEOLOCATION("Geolocation"),
        HORIZONTAL_SLIDER("Horizontal Slider"),
        HOVERS("Hovers"),
        INFINITE_SCROLL("Infinite Scroll"),
        INPUTS("Inputs"),
        JQUERY_UI_MENUS("JQuery UI Menus"),
        JAVASCRIPT_ALERTS("JavaScript Alerts"),
        JAVASCRIPT_ONLOAD_EVENT_ERROR("JavaScript onload event error"),
        KEY_PRESSES("Key Presses"),
        LARGE_DEEP_DOM("Large & Deep DOM"),
        MULTIPLE_WINDOWS("Multiple Windows"),
        NESTED_FRAMES("Nested Frames"),
        NOTIFICATION_MESSAGES("Notification Messages"),
        REDIRECT_LINK("Redirect Link"),
        SECURE_FILE_DOWNLOAD("Secure File Download"),
        SHADOW_DOM("Shadow DOM"),
        SHIFTING_CONTENT("Shifting Content"),
        SLOW_RESOURCES("Slow Resources"),
        SORTABLE_DATA_TABLES("Sortable Data Tables"),
        STATUS_CODES("Status Codes"),
        TYPOS("Typos"),
        WYSIWYG_EDITOR("WYSIWYG Editor");

        private String linkText;

        HomePageLinks(String linkText) {
            this.linkText = linkText;
        }

        public String getLink() {
            return linkText;
        }
    }
}