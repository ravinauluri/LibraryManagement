package com.genpact.librarymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author 703237279 on Jul, 2020
 */
@ComponentScan(basePackages="com.genpact.librarymanagement")
@EnableJpaRepositories("com.genpact.librarymanagement")
@EntityScan(basePackages="com.genpact.librarymanagement")
@SpringBootApplication

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
