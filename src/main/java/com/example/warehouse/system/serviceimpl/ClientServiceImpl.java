package com.example.warehouse.system.serviceimpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.warehouse.system.entity.Client;
import com.example.warehouse.system.mapper.ClientMapper;
import com.example.warehouse.system.repository.ClientRepository;
import com.example.warehouse.system.requestdto.ClientRequest;
import com.example.warehouse.system.responsedto.ApiKeyResponse;
import com.example.warehouse.system.responsedto.ClientResponse;
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





}
