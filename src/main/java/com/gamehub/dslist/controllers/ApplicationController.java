package com.gamehub.dslist.controllers;

import com.gamehub.dslist.dto.ApplicationDTO;
import com.gamehub.dslist.services.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/app")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping(path = "/status")
    public ResponseEntity<ApplicationDTO> getStatus() {
        return ResponseEntity.ok(applicationService.getStatus());
    }
}
