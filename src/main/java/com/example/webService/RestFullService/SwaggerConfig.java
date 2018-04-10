package com.example.webService.RestFullService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT_INFO = new Contact(
			"Ravinder Reddy", "http://www.student.com",
			"ravinderpannala1992@gmail.com");
	
	@SuppressWarnings("rawtypes")
	public static final ApiInfo DEFAULT = new ApiInfo(
			"Student Information App", "Api Documentation", "1.0", "urn:tos",
			DEFAULT_CONTACT_INFO, "Apache 2.0",
			"http://www.apache.org/licenses/LICENSE-2.0",
			new ArrayList<VendorExtension>());
	
	private static final Set<String> PRODUCERS_AND_CONSUMERS = new HashSet<>(
			Arrays.asList("application/json", "application/xml"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT)
				.produces(PRODUCERS_AND_CONSUMERS)
				.consumes(PRODUCERS_AND_CONSUMERS);

	}

}
