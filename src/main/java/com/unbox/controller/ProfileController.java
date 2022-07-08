package com.unbox.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unbox.RequestDTO.ProfileRequestDTO;
import com.unbox.ResponseDTO.ProfileResponseDTO;
import com.unbox.service.ProfileService;
@RestController
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@PostMapping("/userProfile")
	public ResponseEntity<?> userProfile( @RequestBody ProfileRequestDTO profileRequestDTO) {
		ProfileResponseDTO profileResponseDTO=profileService.userProfile(profileRequestDTO);
		Map<String,Object> map=new HashMap<String,Object>();
		if(profileResponseDTO.getUser_profile_id()!=null)
		   {
			   
			   map.put("msg","added successfully ");
			   map.put("data",profileResponseDTO);
			   map.put("status",true);
			   return ResponseEntity.status(HttpStatus.OK).body(map);
		   }	
		else {
			map.put("msg","invalid details");
			   map.put("data",profileResponseDTO);
			   map.put("status",false);
				return ResponseEntity.status(HttpStatus.OK).body(map);
					
		}
		   
	}

}
