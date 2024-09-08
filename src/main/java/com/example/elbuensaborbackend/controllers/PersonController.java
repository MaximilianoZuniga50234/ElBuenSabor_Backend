package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.controllers.BaseControllerImpl.BaseControllerImpl;
import com.example.elbuensaborbackend.models.entities.MeasurementUnit;
import com.example.elbuensaborbackend.models.entities.Person;
import com.example.elbuensaborbackend.services.Implementation.PersonServiceImpl;
import com.example.elbuensaborbackend.services.MeasurementUnitService;
import com.example.elbuensaborbackend.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/person")
public class PersonController extends BaseControllerImpl<Person, PersonServiceImpl> {

    @Autowired
    PersonService personService;

    @PostMapping("")
    //@PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> save(@RequestBody Person person) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.save(person));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevamente...\"}");
        }
    }

}
