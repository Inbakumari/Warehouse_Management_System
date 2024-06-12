package com.example.warehouse.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warehouse.system.requestdto.AddressRequest;
import com.example.warehouse.system.responsedto.AddressResponse;
import com.example.warehouse.system.service.AddressService;
import com.example.warehouse.system.utility.ResponseStructure;

@RestController
@RequestMapping("/api/v1")
public class AddressController {

	@Autowired

	private AddressService addressService;


	@PostMapping("/warehouses/{wareHouseId}/addresses")

	public ResponseEntity<ResponseStructure<AddressResponse>> createAddress(@RequestBody AddressRequest addressRequest, @PathVariable int wareHouseId)
	{
		return addressService.createAddress(addressRequest,wareHouseId);
	}
	
	@GetMapping("/addresses/{addressId}")

	public ResponseEntity<ResponseStructure<AddressResponse>> findAddress(@PathVariable int addressId)
	{
		return addressService.findAddress(addressId);
	}
	

}
