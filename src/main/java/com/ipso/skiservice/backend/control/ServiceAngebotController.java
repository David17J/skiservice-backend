package com.ipso.skiservice.backend.control;

import com.ipso.skiservice.backend.model.Prioritaet;
import com.ipso.skiservice.backend.model.ServiceAngebot;
import com.ipso.skiservice.backend.repository.ServiceAngebotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/serviceangebot")
public class ServiceAngebotController {

    @Autowired
    private ServiceAngebotRepository serviceAngebotRepository;

    @GetMapping
    public List<ServiceAngebot> findAll() {
        return serviceAngebotRepository.findAll();
    }

    @PostMapping
    public ServiceAngebot save(@Validated @NonNull @RequestBody ServiceAngebot serviceangebot) {
        return serviceAngebotRepository.save(serviceangebot);
    }

    @PutMapping
    public ServiceAngebot update(@Validated @NonNull @RequestBody ServiceAngebot serviceangebot) {
        return serviceAngebotRepository.save(serviceangebot);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        serviceAngebotRepository.deleteById(id);
    }


    @GetMapping("/prios")
    public Prioritaet[] getPrios() {
        return Prioritaet.values();

    }

}
