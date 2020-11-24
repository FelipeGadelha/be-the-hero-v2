package br.com.portfolio.bethehero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
public class BeTheHeroApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeTheHeroApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
//				.allowedOrigins("http://domain2.com")
	            .allowedMethods("PUT", "DELETE", "POST", "GET")
	            .allowedHeaders("auth", "content-type")
	            ;
//	            .exposedHeaders("header1", "header2")        ------- allowed-headers="Content-Type,  Access-Control-Allow-Origin, Access-Control-Allow-Headers, Authorization, X-Requested-With, requestId, Correlation-Id
//	            .allowCredentials(false).maxAge(3600);
			}
		};
	}

}
