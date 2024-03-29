package com.clientes;

import java.io.FileReader;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class IamFullStackClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(IamFullStackClientesApplication.class, args);
	}
	
	@Bean
	public Docket api() throws Exception {
		MavenXpp3Reader reader = new MavenXpp3Reader();
		Model model = reader.read(new FileReader("pom.xml"));
		ApiInfoBuilder builder = new ApiInfoBuilder()
				.title("Client Service Api Documentation")
				.description("Documentation automatically generated")
				.version(model.getVersion())
				.contact(new Contact("Eduardo Castillo", "www.certificatic.org", "ecm3198@gmail.com"));
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.clientes.api"))
				.paths(PathSelectors.any()).build()
				.apiInfo(builder.build());
	}
	
	@Bean
	UiConfiguration uiConfig() {
	    return new UiConfiguration("validatorUrl", "list", "alpha", "schema",
	            UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, 60000L);
	}

}
