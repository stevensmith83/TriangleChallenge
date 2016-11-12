package com.tradeshift.triangle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig
{
    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.tradeshift.triangle.controller"))
            .paths(PathSelectors.ant("/triangle/type"))
            .build()
            .apiInfo(apiInfo())
            .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Triangle challenge API")
            .description(
                "This simple API take the lengths of the triangle's three sides as input, "
                    + "and return whether the triangle is equilateral, isosceles or scalene (or not a triangle). "
                    + "It handles integer values, in case of type mismatch, it returns bad request (400).")
            .build();
    }
}