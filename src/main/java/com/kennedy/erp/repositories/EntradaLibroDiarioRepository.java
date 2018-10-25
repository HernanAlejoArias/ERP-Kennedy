package com.kennedy.erp.repositories;

import com.kennedy.erp.model.EntradaLibroDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EntradaLibroDiarioRepository extends JpaRepository<EntradaLibroDiario, Long> {


}
