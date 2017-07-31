package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository // For Dao implementation. Spring automatically resister DAO(thanks
			// to component scanning), Spring also provides translation for JDBC
			// exceptions
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query...sort by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute query and get result
		List<Customer> customers = theQuery.getResultList();

		// return list of customer
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer to database
		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int id) {

		System.out.println("Hello again");
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// retrieve from DB using primary key
		Customer customer = currentSession.get(Customer.class, id);

		// return list of customer
		System.out.println(customer.toString());
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete the customer from database
		Query query = currentSession.createQuery("delete from Customer where id=:id");
		query.setParameter("id", id);
		
		query.executeUpdate();

	}

}
