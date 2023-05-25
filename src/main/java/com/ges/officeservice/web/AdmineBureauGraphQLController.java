package com.ges.officeservice.web;

import com.ges.officeservice.entities.AdmineBureau;
import com.ges.officeservice.repository.AdminBureauRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

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
}
