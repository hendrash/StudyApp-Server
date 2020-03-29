package com.StudyGuide.StudyGuide.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
    return new Docket(DocumentationType.SWAGGER_2).ignoredParameterTypes(Principal.class).select()
            .apis(RequestHandlerSelectors.any()).paths(PathSelectors.regex("/api.*")).build()
            .apiInfo(metaData()).globalOperationParameters(getOperationParameters());
}
private List<Parameter> getOperationParameters(){
    List<Parameter> headers= new ArrayList<Parameter>();
    headers.add(new ParameterBuilder().name("").description("Authorization Header 'Bearer xxx'")
            .modelRef(new ModelRef("string")).parameterType("header").required(true).defaultValue("").build());
        return headers;
}
private ApiInfo metaData(){
        return new ApiInfoBuilder().title("Exam Preview Server").description("\"Apis for maintaining Study Guide\"")
                .version("1.0.0").license("Apache License Version 2.0").
                        licenseUrl("https://www.apache.org/license/LICENSE-2.0").build();
}
}
