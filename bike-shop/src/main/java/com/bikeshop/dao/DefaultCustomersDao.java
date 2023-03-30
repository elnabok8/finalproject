package com.bikeshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.bikeshop.entity.Customer;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class DefaultCustomersDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
			public Customer createCustomer (String firstName, String lastName, String phoneNumber) {
				return null;
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
				
				class SqlParams {
					String sql;
					MapSqlParameterSource source = new MapSqlParameterSource();
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
					};
				
			}
