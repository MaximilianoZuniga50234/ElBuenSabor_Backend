package com.example.elbuensaborbackend.services;

import com.resend.*;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.SendEmailRequest;
import com.resend.services.emails.model.SendEmailResponse;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    Resend resend = new Resend("re_Zx2obbtt_NiTMjon7AK6jDZNkTjQLtrBJ");

    public String sendEmail() {

        SendEmailRequest sendEmailRequest = SendEmailRequest.builder()
                .from("El Buen Sabor <onboarding@resend.dev>")
                .to("lautyjofre1@gmail.com")
                .subject("Pago realizado correctamente")
                .html("""
                        <h2>Gracias por comprar en 'El Buen Sabor'</h2>
                        <h3>Tu pago ha sido realizado correctamente y tu pedido esta a punto de prepararse.</h3>
                        <h3>¡Esperamos que lo disfrutes!</h3>
                        <h4>Puedes descargar la factura correspondiente en la página web accediendo a 'Mis órdenes > Detalles > Factura'.</h4>
                        """)
                .build();
        try {
            SendEmailResponse data = resend.emails().send(sendEmailRequest);
            return data.getId();
        } catch (ResendException e) {
            e.printStackTrace();
            return null;
        }
    }
}