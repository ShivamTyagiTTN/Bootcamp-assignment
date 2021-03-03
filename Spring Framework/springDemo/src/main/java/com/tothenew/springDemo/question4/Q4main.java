/*
* 	Q.3 Use @Component and @Autowired annotations to in Loosely Coupled code for dependency management
*/

package com.tothenew.springDemo.question4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Q4main {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(Q4main.class, args);
		Artist artist = applicationContext.getBean(Artist.class);

		System.out.println(artist);
	}

}
