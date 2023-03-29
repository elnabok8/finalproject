package com.bikeshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bikeshop.entity.WorkOrder;
import com.bikeshop.service.WorkOrderService;
@RestController

public class DefaultWorkOrderController implements WorkOrderController {
	@Autowired
	private WorkOrderService workOrderService;
	

@Override
	public void deleteWorkOrder (int serviceID) {
		workOrderService.deleteWorkOrder(serviceID);
	}
//@Override
//	public WorkOrder updateWorkOrder(int bikeServiceID, int customerID, int timeAllotment, float costOfService){
//		return workOrderService.createAWorkOrder(bikeServiceID, customerID, timeAllotment, costOfService);
//	}
		@Override
	public WorkOrder createAWorkOrder(int bikeServiceID, int customerID, int timeAllotment, float costOfService) {
		return workOrderService.createAWorkOrder(bikeServiceID, customerID, timeAllotment, costOfService);
	}

@Override
	public List<WorkOrder> fetchWorkOrderByCustomerID(int customerID) {
		  return workOrderService.fetchWorkOrderByCustomer(customerID);
}

@Override
public @Valid WorkOrder newWorkOrder() {
	// TODO Auto-generated method stub
	return null;

}
}