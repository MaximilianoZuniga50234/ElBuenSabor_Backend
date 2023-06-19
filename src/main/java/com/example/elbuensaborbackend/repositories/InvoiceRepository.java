package com.example.elbuensaborbackend.repositories;

import com.example.elbuensaborbackend.entities.Invoice;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends BaseRepository<Invoice, Long>{
}
