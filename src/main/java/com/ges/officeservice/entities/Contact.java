package com.ges.officeservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WIAM
 **/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "contact")
public class Contact {
    @Id
    private String id;
    private String type_contact;
    private String civilite;
    private String nom;
    private String prenom;
    private String service;
    private String fonction;
    private String telephone;
    private String portable;
    private String email;
    private String telecopie;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "societe")
    private Societe societe;
}
