package com.co.app;

import com.co.dto.TokenDTO;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@SpringBootApplication(scanBasePackages= "com.co")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages="com.co.persistence")
@EntityScan("com.co.entities")
public class Application {

	@Bean
	public Docket swagger(TypeResolver resolver) {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				// the following line is important!
				.additionalModels(resolver.resolve(Application.class));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		/**Controller controller = new Controller();
		Object response = controller.token();
		if(response instanceof TokenDTO) {
			controller.afiliacionARL();
		}**/

	}



}
