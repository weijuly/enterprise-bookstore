package weijuly.enterprise.bookstore.impl;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import weijuly.enterprise.bookstore.api.BooksApi;
import weijuly.enterprise.bookstore.model.SearchBooks;

import java.util.Collections;

@RestController
public class BooksController implements BooksApi {

    @Override
    public ResponseEntity<SearchBooks> searchBooks(String title, String author, Integer publishedAfter,
                                                   Integer publishedBefore) {
        return ResponseEntity.ok(new SearchBooks()
                .page(0)
                .size(0)
                .total(0)
                .books(Collections.emptyList()));
    }
}
