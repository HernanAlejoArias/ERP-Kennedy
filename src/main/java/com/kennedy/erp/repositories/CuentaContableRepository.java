package com.kennedy.erp.repositories;

import com.kennedy.erp.model.CuentaContable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CuentaContableRepository extends JpaRepository<CuentaContable, Long> {


}
