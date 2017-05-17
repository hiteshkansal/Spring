/**
 * 
 */
package com.learning;

/**
 * @author Hitesh
 *
 */
public class MyApp {

	public static void main(String[] args) {

		//create the object
		Coach theCoach = new CricketCoach();
		
		// use the object
		System.out.println(theCoach.getDailyWorkout());
	}

}