package com.bikeshop.dao;

import static org.mockito.Mockito.description;

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
@Component
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
	
	public Services createService (int serviceID, int customerID, String description, Float cost) {
		
		SqlParams sqlparams = new SqlParams();
		KeyHolder keyHolder = new GeneratedKeyHolder();
		sqlparams.sql = ""
				+"INSERT into services "
				+ "service_id, customer_id, serviceDescription, cost) "
				+ "VALUES (:customer_fk, :serviceDescription, :cost)" ;
				
		sqlparams.source.addValue("customer_id", customerID);
		sqlparams.source.addValue("description", description);
		sqlparams.source.addValue("cost", cost);
		
		jdbcTemplate.update(sqlparams.sql,  sqlparams.source, keyHolder);
		return Services.builder()
				.serviceID(serviceID)
				.customerID(customerID)
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
	public Services updateAService(int serviceID, int customerID, String description, float cost) {
		String sql = ""
				+ "UPDATE services "
				+ "SET "
				+ "customer_id = :customer_id, "
				+ "description = :description, "
				+"cost = :cost, "
				+ "WHERE service_id = :service_id" ;
		
		Map <String, Object> params = new HashMap<>();
		params.put("customer_id",customerID);
		params.put("description", description);
		params.put("cost", cost);
		
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

	@Override
	public List<Services> fetchService(int serviceID) {
		String sql = ""
				+ "SELECT * "
				+ "WHERE service_id = :service_id";
		
		Map <String, Object> params = new HashMap<>();
		params.get("customer_id",customerID);
		params.get("description", description);
		params.get("cost", cost);
		
		return Services.builder()
				.serviceID(serviceID)
				.customerID(customerID)
				.description(description)
				.cost(cost)
				.build();
				;
	}
}
