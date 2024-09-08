package com.example.elbuensaborbackend.controllers.auth0;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class APIController {

    @GetMapping(value = "/public")
    public ResponseEntity<?> publicEndpoint() {
        return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"All good. You DO NOT need to be authenticated to call this endpoint.\"}");
    }

    @GetMapping(value = "/private")
    public ResponseEntity<?> privateEndpoint() {
        return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"All good. You can see this because you are Authenticated.\"}");
    }

    @GetMapping(value = "/admin-only")
    @PreAuthorize("hasAuthority('read:admin-test')")
    public ResponseEntity<?> adminOnlyEndpoint() {
        return ResponseEntity.status(HttpStatus.OK).body("{ \"message\": \"All good. You can see this because you are an Admin.\"}");
    }
}