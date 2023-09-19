package com.example.elbuensaborbackend.repositories;

import com.example.elbuensaborbackend.models.entities.Invoice;
import com.example.elbuensaborbackend.models.entities.Person;
import com.example.elbuensaborbackend.models.entities.PurchaseOrder;
import com.example.elbuensaborbackend.models.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends BaseRepository<Invoice, Long>{

    @Query("SELECT i FROM Invoice i WHERE i.purchaseOrder.user = :user")
    List<Invoice> invoicesByUser(@Param("user") User user);
}
