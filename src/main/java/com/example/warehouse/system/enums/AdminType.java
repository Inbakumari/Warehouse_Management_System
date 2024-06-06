package com.example.warehouse.system.enums;

import java.util.List;

public enum AdminType {

	SUPER_ADMIN(List.of(Privilege.CREATE_ADMIN,Privilege.CREATE_WAREHOUSE)),
	ADMIN(List.of(Privilege.CREATE_STORAGE,Privilege.UPDATE_ADMIN));
	private List<Privilege> privileges;

	
	//CONSRUCTOR
	 AdminType(List<Privilege> privileges)
	{
		this.privileges=privileges;
	}
	 
	 //CONSRUCTOR ====>ACCESS THROUGH GET()

	public List<Privilege> getpPrivileges()
	{
		return this.privileges;
	}
}




