package com.bikeshop.dao;


import java.math.BigDecimal;
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

import com.bikeshop.entity.Services;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class DefaultServicesDao implements ServicesDao {
	
	@Autowired
	
	//connects to the database and returns to the Services Service
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<Services> fetchAllServices() {
		
		String sql = ""
				+ "SELECT * "
				+ "FROM services ";
		
		Map<String, Object> params = new HashMap<>();
		return jdbcTemplate.query(sql,  params, new RowMapper<Services>() {
			public Services mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return Services.builder()
						.serviceID(rs.getInt("service_id"))
						.customerID(rs.getInt("customer_id"))
						.serviceDescription(rs.getString("service_description"))
						.serviceCost(rs.getFloat("service_cost"))
						.build();
			}
		});
	}
	
	public Services createService (int serviceID, String serviceDescription, float serviceCost) {
		
		SqlParams sqlparams = new SqlParams();
		KeyHolder keyHolder = new GeneratedKeyHolder();
		sqlparams.sql = ""
				+"INSERT into services "
				+ "(service_description, service_cost) "
				+ "VALUES (:service_description, :service_cost)" ;
				
		
		sqlparams.source.addValue("service_description", serviceDescription);
		sqlparams.source.addValue("service_cost", serviceCost);
		
		jdbcTemplate.update(sqlparams.sql,  sqlparams.source, keyHolder);
		return Services.builder()
				.serviceID(serviceID)
				.serviceDescription(serviceDescription)
				.serviceCost(serviceCost)
				.build();
				}
	
	class SqlParams {
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}
	

	@Override
	public List<Services> fetchServicesByCustomer(int customerID) {
		String sql = ""
				+ "SELECT * "
				+ "FROM services "
				+ "WHERE customer_id = customer_id";
		Map<String, Object> params = new HashMap<>();
		return jdbcTemplate.query(sql,  params, new RowMapper<Services>() {
			public Services mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return Services.builder()
						.serviceID(rs.getInt("service_id"))
						.customerID(rs.getInt("customer_id"))
						.serviceDescription(rs.getString("serviceDescription"))
						.serviceCost(rs.getFloat("service_cost"))
						.build();
			}
		});
		
	}

	@Override
	public Services updateAService(int serviceID, String serviceDescription, float serviceCost) {
		String sql = ""
				+ "UPDATE services "
				+ "SET "
				+ "service_description = :service_description, service_cost = :service_cost "
				+ "WHERE (service_id = :service_id) " ;
	
		
		Map <String, Object> params = new HashMap<>();
		params.put("service_description", serviceDescription);
		params.put("service_cost", serviceCost);
		params.put("service_id", serviceID);
		
	 jdbcTemplate.update(sql,  params);
		
		return Services.builder()
				.serviceID(serviceID)
				.serviceDescription(serviceDescription)
				.serviceCost(serviceCost)
				.build();
	}

	@Override
	public void deleteService(int serviceID) {
String sql = ""
+ "DELETE FROM services "
		+ "WHERE service_id = :service_id";

Map <String, Object> params = new HashMap<>();
params.put("service_id", serviceID);

jdbcTemplate.update(sql,  params);

}

	@Override
	public List<Services> fetchService(int serviceID) {
		String sql = ""
				+ "SELECT * "
				+ "FROM services "
				+ "WHERE service_id = :service_id";
		
		Map <String, Object> params = new HashMap<>();
		params.put("service_id", serviceID);
		
		return jdbcTemplate.query(sql, params, new RowMapper <>() {

			@Override
			public Services mapRow(ResultSet rs, int rowNum)
			throws SQLException {
				//@formatter:off
			
		
		return Services.builder()
				.serviceID(rs.getInt("service_id"))
				.customerID(rs.getInt("customer_id"))
				.serviceDescription(rs.getString("service_description"))
				.serviceCost(rs.getFloat("service_cost"))
				.build();
		//@formatter:on
	}
});
}

}