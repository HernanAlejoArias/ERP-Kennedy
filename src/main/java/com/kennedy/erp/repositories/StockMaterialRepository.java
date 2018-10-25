package com.kennedy.erp.repositories;

import com.kennedy.erp.model.StockMaterial;
import com.kennedy.erp.model.StockProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StockMaterialRepository extends JpaRepository<StockMaterial, Long> {
}
