package com.unbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.unbox.entity.UserLogin;
import com.unbox.repository.UserLoginRepository;
@Service
public class UserLoginService {

	@Autowired
	private UserLoginRepository userLoginRepo;
	
	
		
	public UserLogin findByName(String name) {
		return userLoginRepo.findByName(name);
		
	}
	
	public UserLogin save(UserLogin userLogin) {
   		return this.userLoginRepo.save(userLogin);
	}
}
