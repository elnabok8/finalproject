package com.bikeshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.bikeshop.entity.Customer;
import com.bikeshop.entity.WorkOrder;

import ch.qos.logback.core.status.Status;
import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class DefaultWorkOrderDao implements WorkOrderDao {
	
	
	  @Autowired 
	  private NamedParameterJdbcTemplate jdbcTemplate;
	public int timeAllotment;
	public float costOfService;
	public int serviceID;
	  
	  
	  public List<WorkOrder> fetchWorkOrderByCustomer(int customerID) {
	    log.debug("DAO: customer_id={}", customerID );
	    
	    // @formatter:off
	    String sql = ""
	        + "SELECT * "
	        + "FROM work_order "
	        + "WHERE customer_id = :customer_id";
	    // @formatter:on
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("customer_id", customerID); 
	    
	    return jdbcTemplate.query(sql, params,
	        new RowMapper<>() {
	            @Override
	            public WorkOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
	           // @formatter:off
	            return WorkOrder.builder()
	            .workOrderID(rs.getInt("work_order_id"))
	            .customerID(rs.getInt("customer_id"))
	            .costOfService(rs.getFloat("cost_of_service"))
	            .build(); 
	          }
	    });    
	  }
			public WorkOrder createAWorkOrder(int customerID, int serviceID) {
				
			   String sql = ""
			        + "INSERT INTO work_order "
			        + "(customer_id, service_id) "
			       + "VALUES "
			        + "(:customer_id, :service_id)";

			   Map<String, Object> params = new HashMap<>();
			   params.put("customer_id", customerID);
			   params.put("service_id", serviceID);
			   

			    
			    
			    jdbcTemplate.update(sql, params);
			    return WorkOrder.builder()
			        .customerID(customerID)
			        .serviceID(serviceID)
			        .build();
	  }

	  public void deleteWorkOrder(int bikeServiceID) {
	    // @formatter:off
	    String sql = ""
	        + "DELETE FROM bike_service "
	        + "WHERE bike_service_id = :bike_service_id;";
	    // @formatter:on    
	       
	    Map<String, Object> params = new HashMap<>();
	    
	    params.put("bike_service_id", bikeServiceID);    
	    if (jdbcTemplate.update(sql,  params) == 0) throw new NoSuchElementException();

	  }
	@Override
	public WorkOrder updateWorkOrder(int workOrderID, int customerID, int timeAllotment, float costOfService) {
		String sql = ""
	        + "UPDATE workOrderID "
		        + "SET "
		        + "customer_id = :customer_id, "
		        + "time_allotment = :time_allotment, "
		        + "cost_of_service = :cost_of_service, "
		        + "WHERE service_id = :service_id; ";
		
		Map<String, Object> params = new HashMap<>();
	    params.put("work_order_id", workOrderID);
	    params.put("customer_id", customerID);
	    params.put("time_alltoment", timeAllotment);
	    params.put("cost_of_service", costOfService);
	    params.put("service_id", serviceID);
	    return WorkOrder.builder()
	    		   .workOrderID(workOrderID)
	    		   .customerID(customerID)
	    		   .timeAllotment(timeAllotment)
	    		   .costOfService(costOfService)
	    		   .serviceID(serviceID)
	    		   .build();
	}
	
	
	}
