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
				   		+ "\r\n"
				   		+ "<head>\r\n"
				   		+ "    <meta charset=\"UTF-8\">\r\n"
				   		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				   		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				   		+ "    <title>Document</title>\r\n"
				   		+ "    <style>\r\n"
				   		+ "        @media only screen and (min-width:360px) and (max-width:500px) {\r\n"
				   		+ "            .frame {\r\n"
				   		+ "                background-position: unset !important;\r\n"
				   		+ "                height: 76vh;\r\n"
				   		+ "                font-size: 13px !important;\r\n"
				   		+ "            }\r\n"
				   		+ "\r\n"
				   		+ "            .thank-text {\r\n"
				   		+ "                padding-top: 0px !important;\r\n"
				   		+ "            }\r\n"
				   		+ "\r\n"
				   		+ "            .thank-text h3 {\r\n"
				   		+ "                padding-top: 110px !important;\r\n"
				   		+ "                font-size: x-small !important;\r\n"
				   		+ "                font-weight: normal !important;\r\n"
				   		+ "            }\r\n"
				   		+ "\r\n"
				   		+ "            .frame .logo img {\r\n"
				   		+ "                width: 154px !important;\r\n"
				   		+ "                margin-top: 0px !important;\r\n"
				   		+ "            }\r\n"
				   		+ "\r\n"
				   		+ "            .logo-text h3 {\r\n"
				   		+ "                margin-top: 0px !important;\r\n"
				   		+ "                width: 250px;\r\n"
				   		+ "                font-size: 11px !important;\r\n"
				   		+ "                font-weight: normal !important;\r\n"
				   		+ "\r\n"
				   		+ "            }\r\n"
				   		+ "\r\n"
				   		+ "            .explore-button {\r\n"
				   		+ "                margin-top: -8px !important;\r\n"
				   		+ "            }\r\n"
				   		+ "\r\n"
				   		+ "            .explore-button a button {\r\n"
				   		+ "                border-radius: 6px !important;\r\n"
				   		+ "                font-size: xx-small !important;\r\n"
				   		+ "                padding-top: 6px !important;\r\n"
				   		+ "                padding-bottom: 6px !important;\r\n"
				   		+ "                padding-left: 24px !important;\r\n"
				   		+ "                padding-right: 21px !important;\r\n"
				   		+ "                font-weight: bold !important;\r\n"
				   		+ "            }\r\n"
				   		+ "\r\n"
				   		+ "            .explore-text {\r\n"
				   		+ "                margin-top: 11px !important;\r\n"
				   		+ "                padding-bottom: 14px !important;\r\n"
				   		+ "            }\r\n"
				   		+ "\r\n"
				   		+ "            .explore-text h4 {\r\n"
				   		+ "                margin: 0 auto;\r\n"
				   		+ "                width: 250px;\r\n"
				   		+ "                font-size: 10px !important;\r\n"
				   		+ "                font-weight: normal !important;\r\n"
				   		+ "            }\r\n"
				   		+ "\r\n"
				   		+ "            .enuire-button a button {\r\n"
				   		+ "                border-radius: 6px !important;\r\n"
				   		+ "                font-size: xx-small !important;\r\n"
				   		+ "                padding-top: 6px !important;\r\n"
				   		+ "                padding-bottom: 6px !important;\r\n"
				   		+ "                padding-left: 24px !important;\r\n"
				   		+ "                padding-right: 21px !important;\r\n"
				   		+ "                font-weight: bold !important;\r\n"
				   		+ "            }\r\n"
				   		+ "\r\n"
				   		+ "            .enuire-text {\r\n"
				   		+ "                margin-top: 11px !important;\r\n"
				   		+ "            }\r\n"
				   		+ "\r\n"
				   		+ "            .enuire-text h2 {\r\n"
				   		+ "                margin: 0 auto;\r\n"
				   		+ "                width: 250px;\r\n"
				   		+ "                font-size: 13px !important;\r\n"
				   		+ "                font-size: xx-small !important;\r\n"
				   		+ "                font-weight: normal !important;\r\n"
				   		+ "\r\n"
				   		+ "\r\n"
				   		+ "\r\n"
				   		+ "            }\r\n"
				   		+ "\r\n"
				   		+ "            .follow {\r\n"
				   		+ "                margin-top: -7px !important;\r\n"
				   		+ "\r\n"
				   		+ "            }\r\n"
				   		+ "\r\n"
				   		+ "            .follow h5 {\r\n"
				   		+ "                font-weight: normal !important;\r\n"
				   		+ "            }\r\n"
				   		+ "\r\n"
				   		+ "            .social-flex {\r\n"
				   		+ "                padding-top: 0px !important;\r\n"
				   		+ "            }\r\n"
				   		+ "\r\n"
				   		+ "            .social-flex a img {\r\n"
				   		+ "                width: 19px !important;\r\n"
				   		+ "\r\n"
				   		+ "            }\r\n"
				   		+ "        }\r\n"
				   		+ "    </style>\r\n"
				   		+ "</head>\r\n"
				   		+ "\r\n"
				   		+ "<body class=\" bg\" style=\"text-align:center;\">\r\n"
				   		+ "    <div class=\"frame\"\r\n"
				   		+ "        style=\"background-image:url('https://unboxnow1.s3.ap-south-1.amazonaws.com/Image/Template_Welcome+Email.png'); background-size: contain;background-repeat: no-repeat;background-position: center\">\r\n"
				   		+ "        <div class=\"thank-text\" style=\"text-align:center;padding-top: 192px; \">\r\n"
				   		+ "            <h3 style=\"color:black; \">Thank you for signing up with</h3>\r\n"
				   		+ "        </div>\r\n"
				   		+ "\r\n"
				   		+ "        <div class=\"logo\">\r\n"
				   		+ "            <img src=\"https://unboxnow1.s3.ap-south-1.amazonaws.com/landingPage/Logo.png\" alt=\"unboxLogo\"\r\n"
				   		+ "                style=\"width:208px;\">\r\n"
				   		+ "        </div>\r\n"
				   		+ "        <div class=\"logo-text\">\r\n"
				   		+ "            <h3 style=\"max-width: 440px;color:black; margin: 0 auto;margin-top: 20px;padding-bottom: 20px;font-size: unset;\"> You\r\n"
				   		+ "                are a few steps\r\n"
				   		+ "                away from gifting an unboxing experience\r\n"
				   		+ "                to your important people!\r\n"
				   		+ "            </h3>\r\n"
				   		+ "            <div class=\"explore-button\">\r\n"
				   		+ "                <a href=\"http://13.232.97.200/\"> <button\r\n"
				   		+ "                        style=\"background-color:#225779 ;color:white;border-radius: 9px;font-size: medium;padding-top: 8px;padding-bottom: 8px;padding-left: 46px;padding-right: 36px;border: none;font-weight: 800;\">EXPLORE\r\n"
				   		+ "                        NOW</button></a>\r\n"
				   		+ "            </div>\r\n"
				   		+ "            <div class=\"explore-text\" style=\"max-width: 440px; margin: 0 auto;margin-top: 20px;padding-bottom: 20px;\">\r\n"
				   		+ "                <h4 style=\"font-size:unset;color:black;\"> Don't worry if you are too confused with all the requirements! Let\r\n"
				   		+ "                    us kmow\r\n"
				   		+ "                    your requirements, we will curate the right hamper for you</h3>\r\n"
				   		+ "            </div>\r\n"
				   		+ "            <div class=\"enuire-button\">\r\n"
				   		+ "                <a href=\"http://13.232.97.200/enquire\"> <button\r\n"
				   		+ "                        style=\"background-color:#57CC98;color:white; border-radius: 9px;font-size: medium;padding-top: 8px;padding-bottom: 8px;padding-left: 46px;padding-right: 36px;border: none;font-weight: 800;\">ENQUIRE\r\n"
				   		+ "                        NOW</button></a>\r\n"
				   		+ "            </div>\r\n"
				   		+ "\r\n"
				   		+ "            <div class=\"enuire-text\"\r\n"
				   		+ "                style=\"max-width: 440px;margin: 0 auto;font-size: small;margin-top: 20px;margin-bottom: 20px;\">\r\n"
				   		+ "                <h2 style=\"color:black;\"> Looking forward to be your unboxing partner!</h2>\r\n"
				   		+ "            </div>\r\n"
				   		+ "            <div class=\"follow\">\r\n"
				   		+ "                <h5 style=\"color:black;\"> Follow us on</h4>\r\n"
				   		+ "            </div>\r\n"
				   		+ "\r\n"
				   		+ "           \r\n"
				   		+ "            <div style=\"padding-bottom: 120px;\" >\r\n"
				   		+ "                <ul style=\"list-style-type:none; padding: 0px;\">\r\n"
				   		+ "                    <li style=\"display: inline;\"> <a href=\"https://www.linkedin.com/company/unboxnow/\"><img\r\n"
				   		+ "                                src=\"https://unboxnow1.s3.ap-south-1.amazonaws.com/Image/linkedin.png\"\r\n"
				   		+ "                                alt=\"linkedin\" /></a></li>\r\n"
				   		+ "                    <li style=\"display: inline;\"> <a href=\"https://instagram.com/unboxnow.in?igshid=YmMyMTA2M2Y=\"> <img\r\n"
				   		+ "                                src=\"https://unboxnow1.s3.ap-south-1.amazonaws.com/Image/instagram.png\"\r\n"
				   		+ "                                alt=\"instagram\" /></a></li>\r\n"
				   		+ "                    <li style=\"display: inline;\"><a href=\"https://www.facebook.com/UnboxNow-100763145981590\"><img\r\n"
				   		+ "                                src=\"https://unboxnow1.s3.ap-south-1.amazonaws.com/Image/facebook.png\" alt=\"facebook\"\r\n"
				   		+ "                                style=\"border-radius: 5px;\" /></a></li>\r\n"
				   		+ "                    <li style=\"display: inline;\"> <a href=\"https://www.youtube.com/channel/UCaV2oUq2PlnuW75XmUMx04A/company/unboxnow/\"><img\r\n"
				   		+ "                                src=\"https://unboxnow1.s3.ap-south-1.amazonaws.com/Image/youtube+(3).png\" alt=\"youtube\"\r\n"
				   		+ "                                style=\" width: 33px;\" /></a></li>\r\n"
				   		+ "                </ul>\r\n"
				   		+ "            </div>\r\n"
				   		+ "        </div>\r\n"
				   		+ "    </div>\r\n"
				   		+ "</body>\r\n"
				   		+ "\r\n"
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
