package com.email.send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMail {

	@Autowired
	private JavaMailSender mailSender;
	

	
	public void sendMail(String toEmail,
						 String subject,
						 String body) {
		
		SimpleMailMessage message=new SimpleMailMessage();
		
		// enter your email address
		message.setFrom("yourEmail");
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);
		
		mailSender.send(message);
		
		System.out.println("Mail Send successfully");
		
	}
	
}
