package com.bikeshop.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bikeshop.entity.Customer;
import com.bikeshop.service.CustomerService;

@RestController
public class DefaultCustomersController implements CustomersController {
	
	//DefaultCustomerController takes information from the CustomerController and then passes it to CustomerServiceInterface
	
	@Autowired
	private CustomerService customerService;
	
//	public List<Customer> fetchAllCustomers() {
//		return customerService.fetchAllCustomers();
//	}
	public List <Customer> fetchCustomerByFirstName (String firstName) {
		return customerService.fetchCustomerbyFirstName(firstName);
	}
	
	public Customer createACustomer (String firstName, String lastName, String phone) {
		return customerService.createCustomer(firstName, lastName, phone);
	}

	@Override
	public List<Customer> fetchAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> fetchACustomer(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Customer updateACustomer(int customerID, String phone, String firstName, String lastName) {
		return customerService.updateACustomer(customerID, phone, firstName, lastName);
	}

	@Override
	public Customer createCustomer(String firstName, String lastName, String phone) {
		return customerService.createCustomer(firstName, lastName, phone);
	}

}
