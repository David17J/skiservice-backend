package com.ipso.skiservice.backend.service;

import com.ipso.skiservice.backend.entity.ActionLog;
import com.ipso.skiservice.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ActionLogService implements UserDetailsService {
    @Autowired
    private UserRepository actionLogRepository;

    @Override
    public void log(String text) throws UsernameNotFoundException {
        ActionLog hatSichEingeloggt = ActionLog.builder()
                .username(user.getUsername())
                .actionTime(LocalTime.now())
                .text(text)
                .build();
        actionLogRepository.save(hatSichEingeloggt);
    }
}