package weijuly.enterprise.bookstore.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import weijuly.enterprise.bookstore.model.Book;
import weijuly.enterprise.bookstore.model.proto.BookProto;
import weijuly.enterprise.bookstore.transformer.BookTransformer;

import java.util.Objects;

@Component
public class NotificationClient {

    private ObjectMapper mapper;

    @Autowired
    private KafkaTemplate<String, byte[]> template;

    @PostConstruct
    public void init() {
        mapper = new ObjectMapper();
    }


    public void notify(Book book) {

        BookProto bookProto = BookProto
                .newBuilder()
                .setId(book.getId())
                .build();

        template
                .send("books", BookTransformer.proto(book).toByteArray())
                .whenComplete((r, e) -> {
                    if (Objects.nonNull(e)) {
                        System.out.println("Something went wrong: " + e.toString());
                    } else {
                        System.out.println("published message with offset: " + r.getRecordMetadata().offset());
                    }
                });
    }
}
