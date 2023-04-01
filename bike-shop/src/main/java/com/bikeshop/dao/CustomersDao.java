package com.bikeshop.dao;

import java.util.List;
import com.bikeshop.entity.Customer;


public interface CustomersDao {
	
	//Customer Dao takes from Default customer service class and sends to Default customer dao
	
	List <Customer> fetchAllCustomers();
	
	public List<Customer> fetchCustomerByFirstName(String firstName);
	
	Customer createCustomer (String firstName, String lastName, String phone);

	Customer updateACustomer(int customerID, String phone, String firstName, String lastName);
}
