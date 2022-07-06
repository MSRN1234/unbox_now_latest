package com.unbox.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unbox.RequestDTO.LoginRequestDTO;
import com.unbox.ResponseDTO.LoginResponseDTO;
import com.unbox.entity.EmailDetails;
import com.unbox.service.EmailService;
import com.unbox.service.ILoginService;

@RestController
public class UserController {

	@Autowired
	private ILoginService loginService;
	@Autowired
	private EmailService emailService;

	@PostMapping("/signUp")
	public ResponseEntity<?> signUp(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
		LoginResponseDTO loginResponseDTO=loginService.signUp(loginRequestDTO);
		Map<String,Object> map=new HashMap<String,Object>();
		   if(loginResponseDTO.getId()!=null)
			   {
			   if(loginRequestDTO.getUser_name().contains("@")) {
				   EmailDetails emailDetails =new EmailDetails();
				   emailDetails.setMsgBody("Hey!congratulations ,you are successfully signup and welcome to the unbox" );
				   emailDetails.setRecipient(loginRequestDTO.getUser_name());
				   emailDetails.setSubject("welcome to unbox");
				   String status= emailService.sendSimpleMail(emailDetails);
			   }
			  
			   map.put("msg","signUp successfull ");
			   map.put("data",loginResponseDTO);
			   map.put("status",true);
				return ResponseEntity.status(HttpStatus.OK).body(map);
		   }	
		   map.put("msg","signUp Failed");
		   map.put("data",loginResponseDTO);
		   map.put("status",false);
			return ResponseEntity.status(HttpStatus.OK).body(map);
		
	}
	
	
	@PostMapping("/signIn")
	public ResponseEntity<?> signIn(@RequestBody LoginRequestDTO loginRequestDTO) {
		LoginResponseDTO loginResponseDTO=loginService.signIn(loginRequestDTO);
		Map<String,Object> map=new HashMap<String,Object>();
		   if(loginResponseDTO.getId()!=null)
		   {
			   
			   map.put("msg","signIn successfull ");
			   map.put("data",loginResponseDTO);
			   map.put("status",true);
			   return ResponseEntity.status(HttpStatus.OK).body(map);
		   }	
		   map.put("msg","Bad Credentials");
		   map.put("data",loginResponseDTO);
		   map.put("status",false);
			return ResponseEntity.status(HttpStatus.OK).body(map);
				
	}
	
	// email sending controller
	@PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails details) {
		String status= emailService.sendSimpleMail(details);
		 return status;
        
	}
    
}
