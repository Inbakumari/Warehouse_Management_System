package com.example.warehouse.system.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.warehouse.system.entity.Address;
import com.example.warehouse.system.entity.Admin;
import com.example.warehouse.system.entity.Warehouse;
import com.example.warehouse.system.enums.AdminType;
import com.example.warehouse.system.exception.AddressNotFoundByIdException;
import com.example.warehouse.system.exception.IllegalOperationException;
import com.example.warehouse.system.exception.WarehouseNotFoundByIdException;
import com.example.warehouse.system.mapper.AddressMapper;
import com.example.warehouse.system.repository.AddressRepository;
import com.example.warehouse.system.repository.WareHouseRepository;
import com.example.warehouse.system.requestdto.AddressRequest;
import com.example.warehouse.system.responsedto.AddressResponse;
import com.example.warehouse.system.responsedto.AdminResponse;
import com.example.warehouse.system.responsedto.WarehouseResponse;
import com.example.warehouse.system.service.AddressService;
import com.example.warehouse.system.utility.ResponseStructure;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired

	private AddressRepository addressRepository;

	@Autowired

	private AddressMapper addressMapper;

	@Autowired
	private WareHouseRepository wareHouseRepository;

	@Override
	public ResponseEntity<ResponseStructure<AddressResponse>> createAddress(AddressRequest addressRequest,
			int wareHouseId) 
	{

		Warehouse warehouse = wareHouseRepository.findById(wareHouseId)
				.orElseThrow(() -> new WarehouseNotFoundByIdException("Warehouse Not Found"));
		Address address = addressMapper.mapToAddress(addressRequest, new Address());
		address.setWarehouse(warehouse);
		address = addressRepository.save(address);
		return	ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseStructure<AddressResponse>()
						.setStatusCode(HttpStatus.CREATED.value())
						.setMessage("Address Created")
						.setData(addressMapper.mapToAddressResponse(address)));	


	}

	@Override
	public ResponseEntity<ResponseStructure<AddressResponse>> findAddress(int addressId) {
	    return addressRepository.findById(addressId).map(address -> {
	        AddressResponse addressResponse = addressMapper.mapToAddressResponse(address);
	       
	        return	ResponseEntity.status(HttpStatus.CREATED)
					.body(new ResponseStructure<AddressResponse>()
							.setStatusCode(HttpStatus.CREATED.value())
							.setMessage("Address Created")
							.setData(addressMapper.mapToAddressResponse(address)));
	        		
	    }).orElseThrow(() -> new AddressNotFoundByIdException("Failed to Find Address"));
	}

	@Override
	public ResponseEntity<ResponseStructure<AddressResponse>> updateAddress(AddressRequest addressRequest,
			int addressId) 
	{
		
		return addressRepository.findById(addressId).map(address -> {

			address = addressRepository.save(addressMapper.mapToAddress(addressRequest, address));

			return	ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseStructure<AddressResponse>()
							.setStatusCode(HttpStatus.OK.value())
							.setMessage("Address Updated Successfully")
							.setData(addressMapper.mapToAddressResponse(address)));
		}).orElseThrow(()->new AddressNotFoundByIdException("Address Not Found"));
	}
}