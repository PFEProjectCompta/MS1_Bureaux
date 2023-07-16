package com.ges.officeservice.dto;

import jakarta.persistence.Entity;
import lombok.*;

/**
 * @author WIAM
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SocieteMemberDTO {
    private String id_societe;
    private String createur;
    private String member;
}
