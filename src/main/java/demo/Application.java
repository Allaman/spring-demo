package demo;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    // Simple Environment-Value
    // Can be overwritten in docker-compose
    @Value("${foo:default_value}")
    private String foo;

    @Autowired
    private YamlProperties yamlProperties;
    @Autowired
    private Properties properties;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public String home() {
        return "Hello " + foo + "<br>---<br>" + yamlProperties + "<br>---<br>" + properties;
    }

    @RequestMapping("/content")
    public Post greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Post(counter.incrementAndGet(), String.format(template, name));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
