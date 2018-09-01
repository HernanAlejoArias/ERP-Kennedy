package com.kennedy.erp.repositories;

import com.kennedy.erp.model.Cliente;
import com.kennedy.erp.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {


}
