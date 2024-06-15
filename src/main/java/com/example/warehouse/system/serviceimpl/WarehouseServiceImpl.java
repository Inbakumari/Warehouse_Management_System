package com.example.warehouse.system.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.warehouse.system.entity.Warehouse;
import com.example.warehouse.system.exception.AdminNotFoundByEmailException;
import com.example.warehouse.system.exception.WarehouseNotFoundByCityException;
import com.example.warehouse.system.exception.WarehouseNotFoundByIdException;
import com.example.warehouse.system.exception.WarehouseNotFoundByNameException;
import com.example.warehouse.system.mapper.WareHouseMapper;
import com.example.warehouse.system.repository.AddressRepository;
import com.example.warehouse.system.repository.WareHouseRepository;
import com.example.warehouse.system.requestdto.WarehouseRequest;
import com.example.warehouse.system.responsedto.AdminResponse;
import com.example.warehouse.system.responsedto.WarehouseResponse;
import com.example.warehouse.system.service.WarehouseService;
import com.example.warehouse.system.utility.ResponseStructure;

@Service
public class WarehouseServiceImpl implements WarehouseService{


	@Autowired
	private WareHouseRepository wareHouseRepository;

	@Autowired
	private WareHouseMapper wareHouseMapper;
	
	@Autowired
	private AddressRepository addressRepository;
	
	
	



	@Override
	public ResponseEntity<ResponseStructure<WarehouseResponse>> createWarehouse(WarehouseRequest wareHouseRequest) {


		Warehouse warehouse= wareHouseRepository.save(wareHouseMapper.mapToWarehouse(wareHouseRequest,new Warehouse()));
		warehouse.setTotalCapacityInKg(0);
		wareHouseRepository.save(warehouse);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseStructure<WarehouseResponse>()
						.setStatusCode(HttpStatus.CREATED.value())
						.setMessage("Warehouse created")
						.setData(wareHouseMapper.mapToWarehouseResponse(warehouse)));	

	}



	@Override
	public ResponseEntity<ResponseStructure<WarehouseResponse>> updateWarehouse(WarehouseRequest warehouseRequest,
			int warehouseId) 
	{
		return wareHouseRepository.findById(warehouseId).map(existingWarehouse -> {
			Warehouse updatedWarehouse = wareHouseMapper.mapToWarehouse(warehouseRequest, existingWarehouse);
			updatedWarehouse = wareHouseRepository.save(updatedWarehouse);
			WarehouseResponse warehouseResponse = wareHouseMapper.mapToWarehouseResponse(updatedWarehouse);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseStructure<WarehouseResponse>()
							.setStatusCode(HttpStatus.OK.value())
							.setMessage("Warehouse Updated Successfully")
							.setData(warehouseResponse));
		}).orElseThrow(() -> new WarehouseNotFoundByNameException("Warehouse Not Found"));

	}



	@Override
	public ResponseEntity<ResponseStructure<WarehouseResponse>> findWarehouse(int warehouseId) {
		return wareHouseRepository.findById(warehouseId).map(warehouse -> 
		{
			WarehouseResponse warehouseResponse=wareHouseMapper.mapToWarehouseResponse(warehouse);
			return ResponseEntity
					.status(HttpStatus.FOUND)
					.body(new ResponseStructure<WarehouseResponse>()
							.setStatusCode(HttpStatus.FOUND.value())
							.setMessage("Warehouse Found")
							.setData(warehouseResponse));
		}).orElseThrow(() -> new WarehouseNotFoundByIdException("Failed to Found Warehouse"));




	}



	@Override
	public ResponseEntity<ResponseStructure<List<WarehouseResponse>>> findWarehouses() {

		List<WarehouseResponse> warehouseResponse = wareHouseRepository.findAll().stream()
				.map(warehouse -> wareHouseMapper.mapToWarehouseResponse(warehouse))
				.toList();

		return ResponseEntity.status(HttpStatus.FOUND)
				.body(new ResponseStructure<List<WarehouseResponse>>()
						.setData(warehouseResponse)
						.setMessage("Warehouse Found successfully")
						.setStatusCode(HttpStatus.FOUND.value()));
	}

	@Override
	public ResponseEntity<ResponseStructure<List<WarehouseResponse>>> findWarehousesByCity(
			WarehouseRequest warehouseRequest, String city) 
	{
		
		List<WarehouseResponse>  warehouseResponses= addressRepository.findAllByCity(city).stream().map(address->wareHouseMapper.mapToWarehouseResponse(address.getWarehouse(), address)).toList();

		if(warehouseResponses.isEmpty())
			throw new WarehouseNotFoundByCityException("Warehouse Not Found By City");
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(new ResponseStructure<List<WarehouseResponse>>()
					.setStatusCode(HttpStatus.FOUND.value())
						.setMessage("Warehouse Found By city")
						.setData(warehouseResponses));


	}
}



