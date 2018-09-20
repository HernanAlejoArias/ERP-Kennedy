package com.kennedy.erp;

import com.kennedy.erp.model.*;
import com.kennedy.erp.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClienteRepository clienteRepository, EnvioPublicidadRepository envioPublicidadRepository,
									  PublicidadRepository publicidadRepository, TipoClienteRepository tipoClienteRepository,
									  EmpleadoRepository empleadoRepository, VendedorRepository vendedorRepository,
									  ProductoRepository productoRepository, ModoPagoRepository modoPagoRepository,
									  PedidoCabeceraRepository pedidoCabeceraRepository, PedidoDetalleRepository pedidoDetalleRepository

									) {
		return (args) -> {

			TipoCliente tipoCliente1 = new TipoCliente("Consumidor Final");
			tipoClienteRepository.save(tipoCliente1);

			TipoCliente tipoCliente2 = new TipoCliente("Responsable Inscripto");
			tipoClienteRepository.save(tipoCliente2);

			TipoCliente tipoCliente3 = new TipoCliente("Monotributista");
			tipoClienteRepository.save(tipoCliente3);

			Cliente cliente1 = new Cliente("Hernan Alejo", "Arias", "HernanAlejoArias", 29747542L, 20297475429L, 20297475429L, tipoCliente1, "harias1982@gmail.com", "Rangugni 2934");
			clienteRepository.save(cliente1);

			Cliente cliente2 = new Cliente("Marina", "Lucia", "Brand Team", 29601509L, 20296015099L, 20296015099L, tipoCliente1, "marinita@gmail.com", "Rangugni 2934");
			clienteRepository.save(cliente2);

			Empleado empleado1 = new Empleado("Mauro", "Diaz", 20998337L, 20209983374L, 20209983374L, "La casa de el 123", "mauro@hotmail.com");
			empleadoRepository.save(empleado1);

			Vendedor vendedor1 = new Vendedor(empleado1);
			vendedorRepository.save(vendedor1);

			Producto metalPesado = new Producto("Metal Pesado");
			productoRepository.save(metalPesado);

			Producto cobre = new Producto("Cobre");
			productoRepository.save(metalPesado);

			Producto aluminio = new Producto("Aluminio");
			productoRepository.save(metalPesado);

			ModoPago efectivo = new ModoPago("Efectivo");
			modoPagoRepository.save(efectivo);

			Set<PedidoDetalle> pedidoDetalle = new HashSet<>();
			PedidoDetalle item1 = new PedidoDetalle(metalPesado, 2);
			pedidoDetalle.add(item1);

			//pedidoDetalleRepository.save(item1);

			PedidoDetalle item2 = new PedidoDetalle(metalPesado, 6);
			pedidoDetalle.add(item2);
			//pedidoDetalleRepository.save(item2);

			PedidoCabecera pedido1cab = new PedidoCabecera(cliente2, vendedor1, efectivo);
			pedido1cab.setItems(pedidoDetalle);
			pedidoCabeceraRepository.save(pedido1cab);

			Set<PedidoDetalle> tempItems = new HashSet<>();
			tempItems.add(item1);
			pedido1cab.setItems(tempItems);

		};
	}
}
