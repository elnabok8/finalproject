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

import com.bikeshop.entity.Services;
import com.mysql.cj.log.Log;

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
						.description(rs.getString("description"))
						.cost(rs.getFloat("cost"))
						.build();
			}
		});
	}
	
	public Services createService (int serviceID, String description, Float cost) {
		
		SqlParams sqlparams = new SqlParams();
		KeyHolder keyHolder = new GeneratedKeyHolder();
		sqlparams.sql = ""
				+"INSERT into services "
				+ "customer_fk, serviceDescription, cost) "
				+ "VALUES (:customer_fk, :serviceDescription, :cost)" ;
				
		sqlparams.source.addValue("description", description);
		sqlparams.source.addValue("cost", cost);
		
		jdbcTemplate.update(sqlparams.sql,  sqlparams.source, keyHolder);
		return Services.builder()
				.serviceID(serviceID)
				.description(description)
				.cost(cost)
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
						.description(rs.getString("description"))
						.cost(rs.getFloat("cost"))
						.build();
			}
		});
		
	}

	@Override
	public Services updateServices(int serviceID, int customerID, String description, float cost) {
		String sql = ""
				+ "UPDATE services "
				+ "SET "
				+ "customer_fk = :customer_fk, "
				+ "description = :description, "
				+"cost = :cost, "
				+ "WHERE services_pk = :services_pk" ;
		
		Map <String, Object> params = new HashMap<>();
		params.put("customer_fk", updatedService.getCustomerID());
		params.put("description", updatedService.getDescription());
		params.put("cost", updatedService.getCost());
		
		if (jdbcTemplate.update(sql,  params) == 0) {
			throw new NoSuchElementException("update failed");
		}
		
		return Services.builder()
				.serviceID(serviceID)
				.customerID(customerID)
				.description(description)
				.cost(cost)
				.build();
	}

	@Override
	public void deleteService(int serviceID) {
String sql = ""
+ "DELETE services "
		+ "WHERE serviceID = :serviceID";


}
}
