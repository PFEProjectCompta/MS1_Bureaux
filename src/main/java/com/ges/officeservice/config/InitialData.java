package com.ges.officeservice.config;

import com.ges.officeservice.entities.AdmineBureau;
import com.ges.officeservice.entities.Bureau;
import com.ges.officeservice.entities.CompteUtilisateur;
import com.ges.officeservice.entities.Societe;
import com.ges.officeservice.repository.AdminBureauRepository;
import com.ges.officeservice.repository.BureauRepository;
import com.ges.officeservice.repository.CompteUtilisateurRepository;
import com.ges.officeservice.repository.SocieteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class InitialData {

    private static AdminBureauRepository adminBureauRepository;
    private static   SocieteRepository societeRepository;
    private static BureauRepository bureauRepository;
    private static CompteUtilisateurRepository compteUtilisateurRepository;

    public InitialData(AdminBureauRepository adminBureauRepository,SocieteRepository societeRepository, BureauRepository bureauRepository, CompteUtilisateurRepository compteUtilisateurRepository) {
        this.societeRepository = societeRepository;
        this.bureauRepository = bureauRepository;
        this.compteUtilisateurRepository = compteUtilisateurRepository;
        this.adminBureauRepository = adminBureauRepository;
    }
    @Transactional
    public static void creeAdmineBureau(){
        Random random=new Random();
        for(int j=0; j<10;j++) {
            AdmineBureau admineBureau = AdmineBureau.builder()
                    .id(UUID.randomUUID().toString())
                    .nom(String.format("Compte %s", j))
                    .prenom(String.format("Prenom %s", j))
                    .email(String.format("%slwqw@gmail.com", j * random.nextInt(100)))
                    .build();
            System.out.println("Admine : "+adminBureauRepository.save(admineBureau));
        }
    }
    @Transactional
    public static void creeBureau(){
        Random random=new Random();
        List<AdmineBureau> admineBureaus = adminBureauRepository.findAll();
        for (int j=0;j<admineBureaus.size();j++) {
            for (int i = 0; i < 5; i++) {
                Bureau bureau = Bureau.builder()
                        .id(UUID.randomUUID().toString())
                        .nom(String.format("Bureau %s", i))
                        .adresse(String.format("%s imm %s", i, i * random.nextInt(100)))
                        .ville(String.format("ville %s", i))
                        .paye(String.format("$$Paye%s", i * i))
                        .email(String.format("%slwqw@gmail.com", i * random.nextInt(100)))
                        .numero_tele(String.format(" %s", i * random.nextInt(888)))
                        .admine(admineBureaus.get(j))
                        .build();
                System.out.println("Bureau : "+bureauRepository.save(bureau).getId());
            }
        }
    }


    @Transactional
    public static void creeCompteUtilisateur() {
        Random random = new Random();
        List<Bureau> bureaus = bureauRepository.findAll();
        bureaus.forEach(bu -> {
            double j=Math.random();
            CompteUtilisateur compteUtilisateur = CompteUtilisateur.builder()
                    .id(UUID.randomUUID().toString())
                    .nom(String.format("Compte %s", j))
                    .prenom(String.format("Prenom %s", j))
                    .email(String.format("%slwqw@gmail.com", j * random.nextInt(100)))
                    .adresse(String.format("%s imm %s", j, j * random.nextInt(100)))
                    .ville(String.format("ville %s", j))
                    .pays(String.format("$$Paye%s", j * j))
                    .telephone(String.format(" %s", j * random.nextInt(888)))
                    .date_naissance(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString())
                    .actif(Math.random() > 0.17 ? true : false)
                    .bureau(bu)
                    .build();
            System.out.println("Comptes : "+compteUtilisateurRepository.save(compteUtilisateur).getId());


        });

    }
    @Transactional
    public static void creeSociete(){
        Random random=new Random();
        List<CompteUtilisateur> compteUtilisateurs= compteUtilisateurRepository.findAll();
        compteUtilisateurs.forEach(compteUtilisateur -> {
            for(int j=0; j<3;j++) {
                Societe societe=Societe.builder()
                        .id(UUID.randomUUID().toString())
                        .raison_social(String.format("Societe%s",random.nextInt(200)))
                        .activite(String.format("Acivite %s",j))
                        .adresse(String.format("%s imm %s",j,j* random.nextInt(100)))
                        .compteUtilisateur(compteUtilisateur).build();
                System.out.println("Societe : "+societeRepository.save(societe).getId());
            }
        });

    }
}
