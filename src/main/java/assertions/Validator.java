package assertions;

import extent.ExtentReport;
import org.testng.Assert;

public final class Validator {

    private Validator() {
    }

    public static boolean verifyTrue(boolean condition, String failMessage, String successMessage) {
        try {
            Assert.assertTrue(condition, failMessage);
            ExtentReport.pass("Verified!!! " + successMessage);
            return true;
        } catch (AssertionError e) {
            ExtentReport.fail("Failed!!!" + failMessage);
            return false;
        }
    }

    public static boolean verifyFalse(boolean condition, String failMessage, String successMessage) {
        try {
            Assert.assertFalse(condition, failMessage);
            ExtentReport.pass("Verified!!! " + successMessage);
            return true;
        } catch (AssertionError e) {
            ExtentReport.fail("Failed!!!" + failMessage);
            return false;
        }
    }

    public static boolean verifyEquals(Object actual, Object expected, String failMessage, String successMessage) {
        try {
            Assert.assertEquals(actual, expected, failMessage);
            ExtentReport.pass("Verified!!! " + successMessage);
            return true;
        } catch (AssertionError e) {
            ExtentReport.fail("Failed!!!" + failMessage);
            return false;
        }
    }

    public static void assertTrue(boolean condition, String failMessage, String successMessage) {
        if (!verifyTrue(condition, failMessage, successMessage)) {
            throw new AssertionError(failMessage);
        }
    }

    public static void assertFalse(boolean condition, String failMessage, String successMessage) {
        if (!verifyFalse(condition, failMessage, successMessage)) {
            throw new AssertionError(failMessage);
        }
    }

    public static void assertEquals(Object actual, Object expected, String failMessage, String passMessage) {
        if (!verifyEquals(actual, expected, failMessage, passMessage)) {
            throw new AssertionError(failMessage);
        }
    }
}