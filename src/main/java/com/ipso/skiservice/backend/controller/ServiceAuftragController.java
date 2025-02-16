package com.ipso.skiservice.backend.controller;

import com.ipso.skiservice.backend.entity.ServiceAuftrag;
import com.ipso.skiservice.backend.model.AuftragStatusEnum;
import com.ipso.skiservice.backend.repository.ServiceAuftragRepository;
import com.ipso.skiservice.backend.service.ActionLogService;
import com.ipso.skiservice.backend.service.ServiceAuftragService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serviceauftrag")
public class ServiceAuftragController {

    @Autowired
    private ServiceAuftragService serviceAuftragService;

    @Autowired
    private ServiceAuftragRepository serviceAuftragRepository;

    @Autowired
    private ActionLogService actionLogService;

    @PutMapping("/{auftragId}/{status}")
    public ResponseEntity<ServiceAuftrag> updateStatus(
            @PathVariable Long auftragId,
            @RequestParam AuftragStatusEnum status) {
        ServiceAuftrag updatedAuftrag = serviceAuftragService.updateStatus(auftragId, status);
        return ResponseEntity.ok(updatedAuftrag);
    }

    @ApiResponse(description = "Liefert alle Aufträge")
    @GetMapping
    public List<ServiceAuftrag> getAllAuftraege() {
        return serviceAuftragRepository.findAll();
    }

    @ApiResponse(description = "Erstellt einen neuen Auftrag")
    @PostMapping(consumes = "application/json")
    public ServiceAuftrag createAuftrag(@RequestBody ServiceAuftrag serviceAuftrag) {
        ServiceAuftrag savedAuftrag = serviceAuftragService.saveAuftrag(serviceAuftrag);
        actionLogService.log("Service Autrag erstellt:" + savedAuftrag.getId());
        return serviceAuftrag;
    }
}
