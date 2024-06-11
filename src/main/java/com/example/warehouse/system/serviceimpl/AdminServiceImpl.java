package com.example.warehouse.system.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.IllegalQueryOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.warehouse.system.entity.Admin;
import com.example.warehouse.system.entity.WareHouse;
import com.example.warehouse.system.enums.AdminType;
import com.example.warehouse.system.enums.Privilege;
import com.example.warehouse.system.exception.IllegalOperationException;
import com.example.warehouse.system.exception.WarehouseNotFoundByIdException;
import com.example.warehouse.system.mapper.AdminMapper;
import com.example.warehouse.system.repository.AdminRepository;
import com.example.warehouse.system.repository.WareHouseRepository;
import com.example.warehouse.system.requestdto.AdminRequest;
import com.example.warehouse.system.responsedto.AdminResponse;
import com.example.warehouse.system.service.AdminService;
import com.example.warehouse.system.utility.ResponseStructure;


@Service
public class AdminServiceImpl implements AdminService {


	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private AdminMapper adminMapper;

	@Autowired
	private WareHouseRepository wareHouseRepository;

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> createSuperAdmin(AdminRequest adminRequest) {
		if( adminRepository.existsByAdminType(AdminType.SUPER_ADMIN))
		{
			

			throw new IllegalOperationException("The SuperAdmin Already Exists,cannot add another SuperAdmin");
		}
		else {
			Admin admin = adminRepository.save(adminMapper.mapToAdmin(adminRequest, new Admin()));					
			admin.setAdminType(AdminType.SUPER_ADMIN);
			admin=adminRepository.save(admin);
			return	ResponseEntity.status(HttpStatus.CREATED)
					.body(new ResponseStructure<AdminResponse>()
							.setStatusCode(HttpStatus.CREATED.value())
							.setMessage("Super Admin Created")
							.setData(adminMapper.mapToAdminResponse(admin)));
		}

	}


	public ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(AdminRequest adminRequest,int wareHouseId) {
		
		return	wareHouseRepository.findById(wareHouseId)
				.map(warehouse->{


					Admin admin = adminMapper.mapToAdmin(adminRequest, new Admin());
					admin.setAdminType(AdminType.ADMIN);
					admin=adminRepository.save(admin);

					warehouse.setAdmin(admin);
					wareHouseRepository.save(warehouse);

					return	ResponseEntity.status(HttpStatus.CREATED)
							.body(new ResponseStructure<AdminResponse>()
									.setStatusCode(HttpStatus.CREATED.value())
									.setMessage("Admin Created")
									.setData(adminMapper.mapToAdminResponse(admin)));	
				}).orElseThrow(()->new WarehouseNotFoundByIdException("WareHouse of this id not found")	 );


	}

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(AdminRequest adminRequest, int adminId) {
		
		adminRepository.existsById(adminId);
	}
}
