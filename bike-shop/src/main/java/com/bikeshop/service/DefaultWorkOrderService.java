package com.bikeshop.service;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikeshop.dao.WorkOrderDao;
import com.bikeshop.entity.WorkOrder;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j


public class DefaultWorkOrderService  implements WorkOrderService{
	WorkOrder workOrder;
	@Autowired
	  private WorkOrderDao workOrderDao;


	 
	  public void deleteWorkOrder(int workOrderID) {
	    workOrderDao.deleteWorkOrder(workOrderID);
	  }
@Override
	public List<WorkOrder> fetchWorkOrderByCustomer(int customerID) {
		List<WorkOrder> workOrder = workOrderDao.fetchWorkOrderByCustomer(customerID);
		
		if(workOrder.isEmpty()) {
			String msg = String.format("We do not have work orders for this customer");
			throw new NoSuchElementException(msg);
		}
		return workOrder;
	}

@Override
	public WorkOrder createAWorkOrder(int customerID, int serviceID) {
	return workOrderDao.createAWorkOrder(customerID, serviceID);
	}

	@Override
	public WorkOrder updateWorkOrder(int workOrderID, int customerID, int timeAllotment, float costOfService) {
	return workOrderDao.updateWorkOrder(workOrderID, customerID, timeAllotment, costOfService);
	}


	}



