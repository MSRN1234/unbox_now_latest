package com.unbox.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbox.RequestDTO.ProfileRequestDTO;
import com.unbox.ResponseDTO.ProfileResponseDTO;
import com.unbox.entity.Profile;
import com.unbox.repository.ProfileRepository;
import com.unbox.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{
	
	@Autowired
	 private ProfileRepository profileRepo;
	

	@Override
	public ProfileResponseDTO userProfile(ProfileRequestDTO profileRequestDTO) {
		ProfileResponseDTO profileResponseDTO=new ProfileResponseDTO();
		Profile profile =profileRepo.findByUser_Id(profileRequestDTO.getUser_id());
		if(profile!=null) {
		    if(profile.getFull_name()==null) profile.setFull_name(profileRequestDTO.getFull_name());
		    if(profile.getEmail()==null)profile.setEmail(profileRequestDTO.getEmail());
		    if(profile.getMobile_no()==null)profile.setMobile_no(profileRequestDTO.getMobile_no());
		    if(profile.getAddress_Line_1()==null)profile.setAddress_Line_1(profileRequestDTO.getAddress_Line_1());
		    if(profile.getAddress_Line_2()==null)profile.setAddress_Line_2(profileRequestDTO.getAddress_Line_2());
		    if(profile.getCity()==null)profile.setCity(profileRequestDTO.getCity());
		    if(profile.getState()==null)profile.setState(profileRequestDTO.getState());
		    if(profile.getZipCode()==null)profile.setZipCode(profileRequestDTO.getZipCode());
			Profile profile2=profileRepo.save(profile);
			profileResponseDTO.setUser_profile_id(profile2.getUser_profile_id());
			profileResponseDTO.setUser_Id(profile2.getUser_id());
			profileResponseDTO.setFull_name(profile2.getFull_name());
			profileResponseDTO.setMessage("user details successfully added");
			
			}
	
		return profileResponseDTO;
	}




}
