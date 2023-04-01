package com.bikeshop.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bikeshop.entity.WorkOrder;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/workorder")
@OpenAPIDefinition(info = @Info(title = "WorkOrder"), servers = {
@Server(url = "http://localhost:8080", description = "Local server.")})


public interface WorkOrderController {
	
	
	//read
	
	  @Operation(
	      summary = "Returns a Work order By customer",
	      description = "Returns a work order given a customerID",
	      responses = {
	          @ApiResponse(
              responseCode = "200",
	              description = "A work order is returned",
	              content = @Content(
	                  mediaType = "application/json", 
	                  schema = @Schema(implementation = WorkOrder.class))),
	          @ApiResponse(
	              responseCode = "400", 
	              description = "invalid request",  
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "404", 
	              description = "No bike services were found with the input criteria",  
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "500", 
	              description = "An unplanned error occurred.",  
	              content = @Content(mediaType = "application/json"))
	      },
	      parameters = {
	          @Parameter(name = "customerID", 
	              allowEmptyValue = false, 
	              required = false, 
	              description = "the customer")
	      })
	  @GetMapping
	  @ResponseStatus(code = HttpStatus.OK)
	  List<WorkOrder> fetchWorkOrderByCustomerID(
	  @RequestParam(required = false) int customerID);
	

	@Operation(
	    summary = "Deletes an existing service",
	    description = "Deletes an existing service given a service ID",
	       responses = {
	    		   @ApiResponse(
	            responseCode = "201", 
	            description = "Service has been deleted",
	            content = @Content(
	                mediaType = "application/json", 
	                schema = @Schema(implementation = WorkOrder.class))),
	        @ApiResponse(
	            responseCode = "400", 
	            description = "invalid request",  
	            content = @Content(mediaType = "application/json")),
	        @ApiResponse(
	            responseCode = "404", 
	            description = "No bike services were found",  
	            content = @Content(mediaType = "application/json")),
	        @ApiResponse(
	            responseCode = "500", 
	            description = "An unplanned error occurred.",  
	            content = @Content(mediaType = "application/json"))
	    },
	    		 
	    parameters = {
		        @Parameter(name = "workOrder", 
	            allowEmptyValue = false, 
		            required = false, 
		            description = "workOrder Id")
	    }
	    )
	    
	      @DeleteMapping("workOrderID")
	      @ResponseStatus(code = HttpStatus.OK)
	
	     void  deleteWorkOrder ( @RequestParam (required = true) int workOrderID);
	


	@Operation(
	    summary = "creates a work order",
	    description = "creates a work order",
	       responses = {
	    	@ApiResponse(
            responseCode = "201",
	            description = "work order was created",
	            content = @Content(
	                mediaType = "application/json", 
	                schema = @Schema(implementation = WorkOrder.class))),
	        @ApiResponse(
	            responseCode = "400", 
	            description = "invalid request",  
	            content = @Content(mediaType = "application/json")),
	        @ApiResponse(
	            responseCode = "404", 
	            description = "no work orders were found",  
	            content = @Content(mediaType = "application/json")),
	        @ApiResponse(
	            responseCode = "500", 
	            description = "An unplanned error occurred.",  
	            content = @Content(mediaType = "application/json"))
},
	       parameters = {
	
	        @Parameter(name = "customerID", 
            allowEmptyValue = false, 
	            required = false, 
	            description = "who's the customer"),
	        @Parameter(name = "serviceID", 
            allowEmptyValue = false, 
	            required = false, 
	            description = "the type of service")
	    })
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED) 
	WorkOrder createAWorkOrder(
			@RequestParam int customerID,
			@RequestParam int  serviceID);

	@Operation(
	  summary = "Returns an updated work order",
	  description = "Returns an updated work order given an ID",
	  responses = {
	      @ApiResponse(
	          responseCode = "200",
	          description = "An updated work order is returned",
	          content = @Content(
	              mediaType = "application/json", 
	              schema = @Schema(implementation = WorkOrder.class))),
	      @ApiResponse(
	          responseCode = "400", 
	          description = "invalid request",  
	          content = @Content(mediaType = "application/json")),
	      @ApiResponse(
	          responseCode = "404", 
	          description = "no services were found",  
	          content = @Content(mediaType = "application/json")),
	      @ApiResponse(
	          responseCode = "500", 
	          description = "An unplanned error occurred.",  
	          content = @Content(mediaType = "application/json"))
	  }, parameters = {
	      @Parameter(name = "workOrderID", 
	          allowEmptyValue = false, 
	          required = false, 
	          description = "The workOrder Id within our database"),
	      @Parameter(name = "customerID", 
          allowEmptyValue = false, 
          required = false, 
          description = "The customer who wants the work done"),
	      @Parameter(name = "timeAllotment", 
          allowEmptyValue = false, 
          required = false, 
          description = "how much time it takes"),
	      @Parameter(name = "costOfService", 
          allowEmptyValue = false, 
          required = false, 
          description = "how much the customer will pay")
	}
	)

	@PutMapping
	@ResponseStatus(code = HttpStatus.OK) 
	WorkOrder updateWorkOrder(
			@RequestParam int workOrderID, 
			@RequestParam int customerID, 
			@RequestParam int timeAllotment,
			@RequestParam float costOfService);
	  
}