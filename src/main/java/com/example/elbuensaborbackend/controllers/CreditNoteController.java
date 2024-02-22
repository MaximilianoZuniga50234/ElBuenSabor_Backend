package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.controllers.BaseControllerImpl.BaseControllerImpl;
import com.example.elbuensaborbackend.models.entities.CreditNote;
import com.example.elbuensaborbackend.services.Implementation.CreditNoteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/creditNote")
public class CreditNoteController extends BaseControllerImpl<CreditNote, CreditNoteServiceImpl> {
}
