package com.bikeshop.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import com.bikeshop.controller.ServicesController;
import com.bikeshop.dao.ServicesDao;
import com.bikeshop.entity.Services;
import com.bikeshop.entity.WorkOrder;

public class DefaultServicesService implements ServicesService {

@Override
public Services updateServices(int bikeServiceID, @Valid ServicesController updatedServices) {
	// TODO Auto-generated method stub
	return null;
}

	public Services updateServices(int serviceID, int customerID, String description, float cost) {
		 Services service;
		 if(service.isEmpty()) {
			String msg = String.format("We do not have work orders for this customer");
			throw new NoSuchElementException(msg);
		
		return ServicesDao.updateServices(serviceID, customerID, description, cost);
	}
	}
	
	public Services createService(int serviceID, String serviceDescription, float serviceCost) {
		
		 Services service;
		 if(service.isEmpty()) {
			String msg = String.format("We do not have work orders for this customer");
			throw new NoSuchElementException(msg);
		
		return ServicesDao.createService(serviceID, serviceDescription, serviceCost);
	}
	}

	public Services deleteService(int serviceID) {
		 Services service;
		 if(service.isEmpty()) {
			String msg = String.format("We do not have work orders for this customer");
			throw new NoSuchElementException(msg);
		
		return ServicesDao.deleteService(serviceID);
	}
	}



public List<WorkOrder> fetchWorkOrderByCustomer(int customerID) {
	List<WorkOrder> workOrder = workOrderDao.fetchWorkOrderByCustomer(customerID);
	
	if(workOrder.isEmpty()) {
		String msg = String.format("We do not have work orders for this customer");
		throw new NoSuchElementException(msg);
	}
	return workOrder;
}

@Override
public List<WorkOrder> fetchService(int serviceID) {
	 Services service;
	 if(service.isEmpty()) {
		String msg = String.format("We do not have work orders for this customer");
		throw new NoSuchElementException(msg);
	
	return ServicesDao.fetchService(serviceID);
}
}

}