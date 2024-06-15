package com.example.warehouse.system.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.warehouse.system.entity.Admin;
import com.example.warehouse.system.enums.AdminType;
import com.example.warehouse.system.exception.AdminNotFoundByEmailException;
import com.example.warehouse.system.exception.AdminNotFoundByIdException;
import com.example.warehouse.system.exception.IllegalOperationException;
import com.example.warehouse.system.exception.WarehouseNotFoundByIdException;
import com.example.warehouse.system.mapper.AdminMapper;
import com.example.warehouse.system.repository.AdminRepository;
import com.example.warehouse.system.repository.WareHouseRepository;
import com.example.warehouse.system.requestdto.AdminRequest;
import com.example.warehouse.system.responsedto.AdminResponse;
import com.example.warehouse.system.service.AdminService;
import com.example.warehouse.system.utility.ResponseStructure;

import jakarta.validation.Valid;


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
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(AdminRequest adminRequest) {

		String email=SecurityContextHolder.getContext().getAuthentication().getName();
		return adminRepository.findByEmail(email).map(admin -> {
			admin = adminMapper.mapToAdmin(adminRequest, admin);
			admin = adminRepository.save(admin);

			return	ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseStructure<AdminResponse>()
							.setStatusCode(HttpStatus.OK.value())
							.setMessage("Admin Updated Successfully")
							.setData(adminMapper.mapToAdminResponse(admin)));	
		}).orElseThrow(()->new AdminNotFoundByEmailException("Admin Not Found"));


	}




	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdminBySuperAdmin(AdminRequest adminRequest,int adminId) {


		return adminRepository.findById(adminId).map(admin -> {

			admin = adminRepository.save(adminMapper.mapToAdmin(adminRequest, admin));

			return	ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseStructure<AdminResponse>()
							.setStatusCode(HttpStatus.OK.value())
							.setMessage("Admin Updated By Super Admin")
							.setData(adminMapper.mapToAdminResponse(admin)));	
		}).orElseThrow(()->new AdminNotFoundByIdException("Admin Not Found"));

	}


	@Override
	public ResponseEntity<ResponseStructure<List<AdminResponse>>> findAdmins(AdminType adminType) {
		//List<AdminResponse> adminResponse = adminRepository.findAllByAdminType(AdminType.ADMIN).stream()
                //.map(adminMapper::mapToAdminResponse)
                //.toList();

        return ResponseEntity.status(HttpStatus.FOUND)
                .body(new ResponseStructure<List<AdminResponse>>()
                      // .setData(adminResponse)
                        .setMessage("Found All Admins successfully")
                        .setStatusCode(HttpStatus.FOUND.value()));

	}


	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> findAdmin(int adminId) {
		// TODO Auto-generated method stub
		return null;
	}

}
