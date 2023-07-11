package com.ges.officeservice.web;

import com.ges.officeservice.dto.SocieteDTO;
import com.ges.officeservice.entities.Societe;
import com.ges.officeservice.kafka.SocieteProducer;
import com.ges.officeservice.repository.CompteUtilisateurRepository;
import com.ges.officeservice.repository.SocieteRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class SocieteGraphQLController {
    private SocieteRepository societeRepository;
    private CompteUtilisateurRepository compteUtilisateurRepository;
    private SocieteProducer societeProducer;

    public SocieteGraphQLController(SocieteRepository societeRepository, CompteUtilisateurRepository compteUtilisateurRepository, SocieteProducer societeProducer) {
        this.societeRepository = societeRepository;
        this.compteUtilisateurRepository = compteUtilisateurRepository;
        this.societeProducer = societeProducer;
    }
    @QueryMapping
    public List<Societe> societeList(){
        return societeRepository.findAll();
    }
    @QueryMapping
    public Societe societeById(@Argument String id){
        return societeRepository.findById(id).get();
    }
    @QueryMapping
    public List<Societe> societeByIdUtilisateur(@Argument String idUtilisateur){
        List<Societe> societeList=societeRepository.findAll();
        List<Societe> societesByIdUtilisateur=new ArrayList<>();
        for(int i=0;i<societeList.size();i++){
            if(societeList.get(i).getCompteUtilisateur().getId().equals(idUtilisateur)){
                societesByIdUtilisateur.add(societeList.get(i));
            }
        }
        return societesByIdUtilisateur;
    }
    @MutationMapping
    public Societe ajouterSociete(@Argument SocieteDTO societeDTO){
        Societe societe=Societe.builder()
                .id(UUID.randomUUID().toString())
                .raison_social(societeDTO.getRaison_social())
                .activite(societeDTO.getActivite())
                .adresse(societeDTO.getAdresse())
                .compteUtilisateur(compteUtilisateurRepository.findById(societeDTO.getCompteUtilisateurId()).get())
                .forme_juridique(societeDTO.getForme_juridique())
                .devise(societeDTO.getDevise())
                .identifiant_TVA(societeDTO.getIdentifiant_TVA())
                .pays(societeDTO.getPays())
                .ville(societeDTO.getVille())
                .email(societeDTO.getEmail())
                .telephone(societeDTO.getTelephone())
                .num_dossier(societeDTO.getNum_dossier())
                .site_internet(societeDTO.getSite_internet())
                .capital(societeDTO.getCapital())
                .build();
        societeProducer.sendMessage(societe);
        return societeRepository.save(societe);
    }
    @MutationMapping
    public Societe modifierSociete(@Argument SocieteDTO societeDTO,@Argument String id){
        Societe societe=societeRepository.findById(id).get();
        societe.setRaison_social(societeDTO.getRaison_social()==null?societe.getRaison_social():societeDTO.getRaison_social());
        societe.setActivite(societeDTO.getActivite()==null?societe.getActivite():societeDTO.getActivite());
        societe.setAdresse(societeDTO.getAdresse()==null?societe.getAdresse():societeDTO.getAdresse());
        societe.setCompteUtilisateur(societeDTO.getCompteUtilisateurId()==null?societe.getCompteUtilisateur():compteUtilisateurRepository.findById(societeDTO.getCompteUtilisateurId()).get());
        societe.setForme_juridique(societeDTO.getForme_juridique()==null?societe.getForme_juridique():societeDTO.getForme_juridique());
        societe.setDevise(societeDTO.getDevise()==null?societe.getDevise():societeDTO.getDevise());
        societe.setIdentifiant_TVA(societeDTO.getIdentifiant_TVA()==null?societe.getIdentifiant_TVA():societeDTO.getIdentifiant_TVA());
        societe.setPays(societeDTO.getPays()==null?societe.getPays() :societeDTO.getPays());
        societe.setVille(societeDTO.getVille()==null?societe.getVille():societeDTO.getVille());
        societe.setEmail(societeDTO.getEmail()==null?societe.getEmail():societeDTO.getEmail());
        societe.setTelephone(societeDTO.getTelephone()==null?societe.getTelephone():societeDTO.getTelephone());
        societe.setNum_dossier(societeDTO.getNum_dossier()==null?societe.getNum_dossier():societeDTO.getNum_dossier());
        societe.setSite_internet(societeDTO.getSite_internet()==null?societe.getSite_internet():societeDTO.getSite_internet());
        societe.setCapital(societeDTO.getCapital()==0?societe.getCapital():societeDTO.getCapital());
        societeProducer.sendMessage(societe);
        return societeRepository.save(societe);
    }
    @MutationMapping
    public Societe supprimerSociete(@Argument String id){
        Societe societe=societeRepository.findById(id).get();
        societeRepository.delete(societe);
        societeProducer.sendMessageDeletedSociete(societe);
        return societe;
    }
}
