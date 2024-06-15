package com.example.warehouse.system.service;

import org.springframework.http.ResponseEntity;

import com.example.warehouse.system.requestdto.ClientRequest;
import com.example.warehouse.system.responsedto.ApiKeyResponse;
import com.example.warehouse.system.responsedto.ClientResponse;
import com.example.warehouse.system.utility.ResponseStructure;

public interface ClientService {

	ResponseEntity<ResponseStructure<ApiKeyResponse>> registerClient(ClientRequest clientRequest);

	ResponseEntity<ResponseStructure<ClientResponse>> registerClient(ClientRequest clientRequest, int clientId);

	

	

}
