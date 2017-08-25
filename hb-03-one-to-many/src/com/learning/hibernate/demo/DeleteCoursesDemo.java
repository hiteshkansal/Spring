package com.learning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.hibernate.demo.entity.Course;
import com.learning.hibernate.demo.entity.Instructor;
import com.learning.hibernate.demo.entity.InstructorDetail;

public class DeleteCoursesDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try{
			//start transaction
			session.beginTransaction();
			
			//get a course
			int theId=12;
			Course temp = session.get(Course.class, theId);
			
			//delete the course
			session.delete(temp);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done...");
		}
		finally{
			session.close();
			factory.close();
		}
	}

}
