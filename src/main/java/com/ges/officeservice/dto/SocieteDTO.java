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
    private String ville;
    private String pays;
    private String devise;
    private String forme_juridique;
    private double capital;
    private String telephone;
    private String email;
    private String site_internet;
    private String num_dossier;
    private String identifiant_TVA;
}
