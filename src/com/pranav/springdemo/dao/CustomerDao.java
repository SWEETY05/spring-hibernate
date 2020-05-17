package com.pranav.springdemo.dao;

import java.util.List;

import com.pranav.springdemo.entity.Customer;

public interface CustomerDao {

		public List<Customer> getCustomer();

		public void saveCustome(Customer theCustomer);

		public Customer getCustomer(int theId);

		public void deleteCustomer(int theId);
}
//dao 1