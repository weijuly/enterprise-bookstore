package weijuly.enterprise.bookstore._util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.charset.Charset;

import static org.apache.commons.io.FileUtils.readFileToString;
import static org.junit.jupiter.api.Assertions.fail;

public class TestDataLoader {

    private static final String DIR = "src/test/resources/data/%s";

    public static String load(String filename) {
        try {
            return readFileToString(new File(String.format(DIR, filename)), Charset.defaultCharset());
        } catch (Exception e) {
            return fail(String.format("Cannot load file: %s, error: %s", filename, e.toString()));
        }

    }

    public static <T> T load(String filename, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(load(filename), clazz);
        } catch (Exception e) {
            return fail(String.format("Cannot load file: %s, error: %s", filename, e.toString()));
        }

    }
}
