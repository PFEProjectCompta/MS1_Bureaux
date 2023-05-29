package com.ges.officeservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "admine_bureau")
public class AdmineBureau {
    @Id
    private String id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "email")
    private String email;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "admine",cascade = CascadeType.REMOVE)
    private List<Bureau> bureaus;
}
