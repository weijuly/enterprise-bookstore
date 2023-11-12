package weijuly.enterprise.bookstore.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import weijuly.enterprise.bookstore.api.BooksApi;
import weijuly.enterprise.bookstore.model.Book;
import weijuly.enterprise.bookstore.service.BooksService;

@RestController
public class BooksController implements BooksApi {

    @Autowired
    private BooksService booksService;

    @Override
    public ResponseEntity<Book> addBook(Book book) {
        return ResponseEntity.ok(booksService.add(book));
    }

    @Override
    public ResponseEntity<Book> getBookById(String id) {
        return ResponseEntity.ok(booksService.getBookById(id));
    }
}
