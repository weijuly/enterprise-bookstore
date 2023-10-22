package weijuly.enterprise.bookstore.impl;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import weijuly.enterprise.bookstore.models.Book;
import weijuly.enterprise.bookstore.models.BookId;
import weijuly.enterprise.bookstore.models.BooksServiceGrpc;

@GrpcService
public class BooksServiceImpl extends BooksServiceGrpc.BooksServiceImplBase {

    @Override
    public void getBook(BookId bookId, StreamObserver<Book> response) {
        Book book = Book
                .newBuilder()
                .setBookId("123456")
                .build();
        response.onNext(book);
        response.onCompleted();
    }
}
