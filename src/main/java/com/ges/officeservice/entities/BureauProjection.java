package com.ges.officeservice.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "bureauProjection",types = Bureau.class)
public interface BureauProjection {
    public String getId();
    public String getNom();
    public String getAdresse();
    public String getVille();
    public String getPaye();
    public String getNumero_tele();
    public String getEmail();
    public List<CompteUtilisateur> getCompteUtilisateurs();
    public AdmineBureau getAdmine();
}
