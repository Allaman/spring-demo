package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
    @Value("${foo:default_value}")
    private String awesome;

    @ConfigurationProperties(prefix="bar")
    public class barProperties {

        private String firstName;

        public String getFirstName() {
            return this.firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

    }

    @RequestMapping("/")
    public String home() {
        barProperties b = new barProperties();
        return "Hello " + awesome + " " + b.getFirstName();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
