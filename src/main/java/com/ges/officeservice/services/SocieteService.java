package com.ges.officeservice.services;

import com.ges.officeservice.dto.SocieteDTO;
import com.ges.officeservice.entities.Societe;
import com.ges.officeservice.kafka.SocieteProducer;
import com.ges.officeservice.repository.CompteUtilisateurRepository;
import com.ges.officeservice.repository.SocieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SocieteService {
    @Autowired
    private SocieteRepository societeRepository;
    @Autowired
    private CompteUtilisateurRepository compteUtilisateurRepository;
    @Autowired
    private SocieteProducer societeProducer;
    public Societe ajouterSociete(SocieteDTO societeDTO){
        Societe societe= Societe.builder()
                .id(UUID.randomUUID().toString())
                .raison_social(societeDTO.getRaison_social())
                .activite(societeDTO.getActivite())
                .adresse(societeDTO.getAdresse())
                .compteUtilisateur(compteUtilisateurRepository.findById(societeDTO.getCompteUtilisateurId()).get())
                .build();
        Societe societeApresAjout=societeRepository.save(societe);
        societeProducer.sendMessage(societeApresAjout);
        return societeApresAjout;
    }
}
