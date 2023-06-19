package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.entities.PurchaseOrderDetail;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.PurchaseOrderDetailRepository;
import com.example.elbuensaborbackend.services.PurchaseOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderDetailServiceImpl extends BaseServiceImpl<PurchaseOrderDetail, Long> implements PurchaseOrderDetailService {

    @Autowired
    private PurchaseOrderDetailRepository purchaseOrderDetailRepository;

    public PurchaseOrderDetailServiceImpl(BaseRepository<PurchaseOrderDetail, Long> purchaseOrderDetailRepository) {
        super(purchaseOrderDetailRepository);
    }

}
