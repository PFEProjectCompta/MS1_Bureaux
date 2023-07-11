package com.ges.officeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WIAM
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdmineBureauWithIdDTO {
    private String id;
    private String nom;
    private String prenom;
    private String email;
}
