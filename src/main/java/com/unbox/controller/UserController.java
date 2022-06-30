package com.unbox.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unbox.entity.UserLogin;
import com.unbox.service.UserLoginService;

@RestController
public class UserController {

	@Autowired
	private UserLoginService userLoginService;
	
	@Autowired
    private BCryptPasswordEncoder bcrypt;
	
	@PostMapping("/signUp")
	public String save(@Valid @RequestBody UserLogin userLogin) {
		UserLogin userLogin1=userLoginService.findByName(userLogin.getUser_name());
	if(userLogin1==null) {
		userLogin.setPassword(bcrypt.encode(userLogin.getPassword()));
			userLoginService.save(userLogin);
			return "Registered successfully";
		}
		return " User Already Exist";
	}
	
	
	@GetMapping("/signIn")
	public String signIn(@RequestBody UserLogin userLogin) {
	 
		UserLogin userLogin1=userLoginService.findByName(userLogin.getUser_name());
		if(userLogin1!=null) {
			boolean password=  bcrypt.matches(userLogin.getPassword(), userLogin1.getPassword());
			if(userLogin1!=null && password==true ) {
				return "Login Successfully";
		     }
		
		}
		return "Invalid username or password";
				
	}
	
	// update the user profile
//	public ResponseEntity<?> updateUser(@RequestBody UserLogin userLogin, @PathVariable("user_id") Integer user_id)
//	{
//		Optional<UserLogin>
//	}
}
