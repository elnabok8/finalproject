package com.bikeshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bikeshop.entity.Customer;
 
public interface CustomerService {
	
	//Customer Service receives information from Default Customer Controller passes it to Default Customer Service class
	
	// List<Customer> fetchAllCustomers();
	
	List <Customer> fetchCustomerbyFirstName (String firstName);
	
	Customer createCustomer (String firstName, String lastName, String phone);
	
	Customer updateACustomer (int customerID, String phone, String firstName,  String lastName);
	
}

