package com.example.warehouse.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warehouse.system.requestdto.ClientRequest;
import com.example.warehouse.system.responsedto.ApiKeyResponse;
import com.example.warehouse.system.service.ClientService;
import com.example.warehouse.system.utility.ResponseStructure;

@RestController
@RequestMapping("/api/v1")
public class ClientController {
	
	@Autowired
	
	private ClientService clientService;
	
	
	@PostMapping("/clients")
	
	public ResponseEntity<ResponseStructure<ApiKeyResponse>> registerClient(@RequestBody ClientRequest clientRequest)
	{
		return clientService.registerClient(clientRequest);
	}
	
	

}
