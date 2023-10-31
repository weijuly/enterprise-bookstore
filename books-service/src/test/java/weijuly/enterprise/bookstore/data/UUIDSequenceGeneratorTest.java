package weijuly.enterprise.bookstore.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UUIDSequenceGeneratorTest {

    @Test
    public void test() {
        UUIDSequenceGenerator generator = new UUIDSequenceGenerator();
        assertNotNull(generator.generate(null, null));
    }
}