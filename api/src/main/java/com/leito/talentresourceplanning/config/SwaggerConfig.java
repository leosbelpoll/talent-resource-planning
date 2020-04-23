package com.leito.talentresourceplanning.config;

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
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.leito.talentresourceplanning"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Talent Resource Planning")
                .description("Talent Resource Planning API description")
                .build();
    }
}
