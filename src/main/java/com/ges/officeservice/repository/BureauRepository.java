package com.ges.officeservice.repository;

import com.ges.officeservice.entities.Bureau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface BureauRepository extends JpaRepository<Bureau,String> {

}
