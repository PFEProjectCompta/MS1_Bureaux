package com.ges.officeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class SocieteDTO {
    private String raison_social;
    private String activite;
    private String adresse;
    private String compteUtilisateurId;
}
