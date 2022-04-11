package com.prissoft.springemailclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringEmailClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailClientApplication.class, args);
	}

	@Autowired
	private EmailSenderService service;

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail()throws MessagingException{

		service.sendSimpleEmail("ramkrishna@prissoft.net",
				"Hello sir,I am feeling sick ,so request you to grant a holiday leave for me",
				"Application for Leave ");

	}
}
