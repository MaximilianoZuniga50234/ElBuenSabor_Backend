package com.example.elbuensaborbackend.services;

import com.example.elbuensaborbackend.models.entities.PurchaseOrder;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(MultipartFile file, PurchaseOrder order) throws MessagingException, IOException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(order.getPerson().getEmail());
        helper.setSubject("Pedido N° " + order.getId() + " facturado");
        helper.setText("""
                Gracias por comprar en El Buen Sabor.
                Tu pedido fue facturado y está a punto de prepararse.
                ¡Esperamos que lo disfrutes!
                Adjuntamos la factura correspondiente.""");

        InputStreamSource attachment = new ByteArrayResource(file.getBytes());
        helper.addAttachment(file.getOriginalFilename(), attachment);
        mailSender.send(message);
    }
}