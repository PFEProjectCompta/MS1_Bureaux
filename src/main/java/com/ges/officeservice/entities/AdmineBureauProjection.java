package com.ges.officeservice.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "adminProjection", types = AdmineBureau.class)
public interface AdmineBureauProjection {
    public String getId();
    public String getNom();
    public String getPrenom();
    public String getEmail();
    public List<Bureau> getBureaus();
}
