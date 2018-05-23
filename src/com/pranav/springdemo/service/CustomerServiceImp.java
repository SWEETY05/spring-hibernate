package com.pranav.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pranav.springdemo.dao.CustomerDao;
import com.pranav.springdemo.entity.Customer;
//service anotation
@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	@Transactional
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return customerDao.getCustomer();
	}
	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		customerDao.saveCustome(theCustomer);
	}
	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(theId);
	}
	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomer(theId);
	}

}
