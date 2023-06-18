package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.entities.MercadoPagoData;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.MercadoPagoDataRepository;
import com.example.elbuensaborbackend.services.MercadoPagoDataService;
import org.springframework.beans.factory.annotation.Autowired;

public class MercadoPagoDataServiceImpl extends BaseServiceImpl<MercadoPagoData, Long> implements MercadoPagoDataService {

    @Autowired
    private MercadoPagoDataRepository mercadoPagoDataRepository;

    public MercadoPagoDataServiceImpl(BaseRepository<MercadoPagoData, Long> mercadoPagoDataRepository) {
        super(mercadoPagoDataRepository);
    }

}
