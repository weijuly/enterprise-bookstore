package weijuly.enterprise.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksServiceApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(BooksServiceApplication.class, args);
//        Server server = ServerBuilder
//                .forPort(8080)
//                .addService(new BooksServiceImpl()).build();
//        server.start();
//        server.awaitTermination();
    }
}
