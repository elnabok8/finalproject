package com.bikeshop.service;

import java.util.List;

import com.bikeshop.entity.WorkOrder;

public interface WorkOrderService {

	public List<WorkOrder> fetchWorkOrderByCustomer(int customerID);

	public void deleteWorkOrder(int workOrderID);

	public WorkOrder updateWorkOrder(int workOrderID, int customerID, int timeAllotment, float costOfService);
		
	public WorkOrder createAWorkOrder(int customerID, int serviceID);
		  
}