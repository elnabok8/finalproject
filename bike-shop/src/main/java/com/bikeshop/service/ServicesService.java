package com.bikeshop.service;

import java.util.List;

import javax.validation.Valid;

import com.bikeshop.controller.ServicesController;
import com.bikeshop.entity.Services;

public interface ServicesService {
	
	//public Services updateServices(int bikeServiceID, int customerID, String description, float cost);
	
	public Services createService(int serviceID, int customerID, String serviceDescription, float serviceCost);

	public void deleteService(int serviceID);

	//public List<Services> fetchService(int serviceID);

	}

