package com.bikeshop.dao;

import java.util.List;

import com.bikeshop.entity.Services;

public interface ServicesDao {
	
	List <Services> fetchServicesByCustomer(int customerID);

	
	Services createService(int serviceID, String serviceDescription, float cost);
	
	Services updateAService (int serviceID, String description, float cost);
 
	void deleteService(int serviceID);

	List<Services> fetchService(int serviceID);

	
			
}
