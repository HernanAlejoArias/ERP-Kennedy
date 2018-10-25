package com.kennedy.erp.repositories;

import com.kennedy.erp.model.OrdenTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrdenTrabajoRepository extends JpaRepository<OrdenTrabajo, Long> {
}
