package com.bikeshop.service;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bikeshop.dao.WorkOrderDao;
import com.bikeshop.entity.WorkOrder;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j


public class DefaultWorkOrderService  implements WorkOrderService{
	
	@Autowired
	  private WorkOrderDao workOrderDao;


	 
	  public void deleteWorkOrder(int bikeServiceID) {
	    workOrderDao.deleteWorkOrder(bikeServiceID);
	  }

	public List<WorkOrder> fetchWorkOrderByCustomer(int customerID) {
		List<WorkOrder> workOrder = workOrderDao.fetchWorkOrderByCustomer(customerID);
		
		if(workOrder.isEmpty()) {
			String msg = String.format("We do not have work orders for this customer");
			throw new NoSuchElementException(msg);
		}
		return workOrder;
	}

	
//	   public WorkOrder updateWorkOrder(int bikeServiceID, int customerID, int
//	  timeAllotment, int costOfService) { // WorkOrder workOrder =
//	  workOrderDao.updateWorkOrder(bikeServiceID, costOfService,
//	  costOfService,costOfService, costOfService, workOrder);
//	  why it recognizes "Is empty" on line 34 but not this line //
//	 if(workOrder.isEmpty()) {String msg =
//	  String.format("We have no WorkOrders by this ID"); // throw new
//	  NoSuchElementException(msg); // }
//	  
//	  return workOrderDao.updateWorkOrder(bikeServiceID, customerID,
//	  timeAllotment, costOfService) // .orElseThrow(() -> new
//	  NoSuchElementException("We have no WorkOrders by this ID")); 
//	  with the noSuchElement exception;
//	 /
	public WorkOrder createAWorkOrder(int bikeServiceID, int customerID, int timeAllotment, int costOfService) {
WorkOrder workOrder = workOrderDao.createAWorkOrder(bikeServiceID, costOfService, costOfService, costOfService);
		
		return workOrderDao.createAWorkOrder(bikeServiceID, costOfService, costOfService, costOfService);
	}

	@Override
	public WorkOrder createAWorkOrder(int bikeServiceID, int customerID, int timeAllotment, float costOfService) {
	WorkOrder workOrder = workOrderDao.createAWorkOrder(bikeServiceID, customerID, timeAllotment, timeAllotment);
		return workOrder;
	}


	}



