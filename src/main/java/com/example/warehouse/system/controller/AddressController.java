package com.example.warehouse.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warehouse.system.requestdto.AddressRequest;
import com.example.warehouse.system.responsedto.AddressResponse;
import com.example.warehouse.system.responsedto.WarehouseResponse;
import com.example.warehouse.system.service.AddressService;
import com.example.warehouse.system.utility.ErrorStructure;
import com.example.warehouse.system.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/v1")
public class AddressController {

	@Autowired

	private AddressService addressService;
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Address created successfully",
							content= {
									@Content(schema = @Schema(oneOf=AddressResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})

	@PostMapping("/warehouses/{wareHouseId}/addresses")

	public ResponseEntity<ResponseStructure<AddressResponse>> createAddress(@RequestBody AddressRequest addressRequest, @PathVariable int wareHouseId)
	{
		return addressService.createAddress(addressRequest,wareHouseId);
	}
	
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Address Found successfully",
							content= {
									@Content(schema = @Schema(oneOf=WarehouseResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})
	@GetMapping("/addresses/{addressId}")

	public ResponseEntity<ResponseStructure<AddressResponse>> findAddress(@PathVariable int addressId)
	{
		return addressService.findAddress(addressId);
	}
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Address Updated successfully",
							content= {
									@Content(schema = @Schema(oneOf=WarehouseResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})
	
	
	@PutMapping("/addresses/{addressId}")

	public ResponseEntity<ResponseStructure<AddressResponse>> updateAddress(@RequestBody AddressRequest addressRequest,@PathVariable int addressId)
	{
		return addressService.updateAddress(addressRequest,addressId);
	}

}
