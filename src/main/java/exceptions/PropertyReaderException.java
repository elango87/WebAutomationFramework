package exceptions;

public class PropertyReaderException extends WAFExceptions {
    public PropertyReaderException(String message) {
        super(message);
    }

    public PropertyReaderException(String message, Throwable cause) {
        super(message, cause);
    }
}