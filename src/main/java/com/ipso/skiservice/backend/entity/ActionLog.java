package com.ipso.skiservice.backend.entity;


import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Builder
@Data
public class ActionLog {

    private String username;
    private String text;
    private LocalTime actionTime;
}
