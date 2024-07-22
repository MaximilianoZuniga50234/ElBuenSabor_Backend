package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.models.entities.MercadoPagoProduct;
import com.example.elbuensaborbackend.services.MercadoPagoService;
import com.mercadopago.resources.preference.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mp")
public class MercadoPagoController {

    @Autowired
    MercadoPagoService mercadoPagoService;

    @PostMapping("")
    public ResponseEntity<?> createPreference(@RequestBody MercadoPagoProduct mercadoPagoProduct) {
        try {
            Preference preference = mercadoPagoService.createPreference(mercadoPagoProduct);
            return ResponseEntity.status(HttpStatus.OK).body(preference);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevamente...\"}");


        }
    }


}
