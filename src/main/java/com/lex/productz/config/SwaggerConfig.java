package com.lex.productz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;

import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket produtoApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.lex.productz"))
				.paths(regex("/api.*"))
				.build()
				.apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
		
		ApiInfo apiInfo = new ApiInfo(
				"PRODUTOS API REST",
				"Api Rest de Cadastro de produtos",
				"1.0",
				"Terms of Service",
				null,
				"Apache License Version 2.0",
				"https://www.apache.org/license.html",
				new ArrayList<VendorExtension>()
				);
		
		return apiInfo;
	}
}
