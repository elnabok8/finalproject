package com.bikeshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Services {
	
	private int serviceID;
	private int customerID;
	private String description;
	private float cost;


}
