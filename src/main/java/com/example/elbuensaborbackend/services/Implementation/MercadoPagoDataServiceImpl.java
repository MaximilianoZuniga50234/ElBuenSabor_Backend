package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.models.entities.MercadoPagoData;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.MercadoPagoDataRepository;
import com.example.elbuensaborbackend.services.MercadoPagoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MercadoPagoDataServiceImpl extends BaseServiceImpl<MercadoPagoData, Long> implements MercadoPagoDataService {

    @Autowired
    private MercadoPagoDataRepository mercadoPagoDataRepository;

    public MercadoPagoDataServiceImpl(BaseRepository<MercadoPagoData, Long> mercadoPagoDataRepository) {
        super(mercadoPagoDataRepository);
    }

}
