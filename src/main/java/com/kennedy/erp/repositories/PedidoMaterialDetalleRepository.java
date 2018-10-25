package com.kennedy.erp.repositories;

import com.kennedy.erp.model.PedidoDetalle;
import com.kennedy.erp.model.PedidoMaterialDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PedidoMaterialDetalleRepository extends JpaRepository<PedidoMaterialDetalle, Long> {


}
