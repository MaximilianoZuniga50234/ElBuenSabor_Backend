package com.example.elbuensaborbackend.repositories;

import com.example.elbuensaborbackend.entities.PurchaseOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends BaseRepository<PurchaseOrder, Long>{
}
