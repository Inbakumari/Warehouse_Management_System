package com.example.warehouse.system.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.warehouse.system.repository.AdminRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	
	private AdminRepository adminRepository;
	
	
	//username==>email
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
//		return adminRepository.findByEmail(username)
//		.map(admin -> new UserDetailmpl(admin))
//		.orElseThrow(() -> new UsernameNotFoundException("Invalid Credentails"));
		
		
		//using method reference operator
		
		return adminRepository.findByEmail(username)
				.map(UserDetailmpl :: new)
				.orElseThrow(() -> new UsernameNotFoundException("Invalid Credentails"));
		
		
	}

}
