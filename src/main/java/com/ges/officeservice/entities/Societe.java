package com.ges.officeservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder @ToString
@Table(name="societe")
public class Societe {
    @Id
    private String id;
    @Column(name = "raison_social")
    private String raison_social;
    @Column(name = "activite")
    private String activite;
    @Column(name = "adresse")
    private String adresse;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "compte_utilisateur")
    private CompteUtilisateur compteUtilisateur;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany( mappedBy = "societe",cascade = CascadeType.REMOVE)
    private List<Contact> contacts;
}
