package com.ges.officeservice.web;

import com.ges.officeservice.dto.BureauDTO;
import com.ges.officeservice.dto.CompteUtilisateurDTOGraphQL;
import com.ges.officeservice.entities.Bureau;
import com.ges.officeservice.entities.CompteUtilisateur;
import com.ges.officeservice.entities.Societe;
import com.ges.officeservice.repository.BureauRepository;
import com.ges.officeservice.repository.CompteUtilisateurRepository;
import com.ges.officeservice.repository.SocieteRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CompteUtilisateurGraphQLController {
    private CompteUtilisateurRepository compteUtilisateurRepository;
    private SocieteRepository societeRepository;
    private BureauRepository bureauRepository;
    public CompteUtilisateurGraphQLController(CompteUtilisateurRepository compteUtilisateurRepository, SocieteRepository societeRepository, BureauRepository bureauRepository) {
        this.compteUtilisateurRepository = compteUtilisateurRepository;
        this.societeRepository = societeRepository;
        this.bureauRepository = bureauRepository;
    }

    @QueryMapping
    public List<CompteUtilisateur> compteUtilisateurList(){
        return compteUtilisateurRepository.findAll();
    }
}
