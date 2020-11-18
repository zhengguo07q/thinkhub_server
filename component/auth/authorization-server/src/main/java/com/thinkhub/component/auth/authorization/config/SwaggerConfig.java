package com.thinkhub.component.auth.authorization.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Value("${spring.application.name}")
    String appName;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .pathMapping(appName)
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.thinkhub.component.auth.authorization"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("授权管理api")
                .description("授权管理")
                .termsOfServiceUrl("https://thinkhub.com")
                .version("1.0")
                .build();
    }


}
