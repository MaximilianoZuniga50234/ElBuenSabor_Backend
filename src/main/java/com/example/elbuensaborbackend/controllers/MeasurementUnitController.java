package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.controllers.BaseControllerImpl.BaseControllerImpl;
import com.example.elbuensaborbackend.entities.MeasurementUnit;
import com.example.elbuensaborbackend.services.Implementation.MeasurementUnitServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/measurementUnit")
public class MeasurementUnitController extends BaseControllerImpl<MeasurementUnit, MeasurementUnitServiceImpl> {

}
