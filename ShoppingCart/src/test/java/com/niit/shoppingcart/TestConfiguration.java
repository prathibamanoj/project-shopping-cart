package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfiguration {
	
	//test whether the user instance is created or not.
	
	
	public static void main(String[] args) {
		
		//because we used annotations above the domain classes
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		//will scann the pcakge and check whther any classess are there inside this package
		//with annotation
		context.scan("com.niit");
		
		//will clear the context and create new instances of the classes which are their
		//in com.niit package with annoations.
		context.refresh();
		
		//try to get instance of user class
		
		//it will return the instance if it is available in bean factory.
		//else it will through an error :  NoSuchBeanDefinitionExist
		context.getBean("user");
		
		System.out.println("Successfully created instance.");
		
		
		
		
		
		
		
		
	}

}
