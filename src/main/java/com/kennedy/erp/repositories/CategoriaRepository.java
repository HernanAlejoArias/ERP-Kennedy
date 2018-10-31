package com.kennedy.erp.repositories;

import com.kennedy.erp.model.Categoria;
import com.kennedy.erp.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}
