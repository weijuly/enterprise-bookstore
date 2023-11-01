package weijuly.enterprise.bookstore.error;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static weijuly.enterprise.bookstore.constant.ErrorTitles.BAD_REQUEST_TITLE;
import static weijuly.enterprise.bookstore.constant.ErrorTitles.NOT_FOUND_TITLE;
import static weijuly.enterprise.bookstore.constant.ErrorTypes.BAD_REQUEST_TYPE;
import static weijuly.enterprise.bookstore.constant.ErrorTypes.NOT_FOUND_TYPE;

public class BookServiceException extends RuntimeException {

    private final HttpStatus status;
    private final String detail;

    private static Map<HttpStatus, String> types;
    private static Map<HttpStatus, String> titles;

    static {
        types = new HashMap<>();
        types.put(BAD_REQUEST, BAD_REQUEST_TYPE);
        types.put(NOT_FOUND, NOT_FOUND_TYPE);

        titles = new HashMap<>();
        titles.put(BAD_REQUEST, BAD_REQUEST_TITLE);
        titles.put(NOT_FOUND, NOT_FOUND_TITLE);
    }


    public BookServiceException(HttpStatus status, String detail) {
        this.status = status;
        this.detail = detail;
    }

    public String title() {
        return titles.getOrDefault(status, "UNKNOWN");
    }

    public String type() {
        return types.getOrDefault(status, "UNKNOWN");
    }

    public Integer status() {
        return status.value();
    }

    public String detail() {
        return detail;
    }
}
