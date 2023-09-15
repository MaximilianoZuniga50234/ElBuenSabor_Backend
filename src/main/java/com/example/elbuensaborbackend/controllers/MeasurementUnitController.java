package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.controllers.BaseControllerImpl.BaseControllerImpl;
import com.example.elbuensaborbackend.entities.MeasurementUnit;
import com.example.elbuensaborbackend.services.Implementation.MeasurementUnitServiceImpl;
import com.example.elbuensaborbackend.services.MeasurementUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/measurementUnit")
public class MeasurementUnitController extends BaseControllerImpl<MeasurementUnit, MeasurementUnitServiceImpl> {

    @Autowired
    MeasurementUnitService measurementUnitService;

    @DeleteMapping("/deactivate/{id}")
    public ResponseEntity<?> leave(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(measurementUnitService.leave(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

}
