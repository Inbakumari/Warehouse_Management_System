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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.warehouse.system.entity.Inventory;
import com.example.warehouse.system.requestdto.InventoryRequest;
import com.example.warehouse.system.responsedto.BatchResponse;
import com.example.warehouse.system.responsedto.ClientResponse;
import com.example.warehouse.system.responsedto.InventoryResponse;
import com.example.warehouse.system.service.InventoryService;
import com.example.warehouse.system.utility.ErrorStructure;
import com.example.warehouse.system.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Inventory created successfully",
							content= {
									@Content(schema = @Schema(oneOf=InventoryResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})
	
	@PostMapping("/storages/{storageId}/clients/{clientId}/inventories")
	
	public ResponseEntity<ResponseStructure<InventoryResponse>> createInventory(@RequestBody InventoryRequest inventoryRequest,
			@PathVariable int storageId,  @PathVariable int clientId,
			@RequestParam("quantity") int  quantity)
	{
		return inventoryService.createInventory(inventoryRequest,storageId, quantity,clientId);
	}
	
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Inventory Found successfully",
							content= {
									@Content(schema = @Schema(oneOf=InventoryResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})
	
@GetMapping("/inventories/{inventoryId}")
	
	public ResponseEntity<ResponseStructure<InventoryResponse>> findInventoryById(@PathVariable int inventoryId)
	{
		return inventoryService.findInventoryById(inventoryId);
	}
	
	
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Inventory Found successfully",
							content= {
									@Content(schema = @Schema(oneOf=InventoryResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})
	
@GetMapping("/inventories")
	
	public ResponseEntity<ResponseStructure<List<InventoryResponse>>> findAllInventorys()
	{
		return inventoryService.findAllInventorys();
	}
	
	
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Inventory Updated successfully",
							content= {
									@Content(schema = @Schema(oneOf=InventoryResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})
	
@PutMapping("/storages/{storageId}/inventories/{inventoryId}")
	
	public ResponseEntity<ResponseStructure<InventoryResponse>> updateInventory(@RequestBody @Valid InventoryRequest inventoryRequest,@PathVariable int inventoryId, @PathVariable int storageId)
	
	{
		return inventoryService.updateInventory(inventoryRequest,inventoryId,storageId);
	}
	
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Quantity Updated successfully",
							content= {
									@Content(schema = @Schema(oneOf=InventoryResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})
	
	
@PutMapping("/storages/{storageId}/inventories/{inventoryId}/batches")
	
	public ResponseEntity<ResponseStructure<BatchResponse>> updateQuantityUsingBatch(@PathVariable int storageId, @PathVariable int inventoryId, @RequestParam("quantity") int quantity)
	
	{
		return inventoryService.updateQuantityUsingBatch(storageId,inventoryId,quantity);
	}

}
