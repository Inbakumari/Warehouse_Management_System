package com.example.warehouse.system.serviceimpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.warehouse.system.entity.Client;
import com.example.warehouse.system.entity.Warehouse;
import com.example.warehouse.system.exception.ClientNotFoundByIdException;
import com.example.warehouse.system.exception.WarehouseNotFoundByNameException;
import com.example.warehouse.system.mapper.ClientMapper;
import com.example.warehouse.system.repository.ClientRepository;
import com.example.warehouse.system.requestdto.ClientRequest;
import com.example.warehouse.system.responsedto.ApiKeyResponse;
import com.example.warehouse.system.responsedto.ClientResponse;
import com.example.warehouse.system.responsedto.WarehouseResponse;
import com.example.warehouse.system.service.ClientService;
import com.example.warehouse.system.service.ClientService;
import com.example.warehouse.system.utility.ResponseStructure;
import lombok.AllArgsConstructor;


@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ClientMapper clientMapper;


	public ResponseEntity<ResponseStructure<ApiKeyResponse>> registerClient(ClientRequest clientRequest)
	{


		Client client= clientRepository.save(clientMapper.mapToClient(clientRequest, new Client()));
		String apiKey=UUID.randomUUID().toString();
		client.setApiKey(apiKey);
		clientRepository.save(client);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseStructure<ApiKeyResponse>()
						.setStatusCode(HttpStatus.CREATED.value())
						.setMessage("Created Successfully")
						.setData(clientMapper.mapToApiKey(client)));

	}


	@Override
	public ResponseEntity<ResponseStructure<ClientResponse>> registerClient(ClientRequest clientRequest, int clientId) {
		
		return clientRepository.findById(clientId).map(existingClient -> {
			Client updatedClient = clientMapper.mapToClient(clientRequest, existingClient);
			updatedClient = clientRepository.save(updatedClient);
			ClientResponse clientResponse = clientMapper.mapClientResponse(existingClient);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseStructure<ClientResponse>()
							.setStatusCode(HttpStatus.OK.value())
							.setMessage("Client Updated Successfully")
							.setData(clientResponse));
		}).orElseThrow(() -> new ClientNotFoundByIdException("Client Not Found"));
		
		
		
	}


	
	}





