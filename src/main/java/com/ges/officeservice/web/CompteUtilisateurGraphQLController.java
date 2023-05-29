package com.ges.officeservice.web;

import com.ges.officeservice.dto.CompteUtilisateurDTO;
import com.ges.officeservice.entities.CompteUtilisateur;
import com.ges.officeservice.repository.BureauRepository;
import com.ges.officeservice.repository.CompteUtilisateurRepository;
import com.ges.officeservice.repository.SocieteRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

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
    @QueryMapping
    public CompteUtilisateur compteUtilisateurById(@Argument String id){
        return compteUtilisateurRepository.findById(id).get();
    }
    @MutationMapping
    public CompteUtilisateur ajouterCompteUtilisateur(@Argument CompteUtilisateurDTO compteUtilisateurDTO){
        CompteUtilisateur compteUtilisateur=CompteUtilisateur.builder()
                .id(UUID.randomUUID().toString())
                .nom(compteUtilisateurDTO.getNom())
                .prenom(compteUtilisateurDTO.getPrenom())
                .email(compteUtilisateurDTO.getEmail())
                .adresse(compteUtilisateurDTO.getAdresse())
                .ville(compteUtilisateurDTO.getVille())
                .pays(compteUtilisateurDTO.getPays())
                .telephone(compteUtilisateurDTO.getTelephone())
                .date_naissance(compteUtilisateurDTO.getDate_naissance())
                .actif(compteUtilisateurDTO.isActif())
                .bureau(bureauRepository.findById(compteUtilisateurDTO.getBureauId()).get())
                .build();
        return compteUtilisateurRepository.save(compteUtilisateur);
    }
    @MutationMapping
    public CompteUtilisateur modifierCompteUtilisateur(@Argument CompteUtilisateurDTO compteUtilisateurDTO,@Argument String id){
        CompteUtilisateur compteUtilisateur=compteUtilisateurRepository.findById(id).get();
        compteUtilisateur.setNom(compteUtilisateurDTO.getNom()==null? compteUtilisateur.getNom():compteUtilisateurDTO.getNom());
        compteUtilisateur.setPrenom(compteUtilisateurDTO.getPrenom()==null? compteUtilisateur.getPrenom():compteUtilisateurDTO.getPrenom());
        compteUtilisateur.setEmail(compteUtilisateurDTO.getEmail()==null?compteUtilisateur.getEmail():compteUtilisateurDTO.getEmail());
        compteUtilisateur.setAdresse(compteUtilisateurDTO.getAdresse()==null?compteUtilisateur.getAdresse():compteUtilisateurDTO.getAdresse());
        compteUtilisateur.setVille(compteUtilisateurDTO.getVille()==null?compteUtilisateur.getVille():compteUtilisateurDTO.getVille());
        compteUtilisateur.setPays(compteUtilisateurDTO.getPays()==null?compteUtilisateur.getPays():compteUtilisateurDTO.getPays());
        compteUtilisateur.setTelephone(compteUtilisateurDTO.getTelephone()==null?compteUtilisateur.getTelephone():compteUtilisateurDTO.getTelephone());
        compteUtilisateur.setDate_naissance(compteUtilisateurDTO.getDate_naissance()==null?compteUtilisateur.getDate_naissance():compteUtilisateurDTO.getDate_naissance());
        compteUtilisateur.setActif(compteUtilisateurDTO.isActif());
        compteUtilisateur.setBureau(compteUtilisateurDTO.getBureauId()==null?compteUtilisateur.getBureau():bureauRepository.findById(compteUtilisateurDTO.getBureauId()).get());
        return compteUtilisateurRepository.save(compteUtilisateur);
    }
    @MutationMapping
    public CompteUtilisateur supprimerCompteUtilisateur(@Argument String id){
        CompteUtilisateur compteUtilisateur=compteUtilisateurRepository.findById(id).get();
        compteUtilisateurRepository.delete(compteUtilisateur);
        return compteUtilisateur;
    }
}
