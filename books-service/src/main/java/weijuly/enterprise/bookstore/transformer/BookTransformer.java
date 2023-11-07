package weijuly.enterprise.bookstore.transformer;

import weijuly.enterprise.bookstore.data.entity.BookEntity;
import weijuly.enterprise.bookstore.model.Book;
import weijuly.enterprise.bookstore.model.proto.BookProto;

import java.util.stream.Collectors;

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

    public static BookProto proto(Book book) {
        return BookProto
                .newBuilder()
                .setId(book.getId())
                .setTitle(book.getTitle())
                .setIsbn(book.getIsbn())
                .setSummary(book.getSummary())
                .setPublishedOn(book.getPublishedOn())
                .addAllGenres(book.getGenres())
                .addAllAuthors(book
                        .getAuthors()
                        .stream()
                        .map(AuthorTransformer::proto)
                        .collect(Collectors.toList()))
                .build();
    }

}
