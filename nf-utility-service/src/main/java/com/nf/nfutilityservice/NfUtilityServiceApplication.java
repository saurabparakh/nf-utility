package com.nf.nfutilityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class}, scanBasePackages = {"com.nf"})
@EnableMongoRepositories(basePackages = {"com.nf"})
public class NfUtilityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NfUtilityServiceApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}




}
