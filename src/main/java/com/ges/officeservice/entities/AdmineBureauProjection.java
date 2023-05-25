package com.ges.officeservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "adminProjection", types = AdmineBureau.class)
public interface AdmineBureauProjection {

}
