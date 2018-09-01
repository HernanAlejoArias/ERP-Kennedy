package com.kennedy.erp.repositories;

import com.kennedy.erp.model.EnvioPublicidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EnvioPublicidadRepository extends JpaRepository<EnvioPublicidad, Long> {
}
