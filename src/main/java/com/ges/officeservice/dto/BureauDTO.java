package com.ges.officeservice.dto;

import com.ges.officeservice.entities.AdmineBureau;
import com.ges.officeservice.entities.CompteUtilisateur;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Builder @Data
public class BureauDTO {
    private String id;
    private String nom;
    private String adresse;
    private String ville;
    private String paye;
    private String numero_tele;
    private String email;
    private List<CompteUtilisateurDTOGraphQL> compteUtilisateurs;
//    private AdmineBureau admineBureau;
}
