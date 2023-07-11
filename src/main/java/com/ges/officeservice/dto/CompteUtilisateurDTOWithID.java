package com.ges.officeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WIAM
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CompteUtilisateurDTOWithID {
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String ville;
    private String pays;
    private String telephone;
    private String date_naissance;
    private boolean actif;
    private String bureauId;
}
