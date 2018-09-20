package com.kennedy.erp.repositories;

import com.kennedy.erp.model.TipoCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TipoClienteRepository extends JpaRepository<TipoCliente, Integer> {
}
