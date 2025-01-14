package com.ipso.skiservice.backend.control;

import com.ipso.skiservice.backend.model.ServiceAuftrag;
import com.ipso.skiservice.backend.repository.ServiceAuftragRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/serviceauftrag")
public class ServiceAuftragController {

    @Autowired
    private ServiceAuftragRepository serviceAuftragRepository;

    @GetMapping
    public List<ServiceAuftrag> findAll() {
        return serviceAuftragRepository.findAll();
    }

    @PostMapping
    public ServiceAuftrag save(@Validated @NonNull @RequestBody ServiceAuftrag serviceauftrag) {
        return serviceAuftragRepository.save(serviceauftrag);
    }

    @PutMapping
    public ServiceAuftrag update(@Validated @NonNull @RequestBody ServiceAuftrag serviceauftrag) {
        return serviceAuftragRepository.save(serviceauftrag);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        serviceAuftragRepository.deleteById(id);
    }

}
