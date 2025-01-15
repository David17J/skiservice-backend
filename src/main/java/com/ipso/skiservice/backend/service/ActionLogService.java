package com.ipso.skiservice.backend.service;

import com.ipso.skiservice.backend.entity.ActionLog;
import com.ipso.skiservice.backend.repository.ActionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ActionLogService {
    @Autowired
    private ActionLogRepository actionLogRepository;

    public void log(String text) throws UsernameNotFoundException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        ActionLog hatSichEingeloggt = ActionLog.builder()
                .username(currentPrincipalName)
                .actionTime(LocalTime.now())
                .text(text)
                .build();
        actionLogRepository.save(hatSichEingeloggt);
    }
}