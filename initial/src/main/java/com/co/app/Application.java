package com.co.app;

import com.co.dto.TokenDTO;
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

@Configuration
@SpringBootApplication(scanBasePackages= "com.co")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages="com.co.persistence")
@EntityScan("com.co.entities")
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Controller controller = new Controller();
		Object response = controller.token();
		//if(response instanceof TokenDTO) {
			controller.afiliacionARL();
		//}

	}



}
