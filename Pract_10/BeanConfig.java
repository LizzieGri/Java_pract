package Pract_10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public Programmer simpleCode() {
        return new Junior();
    }

    @Bean
    public Programmer mediumCode() {
        return new Middle();
    }

    @Bean
    public Programmer hardCode() {
        return new Senior();
    }
}
