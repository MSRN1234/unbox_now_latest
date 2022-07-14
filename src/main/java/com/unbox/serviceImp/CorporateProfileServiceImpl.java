package com.unbox.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbox.RequestDTO.CorporateProfileRequestDTO;
import com.unbox.ResponseDTO.CorporateProfileResponseDTO;
import com.unbox.entity.CorporateProfile;
import com.unbox.repository.CorporateProfileRepository;
import com.unbox.service.CorporateProfileService;

@Service
public class CorporateProfileServiceImpl implements CorporateProfileService{
	
	@Autowired
	private CorporateProfileRepository corporateProfileRepo;

	@Override
	public CorporateProfileResponseDTO corporateUserProfile(CorporateProfileRequestDTO corporateProfileRequestDTO) {
		CorporateProfileResponseDTO corporateProfileResponseDTO=new CorporateProfileResponseDTO();
		CorporateProfile corporateProfile =corporateProfileRepo.findByUser_Id(corporateProfileRequestDTO.getUser_Id());
		if(corporateProfile!=null) {
		   corporateProfile.setBusiness_name(corporateProfileRequestDTO.getBusiness_name());
		   corporateProfile.setWebsite(corporateProfileRequestDTO.getWebsite());
		   corporateProfile.setPoint_of_contact(corporateProfileRequestDTO.getPoint_of_contact());
		   corporateProfile.setBusiness_email(corporateProfileRequestDTO.getBusiness_email());
		   corporateProfile.setMobile_no(corporateProfileRequestDTO.getMobile_no());
		   corporateProfile.setGst_no(corporateProfileRequestDTO.getGst_no());
		   corporateProfile.setPan_no(corporateProfileRequestDTO.getPan_no());

		    CorporateProfile corporateProfile2=corporateProfileRepo.save(corporateProfile);
		    corporateProfileResponseDTO.setCorporate_id(corporateProfile2.getCorporate_id());
		    corporateProfileResponseDTO.setUser_Id(corporateProfile2.getUser_Id());
		    corporateProfileResponseDTO.setBusiness_name(corporateProfile2.getBusiness_name());
		    corporateProfileResponseDTO.setMessage(" Corporate user details successfully added");
			
			}
	
		return corporateProfileResponseDTO;
	}
}
