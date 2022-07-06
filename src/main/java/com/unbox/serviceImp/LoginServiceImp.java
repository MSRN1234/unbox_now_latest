package com.unbox.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unbox.RequestDTO.LoginRequestDTO;
import com.unbox.ResponseDTO.LoginResponseDTO;
import com.unbox.entity.UserLogin;
import com.unbox.repository.UserLoginRepository;
import com.unbox.service.ILoginService;

@Service
public class LoginServiceImp implements ILoginService {

	@Autowired
	private UserLoginRepository userLoginRepo;
	
	@Autowired
    private BCryptPasswordEncoder bcrypt;
	
	
	
	
	@Override
	public LoginResponseDTO signUp(LoginRequestDTO loginRequestDTO){
		LoginResponseDTO loginResponseDTO=new LoginResponseDTO();
		UserLogin userLogin1=userLoginRepo.findByName(loginRequestDTO.getUser_name());
		if(userLogin1==null) {
			UserLogin userLogin=new UserLogin();
			userLogin.setSignup_with(loginRequestDTO.getSignup_with());
			userLogin.setPassword(bcrypt.encode(loginRequestDTO.getPassword()));
			userLogin.setUser_name(loginRequestDTO.getUser_name());
			userLogin.setFull_name(loginRequestDTO.getFull_name());
			userLogin.setValidated(false);
			userLogin.setUser_type_id(loginRequestDTO.getUser_type_id());
			UserLogin userLogin2=userLoginRepo.save(userLogin);
			loginResponseDTO.setId(userLogin2.getUser_id());
			loginResponseDTO.setRole(userLogin2.getUser_type_id()==1?"Corporate":"Individual");
			loginResponseDTO.setMessage("email sent successfully");
			
				return loginResponseDTO;
			}
		
		loginResponseDTO.setMessage("Already Exist");
		return loginResponseDTO;
	}

	@Override
	public LoginResponseDTO signIn(LoginRequestDTO loginRequestDTO){
		LoginResponseDTO loginResponseDTO=new LoginResponseDTO();
		UserLogin userLogin1=userLoginRepo.findByName(loginRequestDTO.getUser_name());
		if(userLogin1!=null) {
			boolean password=  bcrypt.matches(loginRequestDTO.getPassword(), userLogin1.getPassword());
			if(userLogin1!=null && password==true ) {
				loginResponseDTO.setId(userLogin1.getUser_id());
				loginResponseDTO.setRole(userLogin1.getUser_type_id()==1?"Corporate":"Individual");
				loginResponseDTO.setMessage("signin Successfully");
				return loginResponseDTO;
		     }
		
		}
		loginResponseDTO.setMessage("Incorrect Username password");
		return loginResponseDTO;
				
	
	}

}
