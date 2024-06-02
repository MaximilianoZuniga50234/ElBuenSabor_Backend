package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.services.Implementation.CloudinaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/cloudinary")
@CrossOrigin
public class CloudinaryController {

    @Autowired
    CloudinaryServiceImpl cloudinaryService;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("image") MultipartFile multipartFile){
        try {
            Map result = cloudinaryService.upload(multipartFile);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        try {
            Map result = cloudinaryService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
