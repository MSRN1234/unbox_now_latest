package com.unbox.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unbox.RequestDTO.LoginRequestDTO;
import com.unbox.ResponseDTO.LoginResponseDTO;
import com.unbox.entity.EmailDetails;
import com.unbox.service.EmailService;
import com.unbox.service.ILoginService;

@RestController
public class UserController {

	@Autowired
	private ILoginService loginService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private JavaMailSender javaMailSender;

	@PostMapping("/signUp")
	public ResponseEntity<?> signUp(@Valid @RequestBody LoginRequestDTO loginRequestDTO) throws MessagingException {
		LoginResponseDTO loginResponseDTO=loginService.signUp(loginRequestDTO);
		Map<String,Object> map=new HashMap<String,Object>();
		   if(loginResponseDTO.getId()!=null)
			   {
			   if(loginRequestDTO.getUser_name().contains("@")) {
				   EmailDetails emailDetails =new EmailDetails();
				   javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
				   MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
				   String html= "<!DOCTYPE html>\r\n"
				   		+ "<html lang=\"en\">\r\n"
				   		+ "<head>\r\n"
				   		+ "<meta charset=\"UTF-8\">\r\n"
				   		+ "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				   		+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				   		+ "<title>Document</title>\r\n"
				   		+ "</head>\r\n"
				   		+ "<body style=\"text-align: center\">\r\n"
				   		+ "	<div\r\n"
				   		+ "		style=\"background-image: url('https://unboxnow1.s3.ap-south-1.amazonaws.com/Image/Template_Welcome+Email.png'); background-size: contain; background-repeat: no-repeat; background-position: center;\">\r\n"
				   		+ "		<div style=\"text-align: center; padding-top: 192px;\">\r\n"
				   		+ "			<h3 style=\"color: black;\">Thank you for signing up with</h3>\r\n"
				   		+ "		</div>\r\n"
				   		+ "		<div>\r\n"
				   		+ "			<img\r\n"
				   		+ "				src=\"https://unboxnow1.s3.ap-south-1.amazonaws.com/landingPage/Logo.png\"\r\n"
				   		+ "				alt=\"unboxLogo\" style=\"width: 208px; margin: top 200px;\">\r\n"
				   		+ "		</div>\r\n"
				   		+ "		<div>\r\n"
				   		+ "			<h3\r\n"
				   		+ "				style=\"max-width: 440px; color:black ;margin: 0 auto; margin-top: 20px; padding-bottom: 20px; font-size: unset;\">\r\n"
				   		+ "				You are a few steps away from gifting an unboxing experience to your\r\n"
				   		+ "				important people!</h3>\r\n"
				   		+ "			<div>\r\n"
				   		+ "				<a href=\"http://13.232.97.200/\">\r\n"
				   		+ "					<button\r\n"
				   		+ "						style=\"background-color: #225779; color: white; border-radius: 9px; font-size: medium; padding-top: 8px; padding-bottom: 8px; padding-left: 46px; padding-right: 36px; border: none; font-weight: 800;\">EXPLORE\r\n"
				   		+ "						NOW</button>\r\n"
				   		+ "				</a>\r\n"
				   		+ "				<div>\r\n"
				   		+ "\r\n"
				   		+ "					<div\r\n"
				   		+ "						style=\"max-width: 440px; margin: 0 auto; margin-top: 20px; padding-bottom: 20px;\">\r\n"
				   		+ "						<h3 style=\"font-size: unset;color:black\">Don't worry if you are too\r\n"
				   		+ "							confused with all the requirements! Let us kmow your\r\n"
				   		+ "							requirements, we will curate the right hamper for you</h3>\r\n"
				   		+ "					</div>\r\n"
				   		+ "					<a href=\"http://13.232.97.200/enquire\">\r\n"
				   		+ "						<button\r\n"
				   		+ "							style=\"background-color: #57CC98; color: white; border-radius: 9px; font-size: medium; padding-top: 8px; padding-bottom: 8px; padding-left: 46px; padding-right: 36px; border: none; font-weight: 800;\">ENQUIRE\r\n"
				   		+ "							NOW</button>\r\n"
				   		+ "					</a>\r\n"
				   		+ "				</div>\r\n"
				   		+ "				<div\r\n"
				   		+ "					style=\"max-width: 440px; margin: 0 auto; font-size: small; margin-top: 20px; margin-bottom: 20px;\">\r\n"
				   		+ "					<h2 style=\"font-size: unset;color:black\">Looking forward to be your unboxing partner!</h2>\r\n"
				   		+ "				</div>\r\n"
				   		+ "				<div>\r\n"
				   		+ "					<h4 style=\"font-size: unset;color:black\">Follow us on</h4>\r\n"
				   		+ "				</div>\r\n"
				   		+ "				<div\r\n"
				   		+ "					style=\"display: flex; padding-top: 18px; padding-bottom: 172px; margin-left:30.1re;justify-content: center;\">\r\n"
				   		+ "					<div>\r\n"
				   		+ "						<a href=\"https://www.linkedin.com/company/unboxnow/\"><img\r\n"
				   		+ "							src=\"https://unboxnow1.s3.ap-south-1.amazonaws.com/Image/linkedin.png\"\r\n"
				   		+ "							alt=\"linkedin\" /></a>\r\n"
				   		+ "					</div>\r\n"
				   		+ "					<div>\r\n"
				   		+ "						<a href=\"https://instagram.com/unboxnow.in?igshid=YmMyMTA2M2Y=\">\r\n"
				   		+ "							<img\r\n"
				   		+ "							src=\"https://unboxnow1.s3.ap-south-1.amazonaws.com/Image/instagram.png\"\r\n"
				   		+ "							alt=\"instagram\" style=\"margin-left:10px\"/>\r\n"
				   		+ "						</a>\r\n"
				   		+ "					</div>\r\n"
				   		+ "					<div>\r\n"
				   		+ "						<a href=\"https://www.facebook.com/UnboxNow-100763145981590\"><img\r\n"
				   		+ "							src=\"https://unboxnow1.s3.ap-south-1.amazonaws.com/Image/facebook.png\"\r\n"
				   		+ "							alt=\"facebook\" style=\"border-radius: 5px;padding-left: 10px;padding-right: 10px\" /></a>\r\n"
				   		+ "					</div>\r\n"
				   		+ "					<div>\r\n"
				   		+ "						<a href=\"https://www.youtube.com/channel/UCaV2oUq2PlnuW75XmUMx04A\"><img\r\n"
				   		+ "							src=\"https://unboxnow1.s3.ap-south-1.amazonaws.com/Image/youtube+(3).png\"\r\n"
				   		+ "							alt=\"youtube\" style=\"width: 33px;\" /></a>\r\n"
				   		+ "					</div>\r\n"
				   		+ "				</div>\r\n"
				   		+ "				<div>\r\n"
				   		+ "					<div></div>\r\n"
				   		+ "				</div>\r\n"
				   		
				   		+ "			</div>\r\n"
				   		+ "		</div>\r\n"
				   		+ "	</div>\r\n"
				   		+ "</body>\r\n"
				   		+ "</html>";
				   
				   helper.setText(html, true);
//				   helper.setRecipient(loginRequestDTO.getUser_name());
				   helper.setTo(loginRequestDTO.getUser_name());
				   helper.setSubject("Welcome to UNBOX now!");
				   javaMailSender.send(mimeMessage);
//				   emailDetails.setAttachment("http://13.232.97.200/");
//				   String status= emailService.sendSimpleMail(emailDetails);
			   }
			  
			   map.put("msg","signUp successfull ");
			   map.put("data",loginResponseDTO);
			   map.put("status",true);
				return ResponseEntity.status(HttpStatus.OK).body(map);
		   }	
		   map.put("msg","signUp Failed");
		   map.put("data",loginResponseDTO);
		   map.put("status",false);  
			return ResponseEntity.status(HttpStatus.OK).body(map);
		
	}
	
	@PostMapping("/signIn")
	public ResponseEntity<?> signIn(@RequestBody LoginRequestDTO loginRequestDTO) {
		LoginResponseDTO loginResponseDTO=loginService.signIn(loginRequestDTO);
		Map<String,Object> map=new HashMap<String,Object>();
		   if(loginResponseDTO.getId()!=null)
		   {
			   
			   map.put("msg","signIn successfull ");
			   map.put("data",loginResponseDTO);
			   map.put("status",true);
			   return ResponseEntity.status(HttpStatus.OK).body(map);
		   }	
		   map.put("msg","Bad Credentials");
		   map.put("data",loginResponseDTO);
		   map.put("status",false);
			return ResponseEntity.status(HttpStatus.OK).body(map);
				
	}
	
	// email sending controller
	@PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails details) {
		String status= emailService.sendSimpleMail(details);
		 return status;
      	}
    
}
