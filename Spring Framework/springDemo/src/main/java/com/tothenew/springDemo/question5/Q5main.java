/*
* 	Q.3 Use @Component and @Autowired annotations to in Loosely Coupled code for dependency management
*/
/*
    (5) Demonstrate how you will resolve ambiguity while autowiring bean
*/
package com.tothenew.springDemo.question5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Q5main {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(Q5main.class, args);
		Artist artist = applicationContext.getBean(Artist.class);

		artist.drawShape();
	}

}
