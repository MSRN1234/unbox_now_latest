package com.unbox.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unbox.RequestDTO.CorporateProfileRequestDTO;
import com.unbox.RequestDTO.ProfileRequestDTO;
import com.unbox.ResponseDTO.CorporateProfileResponseDTO;
import com.unbox.ResponseDTO.ProfileResponseDTO;
import com.unbox.entity.Profile;
import com.unbox.repository.ProfileRepository;
import com.unbox.service.CorporateProfileService;
import com.unbox.service.ProfileService;
@RestController
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private CorporateProfileService corporateProfileService;
	
	@Autowired
   private 	ProfileRepository  profileRepository;
   
	@PatchMapping("/userProfile")
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
	
	//corporate user profile api
	@PatchMapping("/corporateProfile")
	public ResponseEntity<?> corporateUserProfile( @RequestBody CorporateProfileRequestDTO corporateProfileRequestDTO) {
		CorporateProfileResponseDTO corporateProfileResponseDTO=corporateProfileService.corporateUserProfile(corporateProfileRequestDTO);
		Map<String,Object> map=new HashMap<String,Object>();
		if(corporateProfileResponseDTO.getCorporate_id()!=null)
		   {
			   
			   map.put("msg","added successfully ");
			   map.put("data",corporateProfileResponseDTO);
			   map.put("status",true);
			   return ResponseEntity.status(HttpStatus.OK).body(map);
		   }	
		else {
			map.put("msg","invalid details");
			   map.put("data",corporateProfileResponseDTO);
			   map.put("status",false);
				return ResponseEntity.status(HttpStatus.OK).body(map);
					
		}
		   
	}

	// update the user profile
	@PutMapping("/user/{user_id}")
	public ResponseEntity<?> updateUser(@RequestBody ProfileRequestDTO profileRequestDTO,@PathVariable("user_id") Integer user_id) 
	{
		
	Optional<Profile> profile=	profileRepository.findById(user_id);
		
		Map<String,Object> map=new HashMap<String,Object>();

		if(profile.isPresent())
		   {
			
			   Profile  newProfile = profile.get();
			   newProfile.setFull_name(profileRequestDTO.getFull_name());
			   newProfile.setMobile_no(profileRequestDTO.getMobile_no());
			   newProfile.setEmail(profileRequestDTO.getEmail());
			   newProfile.setAddress_Line_1(profileRequestDTO.getAddress_Line_1());
			   newProfile.setAddress_Line_2(profileRequestDTO.getAddress_Line_2());
			   newProfile.setCity(profileRequestDTO.getCity());
			   newProfile.setState(profileRequestDTO.getState());
			   newProfile.setZipCode(profileRequestDTO.getZipCode());
			   profileRepository.save(newProfile);

			   map.put("msg"," Data updated successfully for user " +  user_id);
			  // map.put("data",profileResponseDTO);
			   map.put("status",true);
			   return ResponseEntity.status(HttpStatus.OK).body(map);
		   }	
		else  {
			map.put("msg","user id is not exist");
			   //map.put("data",profileResponseDTO);
			   map.put("status",false);
				return ResponseEntity.status(HttpStatus.OK).body(map);
				
		}
		   
	} 
	
}
