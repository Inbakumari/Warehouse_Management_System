package com.example.warehouse.system.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.warehouse.system.entity.Warehouse;
import com.example.warehouse.system.mapper.WareHouseMapper;
import com.example.warehouse.system.repository.WareHouseRepository;
import com.example.warehouse.system.requestdto.WarehouseRequest;
import com.example.warehouse.system.responsedto.WarehouseResponse;
import com.example.warehouse.system.service.WarehouseService;
import com.example.warehouse.system.utility.ResponseStructure;

@Service
public class WarehouseServiceImpl implements WarehouseService{

	
	@Autowired
	private WareHouseRepository wareHouseRepository;
	
	@Autowired
	private WareHouseMapper wareHouseMapper;
	
	

	@Override
	public ResponseEntity<ResponseStructure<WarehouseResponse>> createWarehouse(WarehouseRequest wareHouseRequest) {

		
		Warehouse warehouse= wareHouseRepository.save(wareHouseMapper.mapToWareHouse(wareHouseRequest,new Warehouse()));
        wareHouseRepository.save(warehouse);
        
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new ResponseStructure<WarehouseResponse>()
                .setStatusCode(HttpStatus.CREATED.value())
                .setMessage("Warehouse created")
                .setData(wareHouseMapper.mapToWareHouseResponse(warehouse)));	
		
		}



}