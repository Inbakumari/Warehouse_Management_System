package com.example.warehouse.system.security;

import org.springdoc.core.properties.SwaggerUiConfigProperties.Csrf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.warehouse.system.filters.ClientRequestFilter;
import com.example.warehouse.system.repository.ClientRepository;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SecurityConfig {
	
	@Autowired
	
	private ClientRepository clientRepository;
	


	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder(12);
	}
	

	@Bean
	@Order(2)
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{
		
		return httpSecurity.csrf(csrf -> csrf.disable())
				
				.securityMatchers(matcher -> matcher.requestMatchers("/api/v1/**","/login/**"))
				.authorizeHttpRequests(authorize -> authorize.requestMatchers("api/v1/register")
				.permitAll()
				.anyRequest().authenticated())
				.formLogin(Customizer.withDefaults())
				.build();
	}

	@Bean
	@Order(1)
	SecurityFilterChain clientRequestFilterChain(HttpSecurity httpSecurity) throws Exception
	{

		return httpSecurity.csrf(csrf -> csrf.disable())
				.securityMatchers(matcher -> matcher.requestMatchers("/api/v1/client/**"))
				.authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll())
				.sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(new ClientRequestFilter(clientRepository), UsernamePasswordAuthenticationFilter.class)
				.build();

	}



}

