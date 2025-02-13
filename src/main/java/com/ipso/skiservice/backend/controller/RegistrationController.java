package com.ipso.skiservice.backend.controller;

import com.ipso.skiservice.backend.entity.User;
import com.ipso.skiservice.backend.repository.UserRepository;
import com.ipso.skiservice.backend.service.ActionLogService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserRepository myAppUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private ActionLogService actionLogService;

    @ApiResponse(description = "Ermöglicht Benutzer zu registrieren")
    @PostMapping(value = "/req/signup", consumes = "application/json")
    public User createUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        actionLogService.log("hat sich registriert");
        return myAppUserRepository.save(user);
    }

}