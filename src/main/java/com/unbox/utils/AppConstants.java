package utils;

import java.util.Properties;

public interface AppConstants {

	Properties properties = new Properties();
	String DEFAULT_PAGE_NUMBER = "0";
	String DEFAULT_PAGE_SIZE = "30";
	String SENDER_EMAIL_ID = properties.getProperty("spring.mail.username");
	String SENDER_EMAIL_PASSWORD = properties.getProperty("spring.mail.password");
	int MAX_PAGE_SIZE = 50;

}
