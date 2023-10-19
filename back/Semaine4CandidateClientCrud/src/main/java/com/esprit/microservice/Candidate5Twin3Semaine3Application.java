package com.esprit.microservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class Candidate5Twin3Semaine3Application {

	public static void main(String[] args) {
		SpringApplication.run(Candidate5Twin3Semaine3Application.class, args);
	}
	
	//Afficher la liste des candidats
	//http://localhost:8181/candidats
	@Bean
	ApplicationRunner init(CandidatRepository repository) {
		return args -> {
			Stream.of("Mariem", "Sarra", "Mohamed").forEach(nom -> {
				repository.save(new Candidat(nom));
			});
			repository.findAll().forEach(System.out::println);
		};

	}
}
