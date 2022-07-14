package utils;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;




@Service
public class MailUtils {

	@Autowired
	private static Environment env;

	public static void send_CCC(String subject, String reciever, String body) {
        Properties properties = new Properties();
        properties.put("mail.smtp.port",env.getProperty("mail.smtp.port"));
        properties.put("mail.smtp.host",env.getProperty("mail.smtp.host"));
        properties.put("mail.smtp.auth",env.getProperty("mail.smtp.auth"));
        properties.put("mail.smtp.starttls.enable",env.getProperty("mail.smtp.starttls.enable"));
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(AppConstants.SENDER_EMAIL_ID, AppConstants.SENDER_EMAIL_PASSWORD);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(AppConstants.SENDER_EMAIL_ID));
            message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(reciever));
            message.setSubject(subject);
            message.setContent(body, "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
