package com.example.elbuensaborbackend.services;

import com.example.elbuensaborbackend.models.entities.PurchaseOrder;
import jakarta.mail.MessagingException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EmailService {
    void sendEmail(MultipartFile file, PurchaseOrder order) throws MessagingException, IOException;
}
