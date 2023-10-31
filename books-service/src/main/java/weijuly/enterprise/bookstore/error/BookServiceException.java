package weijuly.enterprise.bookstore.error;

public class BookServiceException extends RuntimeException {

    private final Integer code;
    private final String description;

    public BookServiceException(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
