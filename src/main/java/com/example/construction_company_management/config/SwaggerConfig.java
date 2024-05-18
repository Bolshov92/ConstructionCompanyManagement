package com.example.construction_company_management.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@OpenAPIDefinition(
        info = @Info(
                title = "Construction company management",
                description = "This Swagger API prototype outlines core functionalities for efficient data management within the company's backend system. It encompasses:<br />" +
                        "- Financial tracking," +
                        "- Employee profiling," +
                        "- Resource management," +
                        "- Notification services.",
                version = "1.0",
                contact = @Contact(
                        name = "Viacheslav Bolshov",
                        url = "https://github.com/Bolshov92"
                )
        )
)

@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.construction_company_management"))
                .paths(PathSelectors.any())
                .build();
    }
}
