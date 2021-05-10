package com.cityjokes.backend;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableMongoRepositories("com.cityjokes.backend.repositories")
@ComponentScan(basePackages = {"com.cityjokes"})
@EntityScan("com.cityjokes.domain")
@EnableAsync
public class BackendApplication {

    public static void main(String[] args) {

        final SpringApplication application = new SpringApplication(BackendApplication.class);
        application.setBannerMode(Banner.Mode.OFF);           
        application.run(args);
       
    }

}
