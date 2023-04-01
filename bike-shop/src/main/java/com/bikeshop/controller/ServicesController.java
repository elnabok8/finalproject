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

import com.bikeshop.entity.Services;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
@Validated
@RequestMapping("/service")
@OpenAPIDefinition(info = @Info(title = "Service"), servers = {
		@Server (url = "Http://localhost8080",
				description = "Local server.")})
public interface ServicesController {

	@Operation(summary = "Returns the list of Services",
			responses = {
					@ApiResponse (
							responseCode = "200",
							description = "A list of Services gets returned",
							content = @Content (
									mediaType = "application/json",
									schema = @Schema(implementation = ServicesController.class))),
					
					@ApiResponse (
						responseCode = "400",
							description = "Request invalid",
							content = @Content (mediaType = "application/json")),
					
					@ApiResponse (
							responseCode = "404",
						description = "No services found",
								content = @Content (mediaType = "application/json")),
					
					@ApiResponse (
						responseCode = "500",
							description = "Unplanned error",
							content = @Content (mediaType = "application/json"))
	}, 
			parameters = {
					@Parameter (
					name = "serviceID",
							allowEmptyValue = false,
							required = false,
							description = "service id number in database")


	}
			)
	@GetMapping("/fetch service")
			@ResponseStatus(code = HttpStatus.OK)
	
	List<Services> fetchService(
			@RequestParam(required = false) int serviceID);
	
	
	@Operation(
			summary = "Updates the list of services",
			description = "Returns the updated list of services",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "Returns updated service",
							content = @Content (
					mediaType = "application/json",
					schema = @Schema (implementation = ServicesController.class))),
					
					@ApiResponse(
							responseCode = "400",
							description = "Request invalid",
							content = @Content(mediaType = "application/json")),
					
					@ApiResponse(
							responseCode = "404",
							description = "No Services were found",
							content = @Content(mediaType = "application/json")),
					
					@ApiResponse(
							responseCode = "500",
							description = "An error occured",
							content = @Content(mediaType="application/json")),
			},
			
			parameters = {
					@Parameter(name = "serviceID",
							allowEmptyValue = false,
							description = "The service ID in the database"),
			}) 
	@Parameter (name = "serviceDescription",
			allowEmptyValue = false,
			required = false,
			description = "details about the service")
			@Parameter (name = "serviceCost",
				allowEmptyValue = false,
				required = false,
				description = "how much is the service")
			
			@PutMapping
			@ResponseStatus(code = HttpStatus.OK)
			Services updateAService(
					@RequestParam (required = false) int serviceID, 
					@RequestParam (required = false) String serviceDescription,
					@RequestParam (required = false) float serviceCost);


	@Operation(
			summary = "creates a new service",
			description = "returns the created service",
			responses = {
					@ApiResponse(
							responseCode = "201",
							description = "a new service was created",
							content = @Content (
					mediaType = "application/json",
					schema = @Schema (implementation = Services.class))),
					
					@ApiResponse(
							responseCode = "400",
							description = "Request invalid",
							content = @Content(mediaType = "application/json")),
					
					@ApiResponse(
							responseCode = "404",
							description = "No Services were found",
							content = @Content(mediaType = "application/json")),
					
					@ApiResponse(
							responseCode = "500",
							description = "An error occured",
							content = @Content(mediaType="application/json")),
			},
			parameters = {
					@Parameter(name = "serviceID",
							allowEmptyValue = false,
							required = false,
							description = "The ID number of the service"),
			
			@Parameter(name = "serviceDescription",
			allowEmptyValue = false,
			required = false,
			description = "What the heck this service is"),
			
			@Parameter(name = "serviceCost",
			allowEmptyValue = false,
			required = false,
			description = "The cost of the service")

}
			)
					@PostMapping
					@ResponseStatus(code = HttpStatus.CREATED)
					Services createService (
							@RequestParam (required = false) int serviceID, 
							@RequestParam (required = false) String serviceDescription,
							@RequestParam (required = false) float serviceCost);
	
	
	@Operation(
			summary = "deletes a service",
			description = "deletes a service",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "a service was deleted",
							content = @Content (
					mediaType = "application/json",
					schema = @Schema (implementation = ServicesController.class))),
					
					@ApiResponse(
							responseCode = "400",
							description = "Request invalid",
							content = @Content(mediaType = "application/json")),
					
					@ApiResponse(
							responseCode = "404",
							description = "No Services were found",
							content = @Content(mediaType = "application/json")),
					
					@ApiResponse(
							responseCode = "500",
							description = "An error occured",
							content = @Content(mediaType="application/json")),
			},
			parameters = {
					@Parameter(name = "serviceID",
							allowEmptyValue = false,
							required = false,
							description = "deletes service"),
			}
			)
					@DeleteMapping
					@ResponseStatus(code = HttpStatus.OK)
					void deleteService (@RequestParam (required = false) int serviceID);
	
}
			
			
	
	
