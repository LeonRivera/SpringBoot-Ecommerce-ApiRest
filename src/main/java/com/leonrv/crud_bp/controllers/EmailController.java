package com.leonrv.crud_bp.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.leonrv.crud_bp.services.EmailSenderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import com.leonrv.crud_bp.models.*;
import com.leonrv.crud_bp.repositories.*;



@RestController
@RequestMapping("api/v1/services/email")
@CrossOrigin("*")
public class EmailController {

    @Autowired
    EmailSenderService emailSenderService;

    @GetMapping
    public ResponseEntity<?> getMethodName(@RequestParam String email) {
        String registerCode = Double.toString(Math.random() * 1000000).substring(0,6);
        emailSenderService.sendEmail(email, "Codigo de registro", "Codigo de registro generado: "+ registerCode);
        return new ResponseEntity<String>(registerCode, HttpStatus.OK);
    }
    
    
}
