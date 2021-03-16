package com.example.springdata3;

import com.example.springdata3.service.AssociationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Springdata3Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Springdata3Application.class, args);
		AssociationService associationService = applicationContext.getBean(AssociationService.class);

		associationService.createAuthor();
		associationService.createManyToMany();
		associationService.createOneToOne();
	}

}
