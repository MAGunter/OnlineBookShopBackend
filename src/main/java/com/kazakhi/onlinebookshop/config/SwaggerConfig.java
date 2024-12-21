package com.kazakhi.onlinebookshop.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.models.GroupedOpenApi;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public io.swagger.v3.oas.models.OpenAPI customOpenAPI() {
        return new io.swagger.v3.oas.models.OpenAPI()
                .info(new Info()
                        .title("Online BookShop API")
                        .version("3.1")
                        .description("API documentation for Online BookShop")
                        .contact(new Contact()
                                .name("ArslanSupport Team")
                                .email("thebestproject@gmail.com")));
    }
}
