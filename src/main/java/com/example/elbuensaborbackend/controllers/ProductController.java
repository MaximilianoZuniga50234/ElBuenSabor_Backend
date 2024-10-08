package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.controllers.BaseControllerImpl.BaseControllerImpl;
import com.example.elbuensaborbackend.models.entities.Product;
import com.example.elbuensaborbackend.services.Implementation.CloudinaryServiceImpl;
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
    CloudinaryServiceImpl cloudinaryService;

    /*@GetMapping("/all")
    public ResponseEntity<?> getAll(@RequestParam(required = false) String name,
                                    @RequestParam(required = false) String order,
                                    @RequestParam(required = false) String category,
                                    @RequestParam(required = false) String min,
                                    @RequestParam(required = false) String max) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.findAll(name, order, category, min, max));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }*/

    @GetMapping("/all/sale")
    public ResponseEntity<?> getAllSale() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.findAllSale());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

    @GetMapping("/all/featured")
    public ResponseEntity<?> getAllFeatured() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.findAllFeatured());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveWithImage(@RequestPart("product") String product,
                                           @RequestPart(value = "image", required = false) Optional<MultipartFile> image) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.saveWithImage(product, image));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateWithImage(@RequestParam("product") String product,
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

    @PatchMapping("/desactivate/{id}")
    public ResponseEntity<?> leave(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.leave(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }
}
