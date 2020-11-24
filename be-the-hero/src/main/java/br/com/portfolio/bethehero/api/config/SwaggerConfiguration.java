package br.com.portfolio.bethehero.api.config;

import java.util.function.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableWebMvc
@Configuration
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		Predicate<RequestHandler> basePackage = RequestHandlerSelectors.basePackage("br.com.portfolio.bethehero");
		Predicate<String> apiUrls = PathSelectors.ant("/api/bethehero/**");
		
		return new Docket(DocumentationType.OAS_30)
				.select()
				.apis(basePackage)
				.paths(apiUrls)
				.build()
			.apiInfo(metaData());
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("be the hero").description("")
				.version("1.0")
				.contact(new Contact("Felipe Gadelha Diniz Da Silva",
						"https://www.linkedin.com/in/felipe-gadelha-diniz-da-silva-aaaa4a158/",
						"felipegadelha90@gmail.com"))
				.build();
	}

}
