package com.ipso.skiservice.backend.controller;

import com.ipso.skiservice.backend.entity.User;
import com.ipso.skiservice.backend.repository.UserRepository;
import com.ipso.skiservice.backend.service.ActionLogService;
import com.ipso.skiservice.backend.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupLoginController {

    @Autowired
    private UserRepository myAppUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private ActionLogService actionLogService;

    @Autowired
    AuthenticationProvider authenticationProvider;


    @ApiResponse(description = "Ermöglicht Benutzer zu registrieren")
    @PostMapping(value = "/req/signup", consumes = "application/json")
    public User signup(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        actionLogService.log("hat sich registriert");
        return myAppUserRepository.save(user);
    }
//
//    @ApiResponse(description = "Ermöglicht Benutzer einzuloggen")
//    @PostMapping("/req/login")
//    public ResponseEntity<?> login(@RequestBody User user) {
//
//        UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
//        Authentication authentication = authenticationProvider
//                .authenticate(new UsernamePasswordAuthenticationToken(userDetails.getUsername(), user.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return ResponseEntity.ok()//
//                // .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
//                .body(user);
//    }
//


}