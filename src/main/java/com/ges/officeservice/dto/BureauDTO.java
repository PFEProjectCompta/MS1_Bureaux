package com.ges.officeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor @AllArgsConstructor @Builder
public class BureauDTO {
    private String nom;
    private String adresse;
    private String ville;
    private String paye;
    private String numero_tele;
    private String email;
    private String admineId;
}
