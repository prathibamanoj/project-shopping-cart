package com.niit.shoppincartbackend;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class TestConfiguration {
	
	
	//test whether the user instance is created or not.
	
	
	public static void main (String[] args) {
		 
	//because we used annotations above the domain classes
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
   
    //will scan the package and check whether any classes are there inside this package
    //with annotation
    context.scan("com.niit");
    
    //will create the context and create new instances of the classes which are their
    //in.com.niit package with annotations.
    context.refresh();
    
    context.getBean("user");
    System.out.println("Successfully created instance.");
	
    
		
	}

}
