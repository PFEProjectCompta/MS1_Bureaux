package com.ges.officeservice.web;

import com.ges.officeservice.dto.SocieteDTO;
import com.ges.officeservice.entities.CompteUtilisateur;
import com.ges.officeservice.entities.Societe;
import com.ges.officeservice.repository.AdminBureauRepository;
import com.ges.officeservice.repository.BureauRepository;
import com.ges.officeservice.repository.CompteUtilisateurRepository;
import com.ges.officeservice.repository.SocieteRepository;
import com.ges.officeservice.services.SocieteService;
import org.springframework.web.bind.annotation.*;

@RestController
public class SocieteController {
    private SocieteRepository societeRepository;
    private CompteUtilisateurRepository compteUtilisateurRepository;
    private BureauRepository bureauRepository;
    private AdminBureauRepository adminBureauRepository;
    private SocieteService societeService;

    public SocieteController(SocieteRepository societeRepository, CompteUtilisateurRepository compteUtilisateurRepository, BureauRepository bureauRepository, AdminBureauRepository adminBureauRepository, SocieteService societeService) {
        this.societeRepository = societeRepository;
        this.compteUtilisateurRepository = compteUtilisateurRepository;
        this.bureauRepository = bureauRepository;
        this.adminBureauRepository = adminBureauRepository;
        this.societeService = societeService;
    }

    @GetMapping("/fullSocieteCompteUtilisateur/{idSociete}")
   // @PreAuthorize("hasRole('admin_user')")
    public CompteUtilisateur fullSocieteCompteUtilisateur(@PathVariable String idSociete){
        Societe societe=societeRepository.findById(idSociete).get();
        CompteUtilisateur compteUtilisateur=compteUtilisateurRepository.findById(societe.getCompteUtilisateur().getId()).get();
        return compteUtilisateur;
    }
    @PostMapping("/ajouterSociete")
    public Societe ajouterSociete(@RequestBody SocieteDTO societeDTO){
        return societeService.ajouterSociete(societeDTO);
    }
}
