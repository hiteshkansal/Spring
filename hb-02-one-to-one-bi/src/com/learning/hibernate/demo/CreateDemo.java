package com.learning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.learning.hibernate.demo.entity.Instructor;
import com.learning.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

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
			//create the object
			Instructor inst = new Instructor("Hitesh", "Kansal", "hitesh@gmail.com");
			InstructorDetail instDet = new InstructorDetail("http://www.youtube.com/hitesh", "travelling");
			
			//associate the object
			inst.setInstructorDetail(instDet);
			
			//start transaction
			session.beginTransaction();
			
			//save the instructor
			//this will also save detail object because of cascading
			session.save(inst);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done...");
		}
		finally{
			factory.close();
		}
	}

}
