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
	        + "WHERE customerID = :customerID";
	    // @formatter:on
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("customer_id", customerID()); //why doesn't it like customer ID when it likes it on line 40?
	    
	    return jdbcTemplate.query(sql, params,
	        new RowMapper<>() {
	            @Override
	            public WorkOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
	           // @formatter:off
	            return WorkOrder.builder()
	            .bikeServiceID(rs.getInt("bike_service_id"))
	            .customerID(rs.getInt("customer_id"))
	            .costOfService(rs.getFloat("cost_of_service"))
	            .build(); 
	          }
	    });    
	  }
			public WorkOrder createAWorkOrder(int bikeServiceID, int customerID, int timeAllotment, int costOfService) {
				SqlParams sqlparams = new SqlParams();
			    KeyHolder keyHolder = new GeneratedKeyHolder();
			    sqlparams.sql = ""
			        + "INSERT INTO work_order "
			        + "(bike_serviceid, customerID, "
			        + "time_allotment, cost_Of_Service, serviceID) VALUES"
			        + "(:bike_serviceID, :customerID,"
			        + ":timeallotment, :costOfService, :serviceID)";

			    sqlparams.source.addValue("bike_serviceid", bikeServiceID);
			    sqlparams.source.addValue("customerID", customerID);
			    sqlparams.source.addValue("time_allotment", (timeAllotment));
			    sqlparams.source.addValue("cost_of_service", costOfService);
			    sqlparams.source.addValue("serviceID", serviceID);

			    
			    
			    jdbcTemplate.update(sqlparams.sql, sqlparams.source, keyHolder);
			    return WorkOrder.builder()
			        .bikeServiceID(keyHolder.getKey().intValue())
			        .customerID(customerID)
			        .timeAllotment(timeAllotment)
			        .costOfService(costOfService)
			        .serviceID(serviceID)
			        .build();
			}

	  class SqlParams {
	    String sql;
	    MapSqlParameterSource source = new MapSqlParameterSource();
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
	public WorkOrder updateWorkOrder(int bikeServiceID, int customerID, int timeAllotment, int costOfService) {
		//WorkOrder newWorkOrder = null; //I know that this needs instantiated in order to exist and store the informatin, but I'm not sure
		//where it ought to be stored.
		String sql = ""
			        + "UPDATE bike_service_id "
			        + "SET "
			        + "customer_id = :customer_id, "
			        + "time_allotment = :time_allotment, "
			        + "cost_of_service = :cost_of_service, "
			        + "WHERE service_id = :service_id; ";
			    // @formatter:on
			    
			    Map<String, Object> params = new HashMap<>();
			    params.put("bike_service_id", WorkOrder.getBikeServiceID());
			    params.put("customer_id", WorkOrder.getCustomerID());
			    params.put("time_alltoment", WorkOrder.getTimeAllotment());
			    params.put("cost_of_service", WorkOrder.getCostOfService());
			    params.put("service_id", WorkOrder.getServiceID());
			    
			    if (jdbcTemplate.update(sql, params) == 0) {
			      throw new NoSuchElementException("update failed");
			     }
			       return WorkOrder.builder()
			    		   .bikeServiceID(bikeServiceID)
			    		   .customerID(bikeServiceID)
			    		   .timeAllotment(timeAllotment)
			    		   .costOfService(costOfService)
			    		   .serviceID(serviceID)
			    		   .build();
	
	}
	
	}
