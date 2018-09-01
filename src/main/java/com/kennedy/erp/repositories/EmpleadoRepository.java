package com.kennedy.erp.repositories;

import com.kennedy.erp.model.Cliente;
import com.kennedy.erp.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {


}
