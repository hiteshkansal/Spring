package com.learning.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try{
			//start transaction
			session.beginTransaction();
			
			//query Students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display students
			displayMethod(theStudents);
			
			//query Students: lastName='Kansal'
			theStudents = session.createQuery("from Student where lastName='Kansal'").getResultList();
			
			//display students
			System.out.println("\n\nStudent with last name \"Kansal\"");
			displayMethod(theStudents);
				
			//query Students: lastName='Kansal' OR firstName='Sourabh'
			theStudents = session.createQuery("from Student s where s.lastName='Kansal' OR s.firstName='Sourabh'").getResultList();
			
			//display students
			System.out.println("\n\nStudent with last name 'Kansal' OR firstName='Sourabh'");
			displayMethod(theStudents);
			
			//query Students: emails LIKE '%gmail.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			//display students
			System.out.println("\n\nStudent with emails LIKE '%gmail.com'");
			displayMethod(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done...");
		}
		finally{
			factory.close();
		}
	}

	private static void displayMethod(List<Student> theStudents) {
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
