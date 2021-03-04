/*
* 	Q4. Get a Spring Bean from application context and display its properties.
* 	(setter injection using resourses/beans.xml)
*/

package com.tothenew.springDemo.question4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Q4main {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Book book = (Book) applicationContext.getBean("bookobj");
		System.out.println(book);

	}
}

