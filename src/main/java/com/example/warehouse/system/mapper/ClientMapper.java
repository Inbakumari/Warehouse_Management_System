package com.example.warehouse.system.mapper;

import org.springframework.stereotype.Component;

import com.example.warehouse.system.entity.Client;
import com.example.warehouse.system.requestdto.ClientRequest;
import com.example.warehouse.system.responsedto.ApiKeyResponse;
import com.example.warehouse.system.responsedto.ClientResponse;


@Component
public class ClientMapper
{

	public Client mapToClient(ClientRequest clientRequest, Client client)
	{
		client.setBusinessName(clientRequest.getBusinessName());
		client.setEmail(clientRequest.getEmail());
		client.setContactNumber(clientRequest.getContactNumber());
		return client;
	}

	public ApiKeyResponse mapToApiKey(Client client)

	{

		return ApiKeyResponse.builder()
				.apikey(client.getApiKey())
				.message("Created Successfully ")
				.build();

	}

	public ClientResponse mapClientResponse(Client client)
	{
		return ClientResponse.builder()
				.clientId(client.getClientId())
				.businessName(client.getBusinessName())
				.email(client.getEmail())
				.contactNumber(client.getContactNumber())
				.build();
	}

}
