package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/send-email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("")
    public String sendEmail() {
        return emailService.sendEmail();
    }
}
