package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.controllers.BaseControllerImpl.BaseControllerImpl;
import com.example.elbuensaborbackend.models.entities.Stock;
import com.example.elbuensaborbackend.services.Implementation.CloudinaryServiceImpl;
import com.example.elbuensaborbackend.services.Implementation.StockServiceImpl;
import com.example.elbuensaborbackend.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/stock")
public class StockController extends BaseControllerImpl<Stock, StockServiceImpl> {

    @Autowired
    StockService stockService;

    @Autowired
    CloudinaryServiceImpl cloudinaryService;
    @GetMapping("/ingredients")
    //@PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> getIngredients() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(stockService.getOnlyIngredients());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

    @GetMapping("/not_ingredients")
    public ResponseEntity<?> getNotIngredients() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(stockService.getNotIngredients());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

    @PostMapping("")
    //@PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> save(@RequestBody Stock stock) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(stockService.save(stock));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

    @PutMapping("/{id}")
    //@PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> update(@RequestBody Stock stock, @PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(stockService.update(stock, id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveWithImage(@RequestPart("stock") String stock,
                                           @RequestPart(value = "image", required = false) Optional<MultipartFile> image) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(stockService.saveWithImage(stock, image));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateWithImage(@RequestParam("stock") String stock,
                                             @RequestParam(value = "image", required = false) Optional<MultipartFile> image,
                                             @PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(stockService.updateWithImage(stock, image, id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }


    @DeleteMapping("/desactivate/{id}")
    public ResponseEntity<?> leave(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(stockService.leave(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }
}
