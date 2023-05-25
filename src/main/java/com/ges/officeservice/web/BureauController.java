package com.ges.officeservice.web;

import com.ges.officeservice.entities.Bureau;
import com.ges.officeservice.entities.CompteUtilisateur;
import com.ges.officeservice.repository.BureauRepository;
import com.ges.officeservice.repository.CompteUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BureauController {
    @Autowired
    private BureauRepository bureauRepository;
    @Autowired
    private CompteUtilisateurRepository compteUtilisateurRepository;
    @GetMapping("/Fullbureau/{id}")
    public Bureau getFullBu(@PathVariable String id ){
        Bureau b=bureauRepository.findById(id).get();
        List<CompteUtilisateur> compteUtilisateurs=b.getCompteUtilisateurs();

        for (int i=0;i> compteUtilisateurs.size();i++){
            CompteUtilisateur cu=compteUtilisateurRepository.findById(compteUtilisateurs.get(i).getId()).get();
            b.setCompteUtilisateurs(compteUtilisateurs);

        }
        return b ;
    }
}
