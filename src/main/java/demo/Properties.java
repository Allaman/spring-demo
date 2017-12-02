package demo;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

import org.springframework.boot.context.properties.ConfigurationProperties;
import javax.validation.constraints.Max;

@Data
@ToString(includeFieldNames = false)
@Component
@Configuration
@ConfigurationProperties("app")
public class Properties {
    private Cache cache;
    private Cors cors;

    @Data
    @ToString(includeFieldNames = false)
    public static class Cache {
        @Max(1000)
        private Integer ttl;
        @Max(3600)
        private Long maxEntries;
    }

    @Data
    @ToString(includeFieldNames = true)
    public static class Cors {
        private List<String> allowedOrigins;
        private String[] allowedMethods;
        private List<String> allowedHeaders;
        private Boolean allowCredentials;
        private Integer maxAge;
    }
}