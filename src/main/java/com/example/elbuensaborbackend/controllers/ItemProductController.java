package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.controllers.BaseControllerImpl.BaseControllerImpl;
import com.example.elbuensaborbackend.models.entities.ItemProduct;
import com.example.elbuensaborbackend.services.Implementation.ItemProductServiceImpl;
import com.example.elbuensaborbackend.services.ItemProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/itemProduct")
public class ItemProductController extends BaseControllerImpl<ItemProduct, ItemProductServiceImpl> {

    @Autowired
    ItemProductService itemProductService;

    @PostMapping("")
    //@PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> save(@RequestBody ItemProduct itemProduct) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.save(itemProduct));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

    @PutMapping("/{id}")
    //@PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> update(@RequestBody ItemProduct itemProduct, @PathVariable Long id) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(service.update(itemProduct, id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

    @DeleteMapping("/desactivate/{id}")
    public ResponseEntity<?> leave(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(itemProductService.leave(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }
}
