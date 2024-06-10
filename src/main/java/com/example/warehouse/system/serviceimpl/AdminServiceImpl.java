package com.example.warehouse.system.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.IllegalQueryOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.warehouse.system.entity.Admin;
import com.example.warehouse.system.enums.AdminType;
import com.example.warehouse.system.enums.Privilege;
import com.example.warehouse.system.exception.IllegalOperationException;
import com.example.warehouse.system.mapper.AdminMapper;
import com.example.warehouse.system.repository.AdminRepository;
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

	

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> createSuperAdmin(AdminRequest adminRequest) {
		if(adminRepository.existsByAdminType(AdminType.SUPER_ADMIN))
			throw new IllegalOperationException("Illegal Operations occured in Super admin");
		Admin admin=adminMapper.mapToAdmin(adminRequest, new Admin());
		admin.setAdminType(AdminType.SUPER_ADMIN);
		
		admin=adminRepository.save(admin);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseStructure<AdminResponse>()
						.setStatusCode(HttpStatus.CREATED.value())
						.setMessage("Created Successfully")
						.setData(adminMapper.mapToAdminResponse(admin)));


	}



	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(AdminRequest adminRequest) {
		
		return null;
	}
	
}