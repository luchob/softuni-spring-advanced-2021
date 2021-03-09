package bg.softuni.errors.handler;

public class DBInconsistentException extends RuntimeException {
  public DBInconsistentException(String message) {
    super(message);
  }
}
