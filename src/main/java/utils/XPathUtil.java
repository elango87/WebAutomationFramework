package utils;

import org.openqa.selenium.By;

public final class XPathUtil {

    private XPathUtil() {
    }

    public static By getXPath(String xpath, String value) {
        return By.xpath(String.format(xpath, value));
    }

    public static By getXPath(String xpath, String value1, String value2) {
        return By.xpath(String.format(xpath, value1, value2));
    }

    public static By getXPath(String xpath, String value1, String value2, String value3) {
        return By.xpath(String.format(xpath, value1, value2, value3));
    }

    public static void main(String[] args) {
        String xpath1 = "//div[text()='%s']";
        String xpath2 = "//div[text()='%s' and @value='%s']";
        String xpath3 = "//a[@id='%s']//div[@name='%s']//div[@value='%s']";

        System.out.println(getXPath(xpath1, "menu-item"));
        System.out.println(getXPath(xpath2, "menu-item", "laptop"));
        System.out.println(getXPath(xpath3, "menu-item", "fashion", "t-shirts"));
    }
}
