package com.example.warehouse.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warehouse.system.requestdto.StorageTypeRequest;
import com.example.warehouse.system.responsedto.AdminResponse;
import com.example.warehouse.system.responsedto.StorageTypeResponse;
import com.example.warehouse.system.service.StorageTypeService;
import com.example.warehouse.system.utility.ErrorStructure;
import com.example.warehouse.system.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/v1")
public class StorageTypeController {
	
	@Autowired
	private StorageTypeService storageTypeService;
	
	@Operation(description="The endpoint is used to add the"		
			+ " data to the data base",
					responses= {
							@ApiResponse(responseCode = "201", description="StorageType created successfully",
									content= {
											@Content(schema = @Schema(oneOf=StorageTypeResponse.class))
								}),
						@ApiResponse(responseCode="400", description="Invalid Input",
						content= {
									@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
							})
					})
			
			
			
	
	@PostMapping("/storagetypes")
	
	public ResponseEntity<ResponseStructure<StorageTypeResponse>> createStorageType(@RequestBody StorageTypeRequest storageTypeRequest)
	{
		return storageTypeService.createStorageType(storageTypeRequest);
	}
	
	@Operation(description="The endpoint is used to add the"		
			+ " data to the data base",
					responses= {
							@ApiResponse(responseCode = "201", description="StorageType  Updated successfully",
									content= {
											@Content(schema = @Schema(oneOf=StorageTypeResponse.class))
								}),
						@ApiResponse(responseCode="400", description="Invalid Input",
						content= {
									@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
							})
					})
	
	
@PutMapping("/storagetypes/{storageTypeId}")
	
	public ResponseEntity<ResponseStructure<StorageTypeResponse>> updateStorageTypeById(@RequestBody StorageTypeRequest storageTypeRequest, @PathVariable int storageTypeId)
	{
		return storageTypeService.updateStorageTypeById(storageTypeRequest,storageTypeId);
	}	
			
	@Operation(description="The endpoint is used to add the"		
			+ " data to the data base",
					responses= {
							@ApiResponse(responseCode = "201", description="StorageType Found successfully",
									content= {
											@Content(schema = @Schema(oneOf=StorageTypeResponse.class))
								}),
						@ApiResponse(responseCode="400", description="Invalid Input",
						content= {
									@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
							})
					})
			
			
			
	
	@GetMapping("/storagetypes")
	
	public ResponseEntity<ResponseStructure<List<StorageTypeResponse>>> findAllStorageTypes()
	{
		return storageTypeService.findAllStorageTypes();
	}
		

}
