package com.kennedy.erp.repositories;


import com.kennedy.erp.model.Familiares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FamiliaresRepository extends JpaRepository<Familiares, Long> {


}
