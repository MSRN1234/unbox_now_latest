package com.unbox.service;

import com.unbox.RequestDTO.ProfileRequestDTO;
import com.unbox.ResponseDTO.ProfileResponseDTO;

public interface ProfileService{
	public ProfileResponseDTO userProfile(ProfileRequestDTO profileRequestDTO);

}
