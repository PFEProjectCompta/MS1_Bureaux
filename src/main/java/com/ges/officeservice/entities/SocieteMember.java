package com.ges.officeservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

/**
 * @author WIAM
 **/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SocieteMember {
    @Id
    private String id;
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne //(fetch = FetchType.EAGER)
    @JoinColumn(name = "societe")
    private Societe societe;
    @ManyToOne
    @JoinColumn(name = "createur")
    private CompteUtilisateur createur;
    @ManyToOne
    @JoinColumn(name = "member")
    private CompteUtilisateur member;
}
