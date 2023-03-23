package com.bikeshop.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.bikeshop.dao.CustomersDao;
import com.bikeshop.entity.Customer;
import com.bikeshop.entity.WorkOrder;

public class DefaultCustomerService implements CustomerService {
	

	List<Customer> fetchAllCustomers() {
		return CustomersDao.fetchAllCustomers();
	}
	
	
	public List <Customer> fetchCustomerbyFirstName (String firstName){
	if(firstName.isEmpty()) {
		String msg = String.format("We do not have this customer");
		throw new NoSuchElementException(msg);
	}
	return CustomersDao.fetchCustomerByFirstName(firstName);
}
	
	public Customer createCustomer (String firstName, String lastName, String phoneNumber) {

	if(Customer.isEmpty()) {
		String msg = String.format("you can't create a customer with no information");
		throw new NoSuchElementException(msg);
	
	return CustomersDao.createCustomer(firstName, lastName, phoneNumber);
}
}}
