package com.ges.officeservice.repository;

import com.ges.officeservice.entities.SocieteMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author WIAM
 **/
@RepositoryRestResource
public interface SocieteMemberRepository extends JpaRepository<SocieteMember,String> {
}
