package com.bikeshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikeshop.dao.ServicesDao;
import com.bikeshop.entity.Services;
@Service
public class DefaultServicesService implements ServicesService {
@Autowired
private ServicesDao servicesDao;
	
@Override
	public Services updateAService(int serviceID, int customerID, String description, float cost) {
			
			return servicesDao.updateAService(serviceID, customerID, description, cost);

	}
	@Override
	public Services createService(int serviceID, int customerID, String serviceDescription, float serviceCost) {
	
		return servicesDao.createService(serviceID, customerID, serviceDescription, serviceCost);
	}
@Override
	public void deleteService(int serviceID) {
		 servicesDao.deleteService(serviceID);
	}


@Override
	public List<Services> fetchService(int serviceID,  int customerID, String description, float cost) {
	
		return servicesDao.fetchService(serviceID, customerID, description, cost);
	}
}


