package com.ipso.skiservice.backend.entity;

import com.ipso.skiservice.backend.model.Prioritaet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ServiceAuftrag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String vorname;
    private String nachname;
    private String email;
    private String telefon;
    private Prioritaet prioritaet;

    @OneToOne
    private ServiceAngebot serviceAngebot;

}
