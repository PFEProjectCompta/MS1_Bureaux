package com.ges.officeservice.web;

import com.ges.officeservice.dto.BureauDTO;
import com.ges.officeservice.entities.AdmineBureau;
import com.ges.officeservice.entities.Bureau;
import com.ges.officeservice.repository.AdminBureauRepository;
import com.ges.officeservice.repository.BureauRepository;
import com.ges.officeservice.services.BureauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class BureauGraphQLController {
    @Autowired
    private BureauRepository bureauRepository;
    @Autowired
    private AdminBureauRepository  adminBureauRepository;
    @Autowired
    private BureauService bureauService;
    @QueryMapping
    public List<Bureau> bureauList(){
        return bureauRepository.findAll();
    }
    @QueryMapping
    public List<Bureau> bureauListByAdminId(@Argument String id)
    {
        return bureauService.findBureauxByAdminId(id);
    }
    @QueryMapping
    public Bureau bureauById(@Argument String id){
        return bureauRepository.findById(id).get();
    }
    @MutationMapping
    public Bureau ajouterBureau(@Argument BureauDTO bureauDTO){
        Bureau bureau=Bureau.builder()
                .id(UUID.randomUUID().toString())
                .nom(bureauDTO.getNom())
                .adresse(bureauDTO.getAdresse())
                .ville(bureauDTO.getVille())
                .paye(bureauDTO.getPaye())
                .numero_tele(bureauDTO.getNumero_tele())
                .email(bureauDTO.getEmail())
                .admine(adminBureauRepository.findById(bureauDTO.getAdmineId()).get())
                .build();
        return bureauRepository.save(bureau);
    }
    @MutationMapping
    public Bureau modifierBureau(@Argument BureauDTO bureauDTO,@Argument String id){
        Bureau bureau=bureauRepository.findById(id).get();
        bureau.setNom(bureauDTO.getNom()==null?bureau.getNom():bureauDTO.getNom());
        bureau.setAdresse(bureauDTO.getAdresse()==null?bureau.getAdresse():bureauDTO.getAdresse());
        bureau.setVille(bureauDTO.getVille()==null?bureau.getVille():bureauDTO.getVille());
        bureau.setPaye(bureauDTO.getPaye()==null?bureau.getPaye():bureauDTO.getPaye());
        bureau.setNumero_tele(bureauDTO.getNumero_tele()==null?bureau.getNumero_tele():bureauDTO.getNumero_tele());
        bureau.setEmail(bureauDTO.getEmail()==null?bureau.getEmail():bureauDTO.getEmail());
        bureau.setAdmine(bureauDTO.getAdmineId()==null?bureau.getAdmine():adminBureauRepository.findById(bureauDTO.getAdmineId()).get());
        return bureauRepository.save(bureau);
    }
    @MutationMapping
    public Bureau supprimerBureau(@Argument String id){
        Bureau bureau=bureauRepository.findById(id).get();
        bureauRepository.delete(bureau);
        return bureau;
    }
}
