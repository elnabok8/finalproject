package com.bikeshop.entity;


	
	import lombok.AllArgsConstructor;
	import lombok.Builder;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	
	public class WorkOrder {
		
	//these are labels as to what different variables are in the Bike Services Table
		
		private int workOrderID;
		private int customerID;
		private int timeAllotment;
		private float costOfService;
		private int serviceID;
		
		}
		
