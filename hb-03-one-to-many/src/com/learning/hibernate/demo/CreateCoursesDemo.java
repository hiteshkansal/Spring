package com.learning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.hibernate.demo.entity.Course;
import com.learning.hibernate.demo.entity.Instructor;
import com.learning.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			//get instructor from db
			int theId=1;
			Instructor temp = session.get(Instructor.class, theId);
			
			//create some courses
			Course course1 = new Course("Java");
			Course course2 = new Course("Guitar");
			
			//add course to instructor
			temp.add(course1);
			temp.add(course2);
			
			//save the course
			session.save(course1);
			session.save(course2);
			
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
