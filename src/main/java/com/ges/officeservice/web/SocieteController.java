package com.ges.officeservice.web;

import com.ges.officeservice.entities.CompteUtilisateur;
import com.ges.officeservice.entities.Societe;
import com.ges.officeservice.repository.AdminBureauRepository;
import com.ges.officeservice.repository.BureauRepository;
import com.ges.officeservice.repository.CompteUtilisateurRepository;
import com.ges.officeservice.repository.SocieteRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocieteController {
    private SocieteRepository societeRepository;
    private CompteUtilisateurRepository compteUtilisateurRepository;
    private BureauRepository bureauRepository;
    private AdminBureauRepository adminBureauRepository;


    public SocieteController(SocieteRepository societeRepository, CompteUtilisateurRepository compteUtilisateurRepository, BureauRepository bureauRepository, AdminBureauRepository adminBureauRepository) {
        this.societeRepository = societeRepository;
        this.compteUtilisateurRepository = compteUtilisateurRepository;
        this.bureauRepository = bureauRepository;
        this.adminBureauRepository = adminBureauRepository;
    }

    @GetMapping("/fullSocieteCompteUtilisateur/{idSociete}")
    @PreAuthorize("hasRole('admin_user')")
    public CompteUtilisateur fullSocieteCompteUtilisateur(@PathVariable String idSociete){
        Societe societe=societeRepository.findById(idSociete).get();
        CompteUtilisateur compteUtilisateur=compteUtilisateurRepository.findById(societe.getCompteUtilisateur().getId()).get();
        return compteUtilisateur;
    }
}
