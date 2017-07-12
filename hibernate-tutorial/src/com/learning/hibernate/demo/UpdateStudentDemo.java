package com.learning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try{
			int studentId =1;
			session.beginTransaction();
			
			System.out.println("\n\nGetting student with id: "+studentId);
				
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student..");
			myStudent.setFirstName("Ankur");
			
			//commit transaction  //no need to call update as student is persistenc object
			session.getTransaction().commit();
			
			//NEW CODE
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update emails for all
			System.out.println("Updating emails");
			
			session.createQuery("update Student set email='foo@gmail.com'")
					.executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done...");
		}
		finally{
			factory.close();
		}
	}
}
