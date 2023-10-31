package weijuly.enterprise.bookstore.transformer;

import weijuly.enterprise.bookstore.data.entity.BookEntity;
import weijuly.enterprise.bookstore.model.Book;

public class BookTransformer {

    public static Book transform(BookEntity bookEntity) {
        return new Book();
    }

    public static BookEntity transform(Book book) {
        return new BookEntity()
                .id(book.getId())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .summary(book.getSummary())
                .publishedOn(book.getPublishedOn())
                .pages(book.getPages());
    }
}
