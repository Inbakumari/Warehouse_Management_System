package com.example.warehouse.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.warehouse.system.requestdto.AdminRequest;
import com.example.warehouse.system.responsedto.AdminResponse;
import com.example.warehouse.system.service.AdminService;
import com.example.warehouse.system.utility.ErrorStructure;
import com.example.warehouse.system.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Controller
@RequestMapping("/api/v1")
@Tag(name="User Endpoints",description="Contains all the endpoints")
public class AdminController {
    
    @Autowired
    private AdminService adminService;

    
    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<AdminResponse>> createSuperAdmin(@RequestBody  AdminRequest adminRequest) {
        return adminService.createSuperAdmin(adminRequest);
    }
    @PostMapping("warehouses/{warehouseId}/admins")
    public ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(@RequestBody  AdminRequest adminRequest, @PathVariable int warehouseId) {
        return adminService.createAdmin(adminRequest, warehouseId);
    }
    
    
    
    
}
