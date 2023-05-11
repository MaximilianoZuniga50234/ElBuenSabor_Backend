package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.entities.MeasurementUnit;
import com.example.elbuensaborbackend.services.Implementation.MeasurementUnitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/measurementUnits")
public class MeasurementUnitController {

    @Autowired
    private MeasurementUnitServiceImpl measurementUnitServiceImpl;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(measurementUnitServiceImpl.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error... Intente denuevo mas tarde\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(measurementUnitServiceImpl.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error... Intente denuevo mas tarde\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody MeasurementUnit measurementUnit){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(measurementUnitServiceImpl.save(measurementUnit));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error... Intente denuevo mas tarde\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id ,@RequestBody MeasurementUnit measurementUnit){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(measurementUnitServiceImpl.update(measurementUnit, id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error... Intente denuevo mas tarde\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(measurementUnitServiceImpl.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error... Intente denuevo mas tarde\"}");
        }
    }
}
