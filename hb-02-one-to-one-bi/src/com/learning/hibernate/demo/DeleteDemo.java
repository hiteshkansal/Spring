package com.learning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.learning.hibernate.demo.entity.Instructor;
import com.learning.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

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
			
			//get inst by primary key
			int theId = 2;
			
			Instructor inst = session.get(Instructor.class, theId);
			
			System.out.println("Found inst: "+ inst);
			
			//delete the instructor
			//this will also delete detail object because of cascading
			if(inst!=null){
				session.delete(inst);
			}
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done...");
		}
		finally{
			factory.close();
		}
	}

}
