package com.ipso.skiservice.backend.service;

import com.ipso.skiservice.backend.entity.ServiceAuftrag;
import com.ipso.skiservice.backend.model.AuftragStatusEnum;
import com.ipso.skiservice.backend.repository.ServiceAuftragRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAuftragService {

    @Autowired
    private ServiceAuftragRepository serviceAuftragRepository;

    public ServiceAuftrag updateStatus(Long auftragId, AuftragStatusEnum neuerStatus) {
        // Auftrag suchen
        ServiceAuftrag auftrag = serviceAuftragRepository.findById(auftragId)
                .orElseThrow(() -> new RuntimeException("ServiceAuftrag nicht gefunden"));

        // Status aktualisieren
        auftrag.setStatus(neuerStatus);

        // Änderungen speichern
        return serviceAuftragRepository.save(auftrag);
    }


    public ServiceAuftrag saveAuftrag(ServiceAuftrag neuerAuftrag) {
        // Auftrag suchen
        // Änderungen speichern
        return serviceAuftragRepository.save(neuerAuftrag);
    }

}
