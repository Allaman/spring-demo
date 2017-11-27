package demo;

import java.util.List;
import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.properties.ConfigurationProperties;
import javax.validation.constraints.Max;

@Component
@Configuration
@ConfigurationProperties("app")
public class Properties {

    private Cache cache;
    private Cors cors;

    public Cache getCache() {
        return cache;
    }
    public Cors getCors() {
        return cors;
    }
    public void setCache(Cache cache) {
        this.cache = cache;
    }
    public void setCors(Cors cors) {
        this.cors = cors;
    }

    public static class Cache {

        @Max(1000)
        private Integer ttl;
        @Max(3600)
        private Long maxEntries;

        public Integer getTtl() {
            return ttl;
        }
        public Long getMaxEntries() {
            return maxEntries;
        }
        public void setTtl(Integer ttl) {
            this.ttl = ttl;
        }
        public void setMaxEntries(Long maxEntries) {
            this.maxEntries = maxEntries;
        }

        @Override
        public String toString() {
            return "Cache{" +
                    "ttl=" + ttl +
                    ", maxEntries=" + maxEntries +
                    '}';
        }
    }

    public static class Cors {

        private List<String> allowedOrigins;
        private String[] allowedMethods;
        private List<String> allowedHeaders;
        private Boolean allowCredentials;
        private Integer maxAge;

        public List<String> getAllowedOrigins() {
            return allowedOrigins;
        }
        public Boolean getAllowCredentials() {
            return allowCredentials;
        }
        public List<String> getAllowedHeaders() {
            return allowedHeaders;
        }
        public String[] getAllowedMethods() {
            return allowedMethods;
        }
        public Integer getMaxAge() {
            return maxAge;
        }
        public void setAllowCredentials(Boolean allowCredentials) {
            this.allowCredentials = allowCredentials;
        }
        public void setAllowedHeaders(List<String> allowedHeaders) {
            this.allowedHeaders = allowedHeaders;
        }
        public void setAllowedMethods(String[] allowedMethods) {
            this.allowedMethods = allowedMethods;
        }
        public void setAllowedOrigins(List<String> allowedOrigins) {
            this.allowedOrigins = allowedOrigins;
        }
        public void setMaxAge(Integer maxAge) {
            this.maxAge = maxAge;
        }

        @Override
        public String toString() {
            return "Cors{" +
                    "allowedOrigins=" + allowedOrigins +
                    ", allowedMethods=" + Arrays.toString(allowedMethods) +
                    ", allowedHeaders=" + allowedHeaders +
                    ", allowCredentials=" + allowCredentials +
                    ", maxAge=" + maxAge +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Properties{" +
                "cache=" + cache +
                ", cors=" + cors +
                '}';
    }

}