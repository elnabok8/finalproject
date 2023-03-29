package com.bikeshop.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bikeshop.dao.CustomersDao;
import com.bikeshop.entity.Customer;

public class DefaultCustomerService implements CustomerService {
	@Autowired
	private CustomersDao customersDao;

//	List<Customer> fetchAllCustomers() {
//		return customersDao.fetchAllCustomers();
//	}
	
	
	public List <Customer> fetchCustomerbyFirstName (String firstName){
	if(firstName.isEmpty()) {
		String msg = String.format("We do not have this customer");
		throw new NoSuchElementException(msg);
	}
	return customersDao.fetchCustomerByFirstName(firstName);
}
	
	public Customer createCustomer (String firstName, String lastName, String phoneNumber) {
	return customersDao.createCustomer(firstName, lastName, phoneNumber);
}
}