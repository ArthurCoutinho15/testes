package br.newtonpaiva.testeSecurity.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(scanBasePackages = {"br.newtonpaiva"})
@EnableMongoRepositories("br.newtonpaiva.testeSecurity.Repository")
public class TesteSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteSecurityApplication.class, args);
	}

}
