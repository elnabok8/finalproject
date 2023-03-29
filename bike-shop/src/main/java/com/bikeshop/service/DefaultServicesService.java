package com.bikeshop.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bikeshop.dao.ServicesDao;
import com.bikeshop.entity.Services;

public class DefaultServicesService implements ServicesService {
@Autowired
private ServicesDao servicesDao;
	
//@Override
//	public Services updateServices(int serviceID, int customerID, String description, float cost) {
//		 Services service;
//		 if(service.isEmpty()) {
//			String msg = String.format("We do not have work orders for this customer");
//			throw new NoSuchElementException(msg);
//		
//		try {
//			return ServicesDao.updateServices(serviceID, customerID, description, cost);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	}
	@Override
	public Services createService(int serviceID, int customerID, String serviceDescription, float serviceCost) {
	
		return servicesDao.createService(serviceID, customerID, serviceDescription, serviceCost);
	}
@Override
	public void deleteService(int serviceID) {
		 servicesDao.deleteService(serviceID);
	}


	//@Override
//	public List<Services> fetchService(int serviceID) {
//		if(service.isEmpty()) {
//			String msg = , null)
//		return servicesDao.fetchService(serviceID);
//	}
}


