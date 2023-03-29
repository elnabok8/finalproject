package com.bikeshop.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bikeshop.entity.Services;
import com.bikeshop.entity.WorkOrder;
import com.bikeshop.service.ServicesService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController



public class DefaultServicesController implements ServicesController {
	//DefaultServicesController takes from the ServicesController interface and sends to
	//service layer which will then send to Dao to be connected to database
	
	@Autowired
	private ServicesService servicesService;


//
//public Services updateServices(int serviceID, @Valid ServicesController updatedServices) {
//	return servicesService.updateServices(serviceID, updatedServices);
//}


public void  deleteService(int serviceID) {
	servicesService.deleteService(serviceID);
}

//@Override
//public List<Services> fetchService(int serviceID) {
//	return servicesService.fetchService(serviceID);
//}

@Override
public Services createService(int serviceID, int customerID, String serviceDescription, float serviceCost) {
	return servicesService.createService(serviceID, customerID, serviceDescription, serviceCost);
}


}
