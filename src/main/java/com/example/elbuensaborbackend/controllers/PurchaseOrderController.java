package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.controllers.BaseControllerImpl.BaseControllerImpl;
import com.example.elbuensaborbackend.models.entities.Person;
import com.example.elbuensaborbackend.models.entities.PurchaseOrder;
import com.example.elbuensaborbackend.services.Implementation.PurchaseOrderServiceImpl;
import com.example.elbuensaborbackend.services.PersonService;
import com.example.elbuensaborbackend.services.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/purchaseOrder")
public class PurchaseOrderController extends BaseControllerImpl<PurchaseOrder, PurchaseOrderServiceImpl> {

    @Autowired
    PurchaseOrderService purchaseOrderService;

    @PostMapping("")
    //@PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> save(@RequestBody PurchaseOrder purchaseOrder) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.save(purchaseOrder));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }
}
