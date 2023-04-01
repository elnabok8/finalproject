package com.bikeshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Customer {
	private int customerID;
	private String phone;
	private String firstName;
	private String lastName;

}
