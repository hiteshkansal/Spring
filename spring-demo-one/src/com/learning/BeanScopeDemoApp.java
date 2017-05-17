package com.learning;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load the Spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		//check if both bean are same
		boolean result = (theCoach == alphaCoach);
		
		//lets check for bean scope
		System.out.println("\nResults: "+ result);
		System.out.println("\nMemory Location for theCoach: "+ theCoach);
		System.out.println("\nMemory Location for alphaCoach: "+ alphaCoach);
		
		//close the context
		context.close();
	}

}
