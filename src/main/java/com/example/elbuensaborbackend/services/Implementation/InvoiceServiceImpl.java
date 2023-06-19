package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.entities.Invoice;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.InvoiceRepository;
import com.example.elbuensaborbackend.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl extends BaseServiceImpl<Invoice, Long> implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(BaseRepository<Invoice, Long> invoiceRepository) {
        super(invoiceRepository);
    }

}
