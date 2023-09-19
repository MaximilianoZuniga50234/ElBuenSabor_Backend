package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.controllers.BaseControllerImpl.BaseControllerImpl;
import com.example.elbuensaborbackend.models.entities.User;
import com.example.elbuensaborbackend.services.Implementation.UserServiceImpl;
import com.example.elbuensaborbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/user")
public class UserController extends BaseControllerImpl<User, UserServiceImpl> {

    @Autowired
    UserService userService;
    @GetMapping("/order")
    public ResponseEntity<?> getAllWithOrder(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getUsersDTOs());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }
}
