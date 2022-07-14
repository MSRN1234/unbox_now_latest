package com.unbox.serviceImp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.unbox.RequestDTO.EmailRequestDTO;

@Service
public class ForgotPasswordService {
	private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;
	
	@Autowired
	private JavaMailSender javaMailSender;
	Map<String, String> cache = new HashMap<>();
	

	public Boolean sendOtpEmail(String email) throws MessagingException {

		String otp = generateOtp();

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setTo(email);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		helper.setSubject("OTP");
		String content = "<center><h1>Welcome </h1>"
				+ "<h4>Please use the otp for Reset your password</h4></center>" + "<center>"
				+ "\r\n"
				+ otp
				+ "</center>";
		cache.put(email, otp);
		message.setContent(content, "text/html; charset=utf-8");
		javaMailSender.send(message);
		return true;
	}
	public boolean verifyOtp(EmailRequestDTO EmailRequestDTO) {
		String oldOtp = cache.get(EmailRequestDTO.getEmail());
		if (oldOtp.equals(EmailRequestDTO.getReceivedOtp())) {
			// cache.remove(emailRcvOtp.getEmail());
 		return true;
		}
		else
			return false;
	}

	private String generateOtp() {
        Random r = new Random();
        Integer num = r.nextInt(9999);
        String otp = String.format("%04d", num);
        return otp;
    }
}