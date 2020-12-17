package exception;

public class ChickenException extends IllegalArgumentException {

    public ChickenException(String message) {
        super("[ERROR] " + message + System.lineSeparator());
    }
}
