package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.controllers.BaseControllerImpl.BaseControllerImpl;
import com.example.elbuensaborbackend.models.entities.Product;
import com.example.elbuensaborbackend.services.CloudinaryService;
import com.example.elbuensaborbackend.services.Implementation.ProductServiceImpl;
import com.example.elbuensaborbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/product")
public class ProductController extends BaseControllerImpl<Product, ProductServiceImpl> {

    @Autowired
    ProductService productService;

    @Autowired
    CloudinaryService cloudinaryService;

    @PostMapping("/create")
    public ResponseEntity<?> saveWithImage(@RequestPart("product") Product product,
                                           @RequestPart(value = "image", required = false) Optional<MultipartFile> image) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.saveWithImage(product, image));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateWithImage(@RequestPart("product") Product product,
                                             @RequestParam(value = "image", required = false) Optional<MultipartFile> image,
                                             @PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.updateWithImage(product, image, id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteWithImage(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productService.deleteWithImage(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

    @DeleteMapping("/desactivate/{id}")
    public ResponseEntity<?> leave(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productService.leave(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

    @GetMapping("/search/{denomination}")
    public ResponseEntity<?> findProductForDenomination(@PathVariable String denomination) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.findProductForDenomination(denomination));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

    @GetMapping("/search/cat/{category}")
    public ResponseEntity<?> findProductsByCategory(@PathVariable String category) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.findProductsByCategory(category));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

}
