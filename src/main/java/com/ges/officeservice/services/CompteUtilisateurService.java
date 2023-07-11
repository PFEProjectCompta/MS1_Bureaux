package com.ges.officeservice.services;

import com.ges.officeservice.entities.CompteUtilisateur;
import com.ges.officeservice.repository.CompteUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WIAM
 **/
@Service
public class CompteUtilisateurService {

    @Autowired
    private CompteUtilisateurRepository compteUtilisateurRepository;

    public List<CompteUtilisateur> allCompteUtilisateurByBureauId(String idBureau){
        List<CompteUtilisateur> compteUtilisateurs=compteUtilisateurRepository.findAll();
        List<CompteUtilisateur> comptesUtilisateurByIdBureau=new ArrayList<>();
        for(int i=0;i<compteUtilisateurs.size();i++){
            if(compteUtilisateurs.get(i).getBureau().getId().equals(idBureau)){
                comptesUtilisateurByIdBureau.add(compteUtilisateurs.get(i));
            }
        }
        return comptesUtilisateurByIdBureau;
    }
}
