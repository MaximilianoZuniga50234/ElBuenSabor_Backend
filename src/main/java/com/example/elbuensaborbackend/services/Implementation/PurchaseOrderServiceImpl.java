package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.models.entities.PurchaseOrder;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.PurchaseOrderRepository;
import com.example.elbuensaborbackend.services.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderServiceImpl extends BaseServiceImpl<PurchaseOrder, Long> implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrderServiceImpl(BaseRepository<PurchaseOrder, Long> purchaseOrderRepository) {
        super(purchaseOrderRepository);
    }

}
