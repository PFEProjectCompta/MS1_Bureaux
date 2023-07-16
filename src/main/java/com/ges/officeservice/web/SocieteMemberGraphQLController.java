package com.ges.officeservice.web;

import com.ges.officeservice.dto.SocieteMemberDTO;
import com.ges.officeservice.entities.Societe;
import com.ges.officeservice.entities.SocieteMember;
import com.ges.officeservice.repository.CompteUtilisateurRepository;
import com.ges.officeservice.repository.SocieteMemberRepository;
import com.ges.officeservice.repository.SocieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author WIAM
 **/
@Controller
public class SocieteMemberGraphQLController {
    @Autowired
    private SocieteMemberRepository societeMemberRepository;
    @Autowired
    private SocieteRepository societeRepository;
    @Autowired
    private CompteUtilisateurRepository compteUtilisateurRepository;
    @QueryMapping
    public List<SocieteMember> membersList(@Argument String id){
        List<SocieteMember> societeMembers=societeMemberRepository.findAll();
        List<SocieteMember> societeMembersBySocieteId=new ArrayList<>();
        for (int i=0;i< societeMembers.size();i++){
            if(societeMembers.get(i).getSociete().getId().equals(id)){
                societeMembersBySocieteId.add(societeMembers.get(i));
            }
        }
        return societeMembersBySocieteId;
    }
    @QueryMapping
    public List<SocieteMember> membersListByMemberId(@Argument String id){
        List<SocieteMember> societeMembers=societeMemberRepository.findAll();
        List<SocieteMember> societeMembersBySocieteId=new ArrayList<>();
        for (int i=0;i< societeMembers.size();i++){
            if(societeMembers.get(i).getMember().getId().equals(id)){
                societeMembersBySocieteId.add(societeMembers.get(i));
            }
        }
        return societeMembersBySocieteId;
    }
    @MutationMapping
    public SocieteMember ajouterSocieteMember(@Argument SocieteMemberDTO societeMemberDTO){
        SocieteMember societeMember=SocieteMember.builder()
                .id(UUID.randomUUID().toString())
                .societe(societeRepository.findById(societeMemberDTO.getId_societe()).get())
                .createur(compteUtilisateurRepository.findById(societeMemberDTO.getCreateur()).get())
                .member(compteUtilisateurRepository.findById(societeMemberDTO.getMember()).get())
                .build();
        return societeMemberRepository.save(societeMember);
    }
    @MutationMapping
    public SocieteMember supprimerSocieteMember(@Argument String id){
        SocieteMember societeMember=societeMemberRepository.findById(id).get();
        societeMemberRepository.delete(societeMember);
        return societeMember;
    }

}
