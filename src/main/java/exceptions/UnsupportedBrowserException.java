package exceptions;

public class UnsupportedBrowserException extends WAFExceptions {

    public UnsupportedBrowserException(String message) {
        super(message);
    }

    public UnsupportedBrowserException(String message, Throwable cause) {
        super(message, cause);
    }
}