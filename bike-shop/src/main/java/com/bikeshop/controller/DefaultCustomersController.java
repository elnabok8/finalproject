package com.bikeshop.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bikeshop.entity.Customer;
import com.bikeshop.service.CustomerService;

@RestController
public class DefaultCustomersController {
	
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
}
