package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.models.entities.PurchaseOrder;
import com.example.elbuensaborbackend.services.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/send-email")
public class EmailController {
    
    @Autowired
    private EmailService emailService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("")
    public String sendEmail(@RequestParam("file")  MultipartFile file, @RequestParam("order") String order) {
        try {
            PurchaseOrder purchaseOrder = objectMapper.readValue(order, PurchaseOrder.class);
            emailService.sendEmail(file, purchaseOrder);
            return "Email enviado exitosamente";
        } catch (MessagingException | IOException e) {
            return "Error al enviar el email: " + e.getMessage();
        }
    }
}
