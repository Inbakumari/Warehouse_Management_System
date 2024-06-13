package com.example.warehouse.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warehouse.system.repository.WareHouseRepository;
import com.example.warehouse.system.requestdto.WarehouseRequest;
import com.example.warehouse.system.responsedto.AdminResponse;
import com.example.warehouse.system.responsedto.WarehouseResponse;
import com.example.warehouse.system.service.WarehouseService;
import com.example.warehouse.system.utility.ErrorStructure;
import com.example.warehouse.system.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;



@RestController
@RequestMapping("/api/v1")
public class WarehouseController {

	@Autowired
	private WarehouseService wareHouseService;
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Warehouse created successfully",
							content= {
									@Content(schema = @Schema(oneOf=WarehouseResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})

	@PostMapping("/warehouses")
	@PreAuthorize("hasAuthority('CREATE_WAREHOUSE')") 
	public ResponseEntity<ResponseStructure<WarehouseResponse>>	createWareHouse(@RequestBody WarehouseRequest wareHouseRequest)
	{
		return  wareHouseService.createWarehouse(wareHouseRequest);
	}
	
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Warehouse Updated successfully",
							content= {
									@Content(schema = @Schema(oneOf=WarehouseResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})

	@PutMapping("/warehouses/{warehouseId}")
	public ResponseEntity<ResponseStructure<WarehouseResponse>> updateWarehouse(@RequestBody WarehouseRequest warehouseRequest, @PathVariable int warehouseId )
	{
		return wareHouseService.updateWarehouse(warehouseRequest,warehouseId);
	}

	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Warehouse Found successfully",
							content= {
									@Content(schema = @Schema(oneOf=WarehouseResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})
	@GetMapping("/warehouses/{warehouseId}")

	public ResponseEntity<ResponseStructure<WarehouseResponse>> findWarehouse(@PathVariable int warehouseId) {
		return wareHouseService.findWarehouse(warehouseId);


	}
	
	@GetMapping("/warehouses")
    public ResponseEntity<ResponseStructure<List<WarehouseResponse>>> findWarehouses() {
        return wareHouseService.findWarehouses();
    }

}