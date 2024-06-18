package com.example.warehouse.system.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.warehouse.system.entity.Client;
import com.example.warehouse.system.exception.BadCredentialsException;
import com.example.warehouse.system.exception.IllegalOperationException;
import com.example.warehouse.system.exception.UserNameNotFoundException;
import com.example.warehouse.system.repository.ClientRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClientRequestFilter extends OncePerRequestFilter {

	private ClientRepository clientRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if(request.getSession(false)!=null)
		{
			throw new IllegalOperationException("Illegal Operation");
		}
		
		if(!request.getRequestURI().equals("/api/v1/client/register"))
		{

		String apiKey = request.getHeader("API-KEY");
		String username = request.getHeader("USERNAME");

		if (apiKey != null && username != null) {
			Client client = clientRepository.findByEmail(username)
					.orElseThrow(() -> new UserNameNotFoundException("User not Found"));

			if (!apiKey.equals(client.getApiKey())) {
				throw new BadCredentialsException("Invalid Credentials");
			}
		} else {
			throw new UserNameNotFoundException("User not found");
		}
		}

		filterChain.doFilter(request, response);
	}
}
