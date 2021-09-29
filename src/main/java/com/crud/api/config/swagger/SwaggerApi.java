package com.crud.api.config.swagger;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerApi {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30).select()
				.apis(RequestHandlerSelectors.basePackage("com.crud.api.controller")).build();
	}

}
