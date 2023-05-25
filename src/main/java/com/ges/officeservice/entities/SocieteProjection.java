package com.ges.officeservice.entities;

import com.ges.officeservice.entities.Societe;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "societeProjection",types = Societe.class)
public interface SocieteProjection {
    public String getId();
    public String getRaison_social();
    public String getAdresse();
    public String getActivite();
    public CompteUtilisateur getCompteUtilisateur();
}
