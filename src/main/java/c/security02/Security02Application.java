package c.security02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class Security02Application {

    public static void main(String[] args) {
        SpringApplication.run(Security02Application.class, args);

    }

}
