package com.learning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try{
			//int studentId =6;
			session.beginTransaction();
			
			//System.out.println("\n\nGetting student with id: "+studentId);
				
			//Student myStudent = session.get(Student.class, studentId);
			
			//System.out.println("Deleting student.."+myStudent);
			//session.delete(myStudent);
			
			System.out.println("Deleting Student with id=5");
			session.createQuery("delete from Student where id=5").executeUpdate();
			
			//commit transaction  //no need to call update as student is persistenc object
			session.getTransaction().commit();
			
			System.out.println("Done...");
		}
		finally{
			factory.close();
		}
	}
}
