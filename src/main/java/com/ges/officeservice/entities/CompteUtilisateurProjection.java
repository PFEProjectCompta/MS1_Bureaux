package com.ges.officeservice.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "compteUtilisateurProjection", types = CompteUtilisateur.class)
public interface CompteUtilisateurProjection {
    public String getId();
    public String getNom();
    public String getPrenom();
    public String getEmail();
    public String getAdresse();
    public String getVille();
    public String getPays();
    public String getTelephone();
    public String getDate_naissance();
    public Bureau getBureau();
    public List<Societe> getSocietes();
    public boolean isActif();
}
