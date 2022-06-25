package com.works;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan( { "com.works.entities" } )
public class Days4Application {

    public static void main(String[] args) {
        SpringApplication.run(Days4Application.class, args);
    }

}
