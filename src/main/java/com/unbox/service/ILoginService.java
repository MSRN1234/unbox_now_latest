package com.unbox.service;

import javax.mail.MessagingException;

import com.unbox.RequestDTO.EmailRequestDTO;
import com.unbox.RequestDTO.LoginRequestDTO;
import com.unbox.ResponseDTO.LoginResponseDTO;
import com.unbox.entity.CorporateProfile;
import com.unbox.entity.Profile;

public interface ILoginService {

	public LoginResponseDTO signUp(LoginRequestDTO loginRequestDTO);
	public LoginResponseDTO signIn(LoginRequestDTO loginRequestDTO);
	public String verifyOtp(EmailRequestDTO emailRequestDTO);
	public String resetPassword(LoginRequestDTO loginRequestDTO,String email);
	public String forgotPassword(String email) throws MessagingException;
    public Profile getIndividualProfile(Integer Id);
    public CorporateProfile getCorporateProfile(Integer Id);
	
}
