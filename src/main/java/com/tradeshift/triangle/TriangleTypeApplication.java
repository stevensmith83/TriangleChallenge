package com.tradeshift.triangle;

import static org.springframework.boot.SpringApplication.run;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TriangleTypeApplication {

    public static void main(final String[] args) {
        run(TriangleTypeApplication.class, args);
    }
}
