package com.example.warehouse.system.service;

import org.springframework.http.ResponseEntity;

import com.example.warehouse.system.requestdto.AddressRequest;
import com.example.warehouse.system.responsedto.AddressResponse;
import com.example.warehouse.system.utility.ResponseStructure;

public interface AddressService {

	ResponseEntity<ResponseStructure<AddressResponse>> createAddress(AddressRequest addressRequest, int wareHouseId);

	ResponseEntity<ResponseStructure<AddressResponse>> findAddress(int addressId);

	

}
