package com.learning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try{
			//create 3 student objects
			System.out.println("Creating 3 new student objects...");
			Student student1 = new Student("Ankur","Doshi","Ankur@gmail.com");
			Student student2 = new Student("Sourabh","Mangal","Sourabh@gmail.com");
			Student student3 = new Student("Hitesh","Kansal","hitesh@gmail.com");
			//start transaction
			session.beginTransaction();
			
			//save student object
			System.out.println("Saving the student...");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done...");
		}
		finally{
			factory.close();
		}
	
	}

}
