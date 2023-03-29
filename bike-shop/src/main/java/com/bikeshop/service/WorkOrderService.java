package com.bikeshop.service;

import java.util.List;

import com.bikeshop.entity.WorkOrder;

public interface WorkOrderService {

	public List<WorkOrder> fetchWorkOrderByCustomer(int customerID);

	public void deleteWorkOrder(int bikeServiceID);

	public WorkOrder updateWorkOrder(int bikeServiceID, int customerID, int timeAllotment, int costOfService);
		
	public WorkOrder createAWorkOrder(int bikeServiceID, int customerID, int timeAllotment, float costOfService);
		  
}