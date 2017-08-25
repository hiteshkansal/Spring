package com.learning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.learning.hibernate.demo.entity.Instructor;
import com.learning.hibernate.demo.entity.InstructorDetail;

public class GetInsructorDetailDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try{
			//start transaction
			session.beginTransaction();
			
			//get the instructor details object
			int theId = 1;
			InstructorDetail temp = session.get(InstructorDetail.class, theId);
			
			//print the details
			System.out.println("temp: "+temp);
			
			//print the associate instructor
			System.out.println("Instructor: "+temp.getInstructor());
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done...");
		}
		catch(Exception e){
			session.close();
		}
		finally{
			factory.close();
		}
	}

}
