package com.bikeshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.bikeshop.entity.Customer;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class DefaultCustomersDao implements CustomersDao{
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
			public Customer createCustomer (String firstName, String lastName, String phone) {
				
				SqlParams sqlparams = new SqlParams ();
				KeyHolder keyholder = new GeneratedKeyHolder();
				
				sqlparams.sql  = ""
						+"INSERT INTO customer "
						+ "(first_name, last_name, phone) "
						+ "VALUES (:first_name, :last_name, :phone)" ;
						
				//Map<String, Object> params = new HashMap<>();
//				params.put("first_name", firstName);
//				params.put("last_name", lastName);
//				params.put("phone", phone);
				sqlparams.source.addValue("first_name", firstName);
				sqlparams.source.addValue("last_name", lastName);
				sqlparams.source.addValue("phone", phone);
				
				jdbcTemplate.update(sqlparams.sql, sqlparams.source, keyholder);
				return Customer.builder()
						.customerID(keyholder.getKey().intValue())
						.firstName(firstName)
						.lastName(lastName)
						.phoneNumber(phone)
						.build();
						}
			class SqlParams {
			    String sql;
			    MapSqlParameterSource source = new MapSqlParameterSource();
			  }
			
			
			
			public List<Customer> fetchACustomer(String firstName, String lastName) {
				
				String sql = ""
						+ "FROM customer "
						+ "WHERE first_name = :first_name AND last_name = :last_name";
				
				Map<String, Object> params = new HashMap<>();
				params.put("first_name", firstName);
				params.put("last_name",  lastName);
				
				return jdbcTemplate.query(sql,  params,
						new RowMapper<>() {
					public Customer mapRow (ResultSet rs, int rowNum) throws SQLException {
						
						return Customer.builder()
								.customerID(rs.getInt("customer_ID"))
								.firstName(rs.getString("first_name"))
								.lastName(rs.getString("last_name"))
								.phoneNumber(rs.getString("phone_number"))
								.build();
					}});
			}
			
			
			public List<Customer> fetchCustomerByFirstName(String firstName) {
				String sql = ""
						+ "Select * "
						+ "FROM customers "
						+ "WHERE first_name = :first_name";
				
				Map<String, Object> params = new HashMap<>();
				params.put("customer_id",  firstName);
				return jdbcTemplate.query(sql,  params, new RowMapper<>() {
					public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
					return Customer.builder()
								.customerID(rs.getInt("customer_ID"))
								.firstName(rs.getString("first_name"))
								.lastName(rs.getString("last_name"))
								.phoneNumber(rs.getString("phone_number))"))
								.build();
					}});
			}
				
				
				public Customer updateACustomer (int customerID, String phoneNumber, String firstName, String lastName) {
					
					String sql = ""
							+"UPDATE customer "
							+"SET "
							+ "first_name = :first_name, "
							+ "last_name = :last_name, "
							+ "phone_number = :phone_number "
							+ "WHERE customer_id = :customerid;";
					
					Map<String, Object> params = new HashMap<>();
			
				    params.put("first_name", firstName);
				    params.put("last_name", lastName);
				    params.put("phone", phoneNumber);
				    params.put("customer_id", customerID);
					
					if (jdbcTemplate.update( sql,  params) == 0) {
						throw new NoSuchElementException("update failed");};
					 return Customer.builder()
							.customerID(customerID)
							.firstName(firstName)
							.lastName(lastName)
							.phoneNumber(phoneNumber)
							.build();
					}

				@Override
				public List<Customer> fetchAllCustomers() {
					// TODO Auto-generated method stub
					return null;
				};
				
			}
