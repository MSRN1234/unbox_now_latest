package com.unbox.service;

import com.unbox.RequestDTO.ProfileRequestDTO;
import com.unbox.ResponseDTO.ProfileResponseDTO;
import com.unbox.entity.Profile;

public interface ProfileService{
	public ProfileResponseDTO userProfile(ProfileRequestDTO profileRequestDTO);

	public Profile getProfile(Integer id );
	
}
