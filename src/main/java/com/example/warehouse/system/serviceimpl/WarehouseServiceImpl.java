package com.example.warehouse.system.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.warehouse.system.entity.WareHouse;
import com.example.warehouse.system.mapper.WareHouseMapper;
import com.example.warehouse.system.repository.WareHouseRepository;
import com.example.warehouse.system.responsedto.WareHouseResponse;
import com.example.warehouse.system.mapper.WareHouseMapper;
import com.example.warehouse.system.service.WareHouseService;
import com.example.warehouse.system.utility.ResponseStructure;

@Service
public class WareHouseServiceImpl implements WareHouseService{

	
	@Autowired
	private WareHouseRepository wareHouseRepository;
	
	@Autowired
	private WareHouseMapper wareHouseMapper;
	
	

	@Override
	public ResponseEntity<ResponseStructure<WareHouseResponse>> createWarehouse(WareHouse wareHouseRequest) {

		
		WareHouse warehouse= wareHouseRepository.save(wareHouseMapper.mapToWareHouse(wareHouseRequest,new WareHouse()));
        wareHouseRepository.save(warehouse);
        
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new ResponseStructure<WareHouseResponse>()
                .setStatusCode(HttpStatus.CREATED.value())
                .setMessage("Warehouse created")
                .setData(wareHouseMapper.mapToWareHouseResponse(warehouse)));	
		
		}



}