package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = false)
@Component
@ConfigurationProperties("server")
public class YamlProperties {
    private String email;
    private List<Cluster> cluster = new ArrayList<>();

    @Data
    @ToString(includeFieldNames = false)
    public static class Cluster {
        private String ip;
        private String path;
    }
}