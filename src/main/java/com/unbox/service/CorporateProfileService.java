package com.unbox.service;

import com.unbox.RequestDTO.CorporateProfileRequestDTO;
import com.unbox.ResponseDTO.CorporateProfileResponseDTO;

public interface CorporateProfileService  {

	public CorporateProfileResponseDTO corporateUserProfile(CorporateProfileRequestDTO corporateProfileRequestDTO);
}
