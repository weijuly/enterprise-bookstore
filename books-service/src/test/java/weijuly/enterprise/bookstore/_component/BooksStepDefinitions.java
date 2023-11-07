package weijuly.enterprise.bookstore._component;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class BooksStepDefinitions {


    private static Logger logger = LoggerFactory.getLogger(BooksStepDefinitions.class);

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplate template;

    @Before("@books")
    public void before() {
        System.out.println(">>>>> before books >>>>>");
    }

    @After("@books")
    public void after() {
        System.out.println(">>>>> after books >>>>>");

    }

    @When("a book with ISBN {string} exists in the database")
    public void setupBooks(String isbn) {

        System.out.println(">>>>> create books API is called >>>>>");
    }

    @Given("the following books exists in the database")
    public void setupBooks(DataTable books) {

    }

    @When("create books API is called with the following payload")
    public void createBook(String payload) {
        String url = getURL();
        HttpEntity<String> request = request(payload);
        log(url, payload);
        ResponseEntity<String> response = template.postForEntity(url, request, String.class);
        log(url, response);
    }

    @And("response of create books API should be {int}")
    public void validateCreateBookResponseCode(int statusCode) {

    }

    @And("a row with ISBN {string} and TITLE {string} should be added to the BOOK table")
    public void validateInsertBook(String isbn, String title) {

    }

    @And("a row with FULL_NAME {string} should be added to the AUTHOR table")
    public void validateInsertAuthor(String name) {

    }

    @And("a row should be added to the BIBLIOGRAPHY table")
    public void validateInsertBibliography() {

    }

    @And("a row with GENRE_NAME {string} should be added to the GENRE table")
    public void validateInsertGenre(String genre) {

    }

    @And("a row should be added to the BOOK_GENRE table")
    public void validateInsertBookGenre() {

    }

    @And("a row should be added to the AUTHOR_GENRE table")
    public void validateInsertAuthorGenre() {

    }

    private String getURL() {
        return String.format("http://localhost:%d/books", port);
    }

    private <T> HttpEntity<T> request(T payload) {
        return new HttpEntity<>(payload, headers());
    }

    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return headers;
    }

    private void log(String url, String payload) {
        logger.info("\nPOST: {}\n{}", url, payload);
    }

    private void log(String url, ResponseEntity<String> response) {
        logger.info("\n{}: {}\n{}", url, response.getStatusCode().value(), response.getBody());

    }


}
