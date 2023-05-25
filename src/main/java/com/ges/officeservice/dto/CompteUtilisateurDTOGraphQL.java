package com.ges.officeservice.dto;

import com.ges.officeservice.entities.Bureau;
import com.ges.officeservice.entities.Societe;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CompteUtilisateurDTOGraphQL {
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String ville;
    private String pays;
    private String telephone;
//    private Float date_naissance;
    private boolean actif;
//    private List<Societe> societes;
//    private String bureau;
}
