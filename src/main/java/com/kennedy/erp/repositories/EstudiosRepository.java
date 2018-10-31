package com.kennedy.erp.repositories;

import com.kennedy.erp.model.Carrera;
import com.kennedy.erp.model.Estudios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EstudiosRepository extends JpaRepository<Estudios, Long> {


}
