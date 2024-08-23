package com.example.warehouse.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warehouse.system.requestdto.ClientRequest;
import com.example.warehouse.system.responsedto.ApiKeyResponse;
import com.example.warehouse.system.responsedto.ClientResponse;
import com.example.warehouse.system.responsedto.WarehouseResponse;
import com.example.warehouse.system.service.ClientService;
import com.example.warehouse.system.utility.ErrorStructure;
import com.example.warehouse.system.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/v1")
public class ClientController {
	
	@Autowired
	
	private ClientService clientService;
	
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Client created successfully",
							content= {
									@Content(schema = @Schema(oneOf=ClientResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})
	@PostMapping("/client/register")
	
	public ResponseEntity<ResponseStructure<ApiKeyResponse>> registerClient(@RequestBody ClientRequest clientRequest)
	{
		return clientService.registerClient(clientRequest);
	}
	
	@Operation(description="The endpoint is used to add the"
			+ " data to the data base",
			responses= {
					@ApiResponse(responseCode = "201", description="Updated created successfully",
							content= {
									@Content(schema = @Schema(oneOf=ClientResponse.class))
							}),
					@ApiResponse(responseCode="400", description="Invalid Input",
					content= {
							@Content(schema  =@Schema(oneOf  =ErrorStructure.class))
					})
			})
	
@PutMapping("/client/clients/{clientId}")
	
	public ResponseEntity<ResponseStructure<ClientResponse>> updateClientById(@RequestBody ClientRequest clientRequest, @PathVariable int clientId)
	{
		return clientService.registerClient(clientRequest, clientId);
	}


}
