package models;
public class ClientException extends  Exception {
    /**
     * Exception class
     * @param message
     */
    public ClientException(String message) {
        super(message);
    }

    /**
     * Exception with Throwabale and message.
     * @param message
     * @param cause
     */
    public ClientException(String message,
                           Throwable cause) {
        super(message, cause);
    }

    /**
     * Exeption with only Throwable.
     * @param cause
     */
    public ClientException(Throwable cause) {
        super(cause);
    }
}

