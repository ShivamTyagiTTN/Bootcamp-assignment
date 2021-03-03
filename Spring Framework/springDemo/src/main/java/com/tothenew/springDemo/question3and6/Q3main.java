/*
* 	Q.3 Use @Component and @Autowired annotations to in Loosely Coupled code for dependency management
* 	&
* 	Q.6 Perform Constructor Injection in a Spring Bean. -> (Artist.java)
*/

package com.tothenew.springDemo.question3and6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Q3main {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(Q3main.class, args);
		Artist artist = applicationContext.getBean(Artist.class);

		artist.drawShape();
	}

}
