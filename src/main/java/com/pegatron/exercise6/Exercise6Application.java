package com.pegatron.exercise6;
/**
 * @SpringBootApplication is equivalent to using:
 *      @EnableAutoConfiguration: enable Spring Boot’s auto-configuration mechanism
 *      @ComponentScan: enable @Component scan on the package where the application is located (see the best practices)
 *      @Configuration: allow to register extra beans in the context or import additional configuration classes
 */

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class Exercise6Application {

    public static void main(String[] args) {
        SpringApplication.run(Exercise6Application.class, args);
    }

}
