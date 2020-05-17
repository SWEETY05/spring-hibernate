package com.pranav.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pranav.springdemo.entity.Customer;
@Repository
public class CustomerDaoImp implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomer() {
		
	Session session=sessionFactory.getCurrentSession();
	
	Query<Customer> theQeury=session.createQuery("from Customer order by lastName",Customer.class);
	
	List<Customer> customer=theQeury.getResultList();
	
		return customer;
	}

	@Override
	public void saveCustome(Customer theCustomer) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		Session session=sessionFactory.getCurrentSession();
		
		Customer theCustomer=session.get(Customer.class,theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		
		Query theQuery=session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId",theId);
		
		theQuery.executeUpdate();
	}
//
}
