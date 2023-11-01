package weijuly.enterprise.bookstore.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import weijuly.enterprise.bookstore.model.ProblemDetails;

import java.net.URI;
import java.util.Collections;
import java.util.Optional;

import static weijuly.enterprise.bookstore.constant.ErrorTitles.BAD_REQUEST_TITLE;
import static weijuly.enterprise.bookstore.constant.ErrorTypes.BAD_REQUEST_TYPE;

@RestControllerAdvice
public class ControllerExceptionHandler {

    private static final String UNREADABLE_MESSAGE = "https://enterprise-bookstore.com/problems/unredable-message";

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ProblemDetails> handle(HttpMessageNotReadableException e) {
        return ResponseEntity
                .badRequest()
                .body(new ProblemDetails()
                        .type(BAD_REQUEST_TYPE)
                        .title(BAD_REQUEST_TITLE)
                        .status(HttpStatus.BAD_REQUEST.value())
                        .detail(String.format("The request body cannot be read: %s", e.getMessage()))
                        .instance(getPath(e))
                        .errors(Collections.emptyList()));
    }

    @ExceptionHandler(value = BookServiceException.class)
    public ResponseEntity<ProblemDetails> handle(BookServiceException e) {
        return ResponseEntity
                .status(e.status())
                .body(new ProblemDetails()
                        .type(e.type())
                        .title(e.title())
                        .status(e.status())
                        .detail(e.detail())
                        .errors(Collections.emptyList()));
    }

    private String getPath(HttpMessageNotReadableException e) {
        return Optional
                .ofNullable(e)
                .map(HttpMessageNotReadableException::getHttpInputMessage)
                .map(HttpMessage::getHeaders)
                .map(HttpHeaders::getLocation)
                .map(URI::getPath)
                .orElse("unknown");
    }
}
