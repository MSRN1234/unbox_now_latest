package com.unbox.service;

import com.unbox.RequestDTO.LoginRequestDTO;
import com.unbox.ResponseDTO.LoginResponseDTO;

public interface ILoginService {

	public LoginResponseDTO signUp(LoginRequestDTO loginRequestDTO);
	public LoginResponseDTO signIn(LoginRequestDTO loginRequestDTO);
}
