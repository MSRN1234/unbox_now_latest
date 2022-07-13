package com.unbox.serviceImp;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.unbox.RequestDTO.EmailRequestDTO;
import com.unbox.RequestDTO.LoginRequestDTO;
import com.unbox.ResponseDTO.LoginResponseDTO;
import com.unbox.entity.Profile;
import com.unbox.entity.UserLogin;
import com.unbox.repository.ProfileRepository;
import com.unbox.repository.UserLoginRepository;
import com.unbox.service.ILoginService;

@Service
public class LoginServiceImp implements ILoginService {

	@Autowired
	private UserLoginRepository userLoginRepo;

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	@Autowired
	private ForgotPasswordService forgotPasswordService;

	@Override
	public LoginResponseDTO signUp(LoginRequestDTO loginRequestDTO) {
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		UserLogin userLogin1 = userLoginRepo.findByName(loginRequestDTO.getUser_name());
		if (userLogin1 == null) {
			UserLogin userLogin = new UserLogin();
			userLogin.setSignup_with(loginRequestDTO.getSignup_with());
			userLogin.setPassword(bcrypt.encode(loginRequestDTO.getPassword()));
			userLogin.setUser_name(loginRequestDTO.getUser_name());
			userLogin.setValidated(false);
			userLogin.setUser_type_id(loginRequestDTO.getUser_type_id());
			UserLogin userLogin2 = userLoginRepo.save(userLogin);

			Profile profile = new Profile();
			profile.setUser_Id(userLogin2.getUser_id());
			profile.setFull_name(loginRequestDTO.getFull_name());
			if (loginRequestDTO.getSignup_with().equals("email")) {
				profile.setEmail(userLogin2.getUser_name());
			} else {
				profile.setMobile_no(userLogin2.getUser_name());
			}
			Profile profile1 = profileRepository.save(profile);

			loginResponseDTO.setId(profile1.getUser_profile_id());
			loginResponseDTO.setId(userLogin2.getUser_id());
			loginResponseDTO.setRole(userLogin2.getUser_type_id() == 1 ? "Corporate" : "Individual");
			loginResponseDTO.setMessage("email sent successfully");
			return loginResponseDTO;
		}

		loginResponseDTO.setMessage("Already Exist");
		return loginResponseDTO;
	}

	@Override
	public LoginResponseDTO signIn(LoginRequestDTO loginRequestDTO) {
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		UserLogin userLogin1 = userLoginRepo.findByName(loginRequestDTO.getUser_name());
		if (userLogin1 != null) {
			boolean password = bcrypt.matches(loginRequestDTO.getPassword(), userLogin1.getPassword());
			if (userLogin1 != null && password == true) {
				loginResponseDTO.setId(userLogin1.getUser_id());
				loginResponseDTO.setRole(userLogin1.getUser_type_id() == 1 ? "Corporate" : "Individual");
				loginResponseDTO.setMessage("signin Successfully");
				return loginResponseDTO;
			}

		}
		loginResponseDTO.setMessage("Incorrect Username password");
		return loginResponseDTO;

	}

	@Override
	public String forgotPassword( String email) throws MessagingException {
		UserLogin userLogin1 = userLoginRepo.findByName(email);
		if (userLogin1 != null) {
			Boolean b = forgotPasswordService.sendOtpEmail(userLogin1.getUser_name());
			if (b) {
				return "OTP sent";
			}
		}
		return "email id not present";
		
	}

	@Override
	public String verifyOtp(EmailRequestDTO emailRequestDTO) {
		boolean b = forgotPasswordService.verifyOtp(emailRequestDTO);
		if (b) {
			return "correct otp";
		} 
	   		return "incorrect otp";
	}

	@Override
	public String resetPassword(LoginRequestDTO loginRequestDTO,String email) {
		UserLogin userLogin1 = userLoginRepo.findByName(email);
		userLogin1.setPassword(bcrypt.encode(loginRequestDTO.getPassword()));
		this.userLoginRepo.save(userLogin1);
		return "password updated";
		
	}

}
