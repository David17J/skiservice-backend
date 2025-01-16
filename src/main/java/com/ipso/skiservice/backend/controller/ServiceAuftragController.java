package com.ipso.skiservice.backend.controller;

import com.ipso.skiservice.backend.entity.ServiceAuftrag;
import com.ipso.skiservice.backend.model.AuftragStatusEnum;
import com.ipso.skiservice.backend.service.ServiceAuftragService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/serviceauftrag")
public class ServiceAuftragController {

    @Autowired
    private ServiceAuftragService serviceAuftragService;

    @PutMapping("/{auftragId}/{status}")
    public ResponseEntity<ServiceAuftrag> updateStatus(
            @PathVariable Long auftragId,
            @RequestParam AuftragStatusEnum status) {
        ServiceAuftrag updatedAuftrag = serviceAuftragService.updateStatus(auftragId, status);
        return ResponseEntity.ok(updatedAuftrag);
    }

    @ApiResponse(description = "Ermöglicht Benutzer zu registrieren")
    @PostMapping(consumes = "application/json")
    public ServiceAuftrag createUser(@RequestBody ServiceAuftrag serviceAuftrag) {
        //actionLogService.log("hat sich registriert");
        return serviceAuftragService.saveAuftrag(serviceAuftrag);
    }
}
