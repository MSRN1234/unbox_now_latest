package com.unbox.service;

import com.unbox.entity.EmailDetails;

public interface EmailService {
 
	String sendSimpleMail(EmailDetails details);
	}
