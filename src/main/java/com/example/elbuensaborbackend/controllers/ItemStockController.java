package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.controllers.BaseControllerImpl.BaseControllerImpl;
import com.example.elbuensaborbackend.models.entities.ItemStock;
import com.example.elbuensaborbackend.services.Implementation.ItemStockServiceImpl;
import com.example.elbuensaborbackend.services.ItemStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/itemStock")
public class ItemStockController extends BaseControllerImpl<ItemStock, ItemStockServiceImpl> {

    @Autowired
    ItemStockService itemStockService;

    @PostMapping("")
//    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> save(@RequestBody ItemStock itemStock) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.save(itemStock));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> update(@RequestBody ItemStock itemStock, @PathVariable Long id) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(service.update(itemStock, id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }


    @DeleteMapping("/desactivate/{id}")
    public ResponseEntity<?> leave(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(itemStockService.leave(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

}
