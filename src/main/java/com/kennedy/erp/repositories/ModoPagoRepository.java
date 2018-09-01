package com.kennedy.erp.repositories;

import com.kennedy.erp.model.Cliente;
import com.kennedy.erp.model.ModoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ModoPagoRepository extends JpaRepository<ModoPago, Long> {


}
