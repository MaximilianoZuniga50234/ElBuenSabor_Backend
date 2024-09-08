package com.example.elbuensaborbackend.services;

import com.example.elbuensaborbackend.models.entities.MercadoPagoProduct;
import com.mercadopago.resources.preference.Preference;
import org.springframework.stereotype.Service;


@Service
public interface MercadoPagoService {
    Preference createPreference(MercadoPagoProduct mercadoPagoProduct) throws Exception;
}
