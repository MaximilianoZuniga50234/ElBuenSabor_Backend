package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.models.entities.MercadoPagoProduct;
import com.example.elbuensaborbackend.services.MercadoPagoService;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.*;
import com.mercadopago.resources.preference.Preference;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MercadoPagoServiceImpl implements MercadoPagoService {

    @PostConstruct
    public void initMPConfig() {
        MercadoPagoConfig.setAccessToken("APP_USR-8665333237373017-020618-bb08753bb414539da971acaf95f5582b-1670260025");
    }

    public Preference createPreference(MercadoPagoProduct mercadoPagoProduct) throws Exception {

        PreferenceItemRequest itemRequest =
                PreferenceItemRequest
                        .builder()
                        .title(mercadoPagoProduct.getTitle())
                        .quantity(mercadoPagoProduct.getQuantity())
                        .unitPrice(new BigDecimal(mercadoPagoProduct.getPrice()))
                        .currencyId("ARS")
                        .build();

        List<PreferenceItemRequest> items = new ArrayList<>();
        items.add(itemRequest);

        PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest
                .builder()
                .success("http://localhost:5173/u/success")
                .failure("http://localhost:5173/u/failure")
                .pending("http://localhost:5173/u/pending")
                .build();

        PreferenceRequest preferenceRequest = PreferenceRequest
                .builder()
                .items(items)
                .autoReturn("approved")
                .backUrls(backUrls)
                .build();

        PreferenceClient client = new PreferenceClient();

        Preference preference = client.create(preferenceRequest);

        System.out.println("Preference: " + preference.getId());

        return preference;
    }
}
