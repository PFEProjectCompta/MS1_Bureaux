package com.ges.officeservice.web;

import com.ges.officeservice.entities.Bureau;
import com.ges.officeservice.repository.BureauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BureauGraphQLController {
    @Autowired
    private BureauRepository bureauRepository;

    @QueryMapping
    public List<Bureau> bureauList(){
        return bureauRepository.findAll();
    }
}
