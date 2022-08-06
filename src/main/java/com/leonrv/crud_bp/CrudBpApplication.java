package com.leonrv.crud_bp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.leonrv.crud_bp.services.EmailSenderService;

@SpringBootApplication
public class CrudBpApplication {

	@Autowired
	private EmailSenderService senderService;
	public static void main(String[] args) {
		SpringApplication.run(CrudBpApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendMail(){
		senderService.sendEmail("leonriv2@gmail.com", "Prueba", "Hola esto es una prueba");
	}
}
