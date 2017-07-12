package com.learning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try{
			//create a student object
			System.out.println("Creating a new student object");
			Student student = new Student("Test","Student","test@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			//save student object
			System.out.println("Saving the student...");
			System.out.println(student);
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
			
			//Print student id  data
			System.out.println("Saved Student. Genreated ID: "+student.getId());
			
			//Now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student
			System.out.println("\nGetting student with id: "+student.getId());
			Student myStudent = session.get(Student.class, student.getId());
			System.out.println("Get Complete: "+ myStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done...");
		}
		finally{
			factory.close();
		}
	}

}
