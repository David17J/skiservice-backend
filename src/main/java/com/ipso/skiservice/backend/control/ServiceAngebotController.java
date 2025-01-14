package com.ipso.skiservice.backend.control;

import com.ipso.skiservice.backend.model.Serviceangebot;
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
    public List<Serviceangebot> findAll(){
        return serviceAngebotRepository.findAll();
    }

    @PostMapping
    public Serviceangebot save(@Validated @NonNull @RequestBody Serviceangebot serviceangebot){
        return serviceAngebotRepository.save(serviceangebot);
    }

    @PutMapping
    public Serviceangebot update(@Validated @NonNull @RequestBody Serviceangebot serviceangebot){
        return serviceAngebotRepository.save(serviceangebot);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        serviceAngebotRepository.deleteById(id);
    }

}
