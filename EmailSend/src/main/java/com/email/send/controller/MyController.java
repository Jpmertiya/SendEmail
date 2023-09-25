package com.email.send.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.email.send.Message;
import com.email.send.SendMail;

import jakarta.servlet.http.HttpSession;

@Controller
@Component
public class MyController {

	@Autowired
	private SendMail email;
	
	@GetMapping("/home")
	public String home() {
		
		return "home";
	}
	
	@PostMapping("/do-send")
	public String sendMail(@RequestParam("email") String mailId,@RequestParam("subject") String subject,@RequestParam("body") String body
						,HttpSession session) {
		System.out.println("inside do send ");
		
			try {
				email.sendMail(mailId, subject, body);
				session.setAttribute("message", new Message("Email Send", "alert-success"));
				
				
			} catch (Exception e) {
				session.setAttribute("message", new Message("Invalid Email Address", "alert-danger"));
				
			}finally {
				return "home";
			}
	}
	
}
