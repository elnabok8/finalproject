package com.bikeshop.dao;

import java.util.List;

import javax.validation.Valid;

import com.bikeshop.entity.WorkOrder;

public interface WorkOrderDao {

List<WorkOrder> fetchWorkOrderByCustomer(int CustomerID);

void deleteWorkOrder(int bikeServiceID);

WorkOrder createAWorkOrder(int bikeServiceID, int customerID, int timeAllotment, int costOfService);

WorkOrder updateWorkOrder(int workOrderID, int customerID, int timeAllotment, int costOfService);



}