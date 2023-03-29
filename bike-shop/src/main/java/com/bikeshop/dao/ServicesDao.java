package com.bikeshop.dao;

import java.util.List;

import com.bikeshop.entity.Services;

public interface ServicesDao {
	
	List <Services> fetchServicesByCustomer(int customerID);

	
	Services createService(int serviceID, int customerID, String serviceDescription, Float cost);
	
	Services updateServices (int serviceID, int customerID, String description, float cost);
 
	void deleteService(int serviceID);
	
			
}
