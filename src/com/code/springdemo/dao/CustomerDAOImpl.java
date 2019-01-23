package com.code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    // need to inject the session Factory 
	@Autowired 
	private SessionFactory sessionFactory;
	
	
	@Override

	public List<Customer> getCustomers() {
		//get the current Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
		//create a query 
		
		//execute query and get result list
		Query<Customer> theQuery = currentSession.createQuery("from Customer",Customer.class);
		
		//execute the query and get the result list
		List<Customer> customers = theQuery.getResultList();
 		//return the results
		return customers;
	}

}
