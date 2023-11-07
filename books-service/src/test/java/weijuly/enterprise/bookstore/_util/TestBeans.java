package weijuly.enterprise.bookstore._util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TestBeans {

    @Autowired
    NoOpErrorHandler handler;

    @Bean
    RestTemplate template() {
        RestTemplate template = new RestTemplate();
        template.setErrorHandler(handler);
        return template;
    }
}
