package com.example.elbuensaborbackend.services;

import com.example.elbuensaborbackend.models.entities.MercadoPagoProduct;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.*;
import com.mercadopago.resources.preference.Preference;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MercadoPagoService {

    @PostConstruct
    public void initMPConfig() {
        MercadoPagoConfig.setAccessToken("TEST-8665333237373017-020618-0bc5a8932c7632a0326e8fc69e69ab1d-1670260025");
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
                .success("el-buen-sabor-front-end.vercel.app")
                .failure("https://youtube.com")
                .pending("https://youtube.com")
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
