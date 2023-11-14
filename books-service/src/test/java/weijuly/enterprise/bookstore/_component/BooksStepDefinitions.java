package weijuly.enterprise.bookstore._component;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.client.RestTemplate;
import weijuly.enterprise.bookstore.client.NotificationClient;
import weijuly.enterprise.bookstore.data.entity.*;
import weijuly.enterprise.bookstore.data.repository.*;
import weijuly.enterprise.bookstore.service.BooksService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.util.ReflectionTestUtils.setField;

public class BooksStepDefinitions {


    private static Logger logger = LoggerFactory.getLogger(BooksStepDefinitions.class);

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplate testRestTemplate;

    @Autowired
    private BooksService booksService;

    @Autowired
    private NotificationClient notificationClient;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private GenreRepository genreRepository;

    @Mock
    private BookGenreRepository bookGenreRepository;

    @Mock
    private BibliographyRepository bibliographyRepository;

    @Mock
    private AuthorGenreRepository authorGenreRepository;

    @Mock
    private KafkaTemplate<String, byte[]> template;

    @Mock
    SendResult<String, byte[]> result;


    @Before("@books")
    public void before() {
        openMocks(this);
        setField(booksService, "bookRepository", bookRepository);
        setField(booksService, "authorRepository", authorRepository);
        setField(booksService, "bibliographyRepository", bibliographyRepository);
        setField(booksService, "genreRepository", genreRepository);
        setField(booksService, "bookGenreRepository", bookGenreRepository);
        setField(booksService, "authorGenreRepository", authorGenreRepository);
        setField(notificationClient, "template", template);
    }

    @After("@books")
    public void after() {
        System.out.println(">>>>> after books >>>>>");
    }

    @When("a book with ISBN {string} exists in the database")
    public void setupFindBookByIsbn(String isbn) {
        when(bookRepository.findByIsbn(isbn))
                .thenReturn(Optional
                        .of(new BookEntity()
                                .id(UUID.randomUUID().toString())
                                .isbn(isbn)));
    }

    @And("BOOK table allows insertion of a row with ISBN {string}")
    public void allowInsertBook(String isbn) {
        when(bookRepository.save(any(BookEntity.class)))
                .thenReturn(new BookEntity()
                        .id(UUID.randomUUID().toString())
                        .isbn(isbn));
    }

    @And("AUTHOR table allows insertion of a row with FULL_NAME {string}")
    public void allowInsertAuthor(String name) {
        when(authorRepository.save(any(AuthorEntity.class)))
                .thenReturn(new AuthorEntity()
                        .id(UUID.randomUUID().toString())
                        .name(name));
    }


    @And("BIBLIOGRAPHY table allows insertion of a row")
    public void allowInsertBibliography() {
        when(bibliographyRepository.save(any(BibliographyEntity.class)))
                .thenReturn(new BibliographyEntity()
                        .id(UUID.randomUUID().toString()));
    }

    @And("GENRE table allows insertion of a row with GENRE_NAME {string}")
    public void allowInsertGenre(String genre) {
        when(genreRepository.save(any(GenreEntity.class)))
                .thenReturn(new GenreEntity()
                        .genreName(genre)
                        .id(UUID.randomUUID().toString()));

    }

    @And("BOOK_GENRE table allows insertion")
    public void allowInsertBookGenre() {
        when(bookGenreRepository.save(any(BookGenreEntity.class))).thenReturn(new BookGenreEntity());
    }

    @And("AUTHOR_GENRE table allows insertion")
    public void allowInsertAuthorGenre() {
        when(authorGenreRepository.save(any(AuthorGenreEntity.class))).thenReturn(new AuthorGenreEntity());
    }

    @And("kafka allows publishing of event")
    public void setupKafka() {
        RecordMetadata metadata = mock(RecordMetadata.class);
        when(result.getRecordMetadata()).thenReturn(metadata);
        when(metadata.offset()).thenReturn(0L);
        when(template.send(anyString(), any(byte[].class)))
                .thenReturn(CompletableFuture.completedFuture(result));
    }

    @Given("the following books exists in the database")
    public void setupBooks(DataTable books) {

    }

    @When("create books API is called with the following payload")
    public void createBook(String payload) {
        String url = getURL();
        HttpEntity<String> request = request(payload);
        log(url, payload);
        ResponseEntity<String> response = testRestTemplate.postForEntity(url, request, String.class);
        log(url, response);
    }

    @And("response of create books API should be {int}")
    public void validateCreateBookResponseCode(int statusCode) {

    }

    @And("a row with ISBN {string} and TITLE {string} should be added to the BOOK table")
    public void validateInsertBook(String isbn, String title) {
        verify(bookRepository, times(1))
                .save(argThat(bookEntity -> {
                    assertEquals(isbn, bookEntity.isbn());
                    assertEquals(title, bookEntity.title());
                    return true;
                }));
    }

    @And("a row with FULL_NAME {string} should be added to the AUTHOR table")
    public void validateInsertAuthor(String name) {
        verify(authorRepository, times(1))
                .save(argThat(authorEntity -> {
                    assertEquals(authorEntity.name(), name);
                    return true;
                }));

    }

    @And("a row should be added to the BIBLIOGRAPHY table")
    public void validateInsertBibliography() {
        verify(bibliographyRepository, times(1))
                .save(any(BibliographyEntity.class));
    }

    @And("rows with the following GENRE_NAME should be added to the GENRE table")
    public void validateInsertGenre(DataTable matrix) {
        List<String> genres = matrix
                .asLists(String.class)
                .stream()
                .map(row -> row.get(0))
                .toList();
        ArgumentCaptor<GenreEntity> captor = ArgumentCaptor.forClass(GenreEntity.class);
        verify(genreRepository, times(genres.size())).save(captor.capture());
        List<GenreEntity> entities = captor.getAllValues();
        for (String genre : genres) {
            assertEquals(1, entities
                    .stream()
                    .filter(e -> e.genreName().equals(genre))
                    .count());
        }
    }

    @And("{int} rows should be added to the BOOK_GENRE table")
    public void validateInsertBookGenre(int rows) {
        verify(bookGenreRepository, times(rows)).save(any(BookGenreEntity.class));
    }

    @And("{int} rows should be added to the AUTHOR_GENRE table")
    public void validateInsertAuthorGenre(int rows) {
        verify(authorGenreRepository, times(rows)).save(any(AuthorGenreEntity.class));
    }

    @And("an event should be published to kafka")
    public void validateKafka() {
        verify(template, times(1)).send(anyString(), any(byte[].class));
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
