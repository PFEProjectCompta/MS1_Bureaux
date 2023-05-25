package com.ges.officeservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "compte_utilisateur")
public class CompteUtilisateur {
    @Id
    private String id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "email")
    private String email;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "ville")
    private String ville;
    @Column(name = "pays")
    private String pays;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "date_naissance")
    private Date date_naissance;
    @Column(name = "actif")
    private boolean actif;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "bureau")
    private Bureau bureau;

    @OneToMany( mappedBy = "compteUtilisateur")
    private List<Societe> societes;
}
