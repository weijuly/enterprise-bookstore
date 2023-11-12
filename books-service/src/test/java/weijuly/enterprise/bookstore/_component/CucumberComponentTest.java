package weijuly.enterprise.bookstore._component;


import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import weijuly.enterprise.bookstore.BooksServiceApplication;

@Suite
@CucumberContextConfiguration
@IncludeEngines("cucumber")
@SelectDirectories("src/test/resources/feature")
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {
                BooksServiceApplication.class
        })
@ExtendWith(MockitoExtension.class)
public class CucumberComponentTest {
}
