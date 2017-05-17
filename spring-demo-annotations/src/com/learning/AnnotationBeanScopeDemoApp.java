package com.learning;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		// load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		// check if they are same
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\nPointing to same object: "+result);
		System.out.println("\nMemory location of theCoach: "+theCoach);
		System.out.println("\nMemory location of alphaCoach: "+alphaCoach);
		
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getDailyWorkout());
		// close the context
		context.close();
	}

}
