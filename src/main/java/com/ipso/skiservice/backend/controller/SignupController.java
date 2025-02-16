package com.ipso.skiservice.backend.controller;

import com.ipso.skiservice.backend.entity.User;
import com.ipso.skiservice.backend.repository.UserRepository;
import com.ipso.skiservice.backend.service.ActionLogService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@RestController
public class SignupController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ActionLogService actionLogService;

    @Autowired
    AuthenticationProvider authenticationProvider;


    @ApiResponse(description = "Ermöglicht Benutzer zu registrieren")
    @PostMapping(value = "/signup")
    public RedirectView processSignupForm(@RequestParam String username, @RequestParam String password, @RequestParam String email) {

        Optional<User> byUsername = userRepository.findByUsername(username.toLowerCase());
        if (byUsername.isPresent()) {
            throw new RuntimeException("User already exists");
        }
        User user = User.builder()
                .password(passwordEncoder.encode(password))
                .email(email)
                .username(username.toLowerCase()).build();
        User savedUser = userRepository.save(user);
        actionLogService.log(savedUser.getUsername() + "hat sich registriert");
        return new RedirectView("login");
    }

    //braucht es nicht, da Spring automatisch implementiert hat (nur POST)
//    @ApiResponse(description = "Ermöglicht Benutzer einzuloggen")
//    @PostMapping("/login")
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


}