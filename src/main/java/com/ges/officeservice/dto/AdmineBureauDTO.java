package com.ges.officeservice.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class AdmineBureauDTO {
    private String nom;
    private String prenom;
    private String email;
}
