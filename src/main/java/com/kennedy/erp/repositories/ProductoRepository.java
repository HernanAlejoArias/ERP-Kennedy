package com.kennedy.erp.repositories;

import com.kennedy.erp.model.Cliente;
import com.kennedy.erp.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductoRepository extends JpaRepository<Producto, Long> {


}
