package com.ipso.skiservice.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
