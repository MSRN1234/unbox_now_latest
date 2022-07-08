package com.unbox.serviceImp;

import java.util.Optional;

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
		Optional<Profile> profile1 =profileRepo.findByFull_name(profileRequestDTO.getFull_name());
		if(profile1==null) {
			Profile profile=new Profile();
//			profile.setUser_Id(profileRequestDTO.getUser_id());
			profile.setFull_name(profileRequestDTO.getFull_name());
			profile.setEmail(profileRequestDTO.getEmail());
			profile.setMobile_no(profileRequestDTO.getMobile_no());
			profile.setAddress_Line_1(profileRequestDTO.getAddress_Line_1());
			profile.setAddress_Line_2(profileRequestDTO.getAddress_Line_2());
			profile.setCity(profileRequestDTO.getCity());
			profile.setState(profileRequestDTO.getState());
			profile.setZipCode(profileRequestDTO.getZipCode());
			Profile profile2=profileRepo.save(profile);
			profileResponseDTO.setUser_profile_id(profile2.getUser_profile_id());
			profileResponseDTO.setFull_name(profile2.getFull_name());
			profileResponseDTO.setMessage("user details successfully added");
			
				return profileResponseDTO;
			}
		profileResponseDTO.setMessage("Already Exist Details");
		return profileResponseDTO;
	}
	

}
