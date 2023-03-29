package com.bikeshop.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikeshop.dao.CustomersDao;
import com.bikeshop.entity.Customer;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service

public class DefaultCustomerService implements CustomerService {
	@Autowired
	private CustomersDao customersDao;

	
	
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

	@Override
	public Customer updateACustomer(int customerID, String phoneNumber, String firstName, String lastName) {
		return customersDao.updateACustomer(customerID, phoneNumber, firstName, lastName);
	}
}