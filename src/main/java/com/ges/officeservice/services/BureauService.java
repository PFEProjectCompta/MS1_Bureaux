package com.ges.officeservice.services;

import com.ges.officeservice.entities.Bureau;
import com.ges.officeservice.repository.BureauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WIAM
 **/
@Service
public class BureauService {
    @Autowired
    private BureauRepository bureauRepository;

    public List<Bureau> findBureauxByAdminId(String id){
        List<Bureau> bureaus=bureauRepository.findAll();
        List<Bureau> bureausAdmin=new ArrayList<>();
        for (int i=0;i<bureaus.size();i++){
            if(bureaus.get(i).getAdmine().getId().equals(id)){
                bureausAdmin.add(bureaus.get(i));
            }
        }
        return bureausAdmin;
    }
}
