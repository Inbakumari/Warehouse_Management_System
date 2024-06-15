package com.example.warehouse.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.warehouse.system.entity.Storage;
import com.example.warehouse.system.repository.StorageRespository;
import com.example.warehouse.system.requestdto.StorageRequest;
import com.example.warehouse.system.responsedto.StorageResponse;
import com.example.warehouse.system.responsedto.WarehouseResponse;
import com.example.warehouse.system.service.StorageService;
import com.example.warehouse.system.utility.ErrorStructure;
import com.example.warehouse.system.utility.ResponseStructure;
import com.example.warehouse.system.utility.SimpleStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/v1")
public class StorageController {
	
	@Autowired
	
	private StorageService storageService;
	
	
	@Autowired
	private StorageRespository storageRespository;
	
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Storage created successfully",
							content= {
									@Content(schema = @Schema(oneOf=StorageResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})
	@PostMapping("/warehouses/{wareHouseId}/storages")
	public ResponseEntity<SimpleStructure<String>> createStorage(@RequestBody StorageRequest storageRequest,@PathVariable int wareHouseId, @RequestParam int noOfStorageUnits)

	{
		return storageService.createStorage(storageRequest,wareHouseId,noOfStorageUnits);
	}
	
	
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Storage updated successfully",
							content= {
									@Content(schema = @Schema(oneOf=StorageResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})
	@PutMapping("/storages/{storageId}")
	public ResponseEntity<ResponseStructure<StorageResponse>> updateStorage(@RequestBody StorageRequest storageRequest, @PathVariable int storageId)
	{
		return storageService.updateStorage(storageRequest,storageId);
	}
	
	@GetMapping("/getStorage/{capacityInKg}/{lengthInMeters}/{breadthInMeters}/{HeightInMeters}")
	public ResponseEntity<ResponseStructure<StorageResponse>> findByFirstStorage(@PathVariable double capacityInKg,@PathVariable double lengthInMeters,@PathVariable double breadthInMeters, @PathVariable double HeightInMeters)
	{
		return storageService.findByFirstStorage(capacityInKg,lengthInMeters,breadthInMeters,HeightInMeters) ;
	}
}
