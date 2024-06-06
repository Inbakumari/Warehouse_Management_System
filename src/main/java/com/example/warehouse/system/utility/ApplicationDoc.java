package com.example.warehouse.system.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;



@Configuration
@OpenAPIDefinition

public class ApplicationDoc {

	@Bean

	public OpenAPI openAPI() {
		return new OpenAPI().info(new Info()
				.title("Warehouse_Management_System")
				.version("v1")
				.description("Spring boot Project built using **RESTFULL** Architecture "
						+ " covers all the basic CRUD Operation\n"
						+ "`public class ApplicationDoc`\n"
						+" ## Features:\n"
						+" - Covers all CRUD Operations\n"
						+" - Performed Field valiadation\n"
						+" - Used DTOs to control  inbound and outbound data"));
	}





}
