package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.controllers.BaseControllerImpl.BaseControllerImpl;
import com.example.elbuensaborbackend.models.entities.PurchaseOrder;
import com.example.elbuensaborbackend.models.entities.PurchaseOrderDetail;
import com.example.elbuensaborbackend.services.Implementation.PurchaseOrderDetailServiceImpl;
import com.example.elbuensaborbackend.services.PurchaseOrderDetailService;
import com.example.elbuensaborbackend.services.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/purchaseOrderDetail")
public class PurchaseOrderDetailController extends BaseControllerImpl<PurchaseOrderDetail, PurchaseOrderDetailServiceImpl> {

    @Autowired
    PurchaseOrderDetailService purchaseOrderDetailService;

    @PostMapping("")
    //@PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> save(@RequestBody PurchaseOrderDetail purchaseOrderDetail) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.save(purchaseOrderDetail));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }
}
