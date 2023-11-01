package weijuly.enterprise.bookstore._component;


import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;
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
public class CucumberComponentTest {
}
