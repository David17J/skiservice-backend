package com.ipso.skiservice.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ServiceAngebot {

    @Id
    private Long id;
    @NonNull
    private String title;

}
