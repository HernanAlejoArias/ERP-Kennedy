package com.kennedy.erp.repositories;

import com.kennedy.erp.model.FacturaDetalle;
import com.kennedy.erp.model.PedidoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FacturaDetalleRepository extends JpaRepository<FacturaDetalle, Long> {


}
