package com.ges.officeservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Table(name = "bureau ")
public class Bureau {
    @Id
    private String id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "ville")
    private String ville;
    @Column(name = "paye")
    private String paye;
    @Column(name = "numero_tele")
    private String numero_tele;
    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "bureau")
    private List<CompteUtilisateur> compteUtilisateurs;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne //(fetch = FetchType.EAGER)
    @JoinColumn(name = "admine")
    private AdmineBureau admine;
}
