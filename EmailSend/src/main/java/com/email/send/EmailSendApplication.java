package com.email.send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailSendApplication {

	@Autowired
	private SendMail email;
	
	public static void main(String[] args) {
		SpringApplication.run(EmailSendApplication.class, args);
	
		
	}
	
	

}
