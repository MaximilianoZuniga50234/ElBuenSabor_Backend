package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.entities.InvoiceDetail;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.InvoiceDetailRepository;
import com.example.elbuensaborbackend.services.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceDetailServiceImpl extends BaseServiceImpl<InvoiceDetail, Long> implements InvoiceDetailService {

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceDetailServiceImpl(BaseRepository<InvoiceDetail, Long> invoiceDetailRepository) {
        super(invoiceDetailRepository);
    }

}
