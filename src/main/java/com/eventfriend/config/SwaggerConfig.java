package com.eventfriend.config;

import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${api.version}")
	private String version;
	
	@Value("${api.environment}")
	private String environment;
    
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.enable(environment.contentEquals("dev"))
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(input -> 
				!PathSelectors.regex("/oauth.*").apply(input) &&
				!PathSelectors.regex("/error.*").apply(input) &&
				 PathSelectors.any().apply(input))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("EventFriend API")
				.description("Download app at")
				.version(version)
				.build();
	}
	
}