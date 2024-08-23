package com.example.warehouse.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warehouse.system.enums.AdminType;
import com.example.warehouse.system.requestdto.AdminRequest;
import com.example.warehouse.system.responsedto.AdminResponse;
import com.example.warehouse.system.service.AdminService;
import com.example.warehouse.system.utility.ErrorStructure;
import com.example.warehouse.system.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController  
@RequestMapping("/api/v1")
@Tag(name="Admin Endpoints",description="Contains all the endpoints")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Operation(description="The endpoint is used to add the"		
	+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Super Admin created successfully",
							content= {
									@Content(schema = @Schema(oneOf=AdminResponse.class))
						}),
				@ApiResponse(responseCode="400", description="Invalid Input",
				content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})
	
	
	

	@PostMapping("/register")  
	public ResponseEntity<ResponseStructure<AdminResponse>>createSuperAdmin(@RequestBody AdminRequest adminRequest){
		return adminService.createSuperAdmin(adminRequest);
	}
	
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Admin created successfully",
							content= {
									@Content(schema = @Schema(oneOf=AdminResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})

	@PostMapping("/warehouses/{wareHouseId}/admins") 
	public ResponseEntity<ResponseStructure<AdminResponse>>	createAdmin(@RequestBody @Valid AdminRequest adminRequest,@PathVariable int wareHouseId){
		return  adminService.createAdmin(adminRequest,wareHouseId);
	}
	
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description=" Updated Admin successfully",
							content= {
									@Content(schema = @Schema(oneOf=AdminResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})

	@PutMapping("/admins")

	public ResponseEntity<ResponseStructure<AdminResponse>>	updateAdmin(@RequestBody @Valid AdminRequest adminRequest){
		return  adminService.updateAdmin(adminRequest);
	}
	
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Admin Updated By The Super Admin successfully",
							content= {
									@Content(schema = @Schema(oneOf=AdminResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})


	@PutMapping("/admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdminBySuperAdmin(@RequestBody @Valid AdminRequest adminRequest,@PathVariable int adminId ) {
	    return adminService.updateAdminBySuperAdmin(adminRequest,adminId);
	}
	
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Admin Found successfully",
							content= {
									@Content(schema = @Schema(oneOf=AdminResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})
	
	@GetMapping("/admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> findAdmin(@PathVariable int adminId) {
	    return adminService.findAdmin(adminId);
	}
	
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Found All Admins successfully",
							content= {
									@Content(schema = @Schema(oneOf=AdminResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})
	

	@GetMapping("/admins")
	public ResponseEntity<ResponseStructure<List<AdminResponse>>> findAdmins(AdminType adminType) {
	    return adminService.findAdmins(adminType);
	}

}
