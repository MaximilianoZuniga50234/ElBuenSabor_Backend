package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.controllers.BaseControllerImpl.BaseControllerImpl;
import com.example.elbuensaborbackend.models.entities.User;
import com.example.elbuensaborbackend.services.Implementation.UserServiceImpl;
import com.example.elbuensaborbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/user")
public class UserController extends BaseControllerImpl<User, UserServiceImpl> {

    @Autowired
    UserService userService;

    @GetMapping("/order")
    public ResponseEntity<?> getAllWithOrder() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getUsersDTOs());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createWithImage(@RequestPart("user") User user,
                                             @RequestPart(value = "image", required = false) Optional<MultipartFile> image) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.createWithImage(user, image));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateWithImage(@RequestPart("user") User user,
                                             @RequestPart(value = "image", required = false) Optional<MultipartFile> image,
                                             @PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.updateWithImage(user, image, id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }
}
