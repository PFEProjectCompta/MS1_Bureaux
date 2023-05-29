package com.ges.officeservice.web;

import com.ges.officeservice.dto.AdmineBureauDTO;
import com.ges.officeservice.entities.AdmineBureau;
import com.ges.officeservice.repository.AdminBureauRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class AdmineBureauGraphQLController {

    private AdminBureauRepository adminBureauRepository;

    public AdmineBureauGraphQLController(AdminBureauRepository adminBureauRepository) {
        this.adminBureauRepository = adminBureauRepository;
    }
    @QueryMapping
    public List<AdmineBureau> adminesBureauList(){
        return adminBureauRepository.findAll();
    }
    @QueryMapping
    public AdmineBureau admineById(@Argument String id){
        return adminBureauRepository.findById(id).get();
    }
    @MutationMapping
    public AdmineBureau ajouterBureauAdmine(@Argument AdmineBureauDTO admineBureauDTO){
        AdmineBureau admineBureau=AdmineBureau.builder()
                .id(UUID.randomUUID().toString())
                .nom(admineBureauDTO.getNom())
                .prenom(admineBureauDTO.getPrenom())
                .email(admineBureauDTO.getEmail())
                .build();
        return adminBureauRepository.save(admineBureau);
    }
    @MutationMapping
    public AdmineBureau modifierBureauAdmine(@Argument AdmineBureauDTO admineBureauDTO,
                                             @Argument String id){
        AdmineBureau admineBureau=adminBureauRepository.findById(id).get();
        admineBureau.setNom(admineBureauDTO.getNom()==null?admineBureau.getNom(): admineBureauDTO.getNom());
        admineBureau.setPrenom(admineBureauDTO.getPrenom()==null?admineBureau.getPrenom():admineBureauDTO.getPrenom());
        admineBureau.setEmail(admineBureauDTO.getEmail()==null?admineBureau.getEmail():admineBureauDTO.getEmail());
        return adminBureauRepository.save(admineBureau);
    }
    @MutationMapping
    public AdmineBureau supprimerBureauAdmine(@Argument String id){
        AdmineBureau admineBureau=adminBureauRepository.findById(id).get();
        adminBureauRepository.delete(admineBureau);
        return admineBureau;
    }
}
