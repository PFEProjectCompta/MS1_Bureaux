package com.ges.officeservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

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
}
