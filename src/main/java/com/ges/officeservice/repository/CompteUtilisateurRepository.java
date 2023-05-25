package com.ges.officeservice.repository;

import com.ges.officeservice.entities.CompteUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompteUtilisateurRepository extends JpaRepository<CompteUtilisateur,String> {
}
