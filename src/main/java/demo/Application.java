package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
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


    @RequestMapping("/")
    public String home() {
        return "Hello " + foo + "<br>---<br>" + yamlProperties + "<br>---<br>" + properties;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
