package com.bikeshop.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bikeshop.entity.Customer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/customer")
@OpenAPIDefinition(info = @Info(title = "Customer"), servers = {
		@Server (url = "http://localhost:8080", description = "Local server.")})
public interface CustomersController {
	
	@Operation (
	summary = "Returns a list of customers",
			description = "Returns a list of Customers all first and last name",
			responses = {
					@ApiResponse (
						responseCode = "200",
								description = "Customers is returned in a list",
								content = @Content (mediaType = "application/json")),
					
					@ApiResponse (
							responseCode = "400",
									description = "Request parameters invalid",
									content = @Content (mediaType = "application/json")),
				
					@ApiResponse (
							responseCode = "404",
									description = "No customers were found with the input",
									content = @Content (mediaType = "application/json")),
				
					@ApiResponse (
							responseCode = "500",
									description = "An unplanned error occured",
									content = @Content (mediaType = "application/json"))
	}
)
	@GetMapping ("/all")
	@ResponseStatus(code = HttpStatus.OK)
	List<Customer> fetchAllCustomers (
			);
	
	
	@Operation (
			summary = "Return a customer",
			description = "Returns a customer given their first and last name",
			responses = {
				
					@ApiResponse(
							responseCode = "200",
							description = "Customers are returned",
							content = @Content (mediaType = "application/json",
							schema = @Schema(implementation = Customer.class))),
	
	@ApiResponse(
			responseCode = "400",
			description = "Invalid request parameters",
			content = @Content (mediaType = "application/json")),
	
	@ApiResponse(
			responseCode = "404",
			description = "No customers found",
			content = @Content (mediaType = "application/json")),
	
	@ApiResponse(
			responseCode = "500",
			description = "An unplanned error",
			content = @Content (mediaType = "application/json")),
			},
			parameters = {
					@Parameter (name = "firstName",
							allowEmptyValue = false,
							required = false,
							description = "Customer's first name"),
					@Parameter (name = "lastName", allowEmptyValue = false,
					required = false,
					description = "Customer's last name"),
			})
@GetMapping("/aCustomer")
	@ResponseStatus(code = HttpStatus.OK)
	List<Customer> fetchACustomer (
			@RequestParam(required = false)
			String firstName,
			@RequestParam(required = false)
			String lastName);
			
	
	
@Operation(
	      summary = "Returns customer by first name",
	      description = "Returns the customer entered",
	      responses = {
	          @ApiResponse(
	              responseCode = "200",
	              description = "A customer's returned",
	              content = @Content(
	                  mediaType = "application/json", 
	                  schema = @Schema(implementation = Customer.class))),
	        
	          @ApiResponse(
	              responseCode = "400", 
	              description = "The parameters are invalid",  
	              content = @Content(mediaType = "application/json")),
	          
	          @ApiResponse(
	              responseCode = "404", 
	              description = "No customer found",  
	              content = @Content(mediaType = "application/json")),
	          
	          @ApiResponse(
	              responseCode = "500", 
	              description = "An unplanned error occurred.",  
	              content = @Content(mediaType = "application/json")),
	      },
	      parameters = {
	          @Parameter(name = "firstName",
	              allowEmptyValue = false,
	              required = false,
	              description = "Customer's first name"),
	     }
	  )
	  @GetMapping("/firstName")
	  @ResponseStatus(code = HttpStatus.OK)
	  List<Customer> fetchCustomerByFirstName(                                                     
	      @RequestParam(required = false)
	      String firstName);


@Operation(
	      summary = "Creates a new Customer",
	      description = "Returns the created Customer",
	      responses = {
	          @ApiResponse(
	              responseCode = "201",
	              description = "New customer has been added",
	              content = @Content(
	                  mediaType = "application/json", 
	                  schema = @Schema(implementation = Customer.class))),
	          @ApiResponse(
	              responseCode = "400", 
	              description = "Request invalid",  
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "404", 
	              description = "No customer found",  
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "500", 
	              description = "An unplanned error occurred.",  
	              content = @Content(mediaType = "application/json"))
	          
	      },
	      parameters = {
	          
          @Parameter(name = "firstName", 
              allowEmptyValue = false, 
              required = false, 
              description = "Customer's first name"),
          @Parameter(name = "lastName", 
          allowEmptyValue = false, 
          required = false, 
          description = "Customer's last name"),
          @Parameter(name = "phone", 
          allowEmptyValue = false, 
          required = false, 
          description = "Customer's phone number")
      }
	 
	      )
@PostMapping
@ResponseStatus(code = HttpStatus.CREATED)
Customer createCustomer (@RequestParam(required = false)
String firstName, 
@RequestParam(required = false)
String lastName,
@RequestParam (required = false) String phone);
	      
@Operation(
	      summary = "Updates an existing customer",
	      description = "Returns the updated customer",
	      responses = {
	          @ApiResponse(
	              responseCode = "200",
	              description = "Updated customer returned",
	              content = @Content(
	                  mediaType = "application/json", 
	                  schema = @Schema(implementation = Customer.class))),
	          @ApiResponse(
	              responseCode = "400", 
	              description = "Invalid request",  
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "404", 
	              description = "No customer was found",  
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
	            				  description = "customer identification in the database"),
	            		  @Parameter(name = "firstName", 
	        	              allowEmptyValue = false, 
	        	              required = false, 
	        	              description = "Customer's first name"),
	        	          @Parameter(name = "lastName", 
	        	          allowEmptyValue = false, 
	        	          required = false, 
	        	          description = "Customer's last name"),
	        	          @Parameter(name = "phone", 
	        	          allowEmptyValue = false, 
	        	          required = false, 
	        	          description = "Customer's phone number")
	      }
	  )
	  @PutMapping
	  @ResponseStatus(code = HttpStatus.OK)
	  Customer updateACustomer(
			  @RequestParam (required = false)
	       int customerID, 
	      @RequestParam (required = false)
			  String phone,
			  @RequestParam (required = false)
			  String firstName,
			  @RequestParam (required = false)
			  String lastName);
	     
	      
}



	
	
	