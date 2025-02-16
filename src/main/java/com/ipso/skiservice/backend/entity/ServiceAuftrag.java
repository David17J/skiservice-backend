package com.ipso.skiservice.backend.entity;

import com.ipso.skiservice.backend.model.AuftragStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

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
    private LocalDate abholdatum;
    private LocalDate erstelldatum;

    @Enumerated(EnumType.STRING) // Speichert den Status als Text in der Datenbank
    private AuftragStatusEnum status = AuftragStatusEnum.OFFEN; // Standardwert: OFFEN

    @OneToOne
    private ServiceAngebot serviceAngebot;
}
