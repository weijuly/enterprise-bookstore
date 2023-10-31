package weijuly.enterprise.bookstore._integration;


import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import weijuly.enterprise.bookstore._util.TestDataLoader;
import weijuly.enterprise.bookstore.model.Book;


public class IntegrationTest {

    @Test
    public void test() {
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Book book = TestDataLoader.load("request/create-book.201.json", Book.class);
        HttpEntity<Book> request = new HttpEntity<Book>(book, headers);
        ResponseEntity<String> response = template.postForEntity("http://localhost:8080/books", request, String.class);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());

    }
}
