package com.ges.officeservice.web;

import com.ges.officeservice.dto.SocieteDTO;
import com.ges.officeservice.entities.Societe;
import com.ges.officeservice.repository.CompteUtilisateurRepository;
import com.ges.officeservice.repository.SocieteRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class SocieteGraphQLController {
    private SocieteRepository societeRepository;
    private CompteUtilisateurRepository compteUtilisateurRepository;

    public SocieteGraphQLController(SocieteRepository societeRepository, CompteUtilisateurRepository compteUtilisateurRepository) {
        this.societeRepository = societeRepository;
        this.compteUtilisateurRepository = compteUtilisateurRepository;
    }
    @QueryMapping
    public List<Societe> societeList(){
        return societeRepository.findAll();
    }
    @QueryMapping
    public Societe societeById(@Argument String id){
        return societeRepository.findById(id).get();
    }
    @MutationMapping
    public Societe ajouterSociete(@Argument SocieteDTO societeDTO){
        Societe societe=Societe.builder()
                .id(UUID.randomUUID().toString())
                .raison_social(societeDTO.getRaison_social())
                .activite(societeDTO.getActivite())
                .adresse(societeDTO.getAdresse())
                .compteUtilisateur(compteUtilisateurRepository.findById(societeDTO.getCompteUtilisateurId()).get())
                .build();
        return societeRepository.save(societe);
    }
    @MutationMapping
    public Societe modifierSociete(@Argument SocieteDTO societeDTO,@Argument String id){
        Societe societe=societeRepository.findById(id).get();
        societe.setRaison_social(societeDTO.getRaison_social()==null?societe.getRaison_social():societeDTO.getRaison_social());
        societe.setActivite(societeDTO.getActivite()==null?societe.getActivite():societeDTO.getActivite());
        societe.setAdresse(societeDTO.getAdresse()==null?societe.getAdresse():societeDTO.getAdresse());
        societe.setCompteUtilisateur(societeDTO.getCompteUtilisateurId()==null?societe.getCompteUtilisateur():compteUtilisateurRepository.findById(societeDTO.getCompteUtilisateurId()).get());
        return societeRepository.save(societe);
    }
    @MutationMapping
    public Societe supprimerSociete(@Argument String id){
        Societe societe=societeRepository.findById(id).get();
        societeRepository.delete(societe);
        return societe;
    }
}
