package com.kennedy.erp.repositories;

import com.kennedy.erp.model.LibroDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LibroDiarioRepository extends JpaRepository<LibroDiario, Long> {
}
