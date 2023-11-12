package weijuly.enterprise.bookstore.config;

import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracingConfig {

    @Value("${tracing.url}")
    private String url;

    @Bean
    public OtlpGrpcSpanExporter exporter() {
        return OtlpGrpcSpanExporter
                .builder()
                .setEndpoint(url)
                .build();
    }
}
