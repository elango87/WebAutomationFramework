package exceptions;

public class WAFExceptions extends RuntimeException {

    public WAFExceptions(String message) {
        super(message);
    }

    public WAFExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}