package com.kennedy.erp;

import com.kennedy.erp.model.*;
import com.kennedy.erp.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
									  PedidoCabeceraRepository pedidoCabeceraRepository, PedidoDetalleRepository pedidoDetalleRepository,
									  StockProduccionRepository stockProductosRepository, ProveedorRepository proveedorRepository,
									  MaterialRepository materialRepository, CuentaContableRepository cuentaContableRepository,
									  FamiliaresRepository familiaresRepository, CategoriaRepository categoriaRepository,
									  CarreraRepository carreraRepository, EstudiosRepository estudiosRepository
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

			ModoPago efectivo = new ModoPago("Efectivo");
			modoPagoRepository.save(efectivo);

			CuentaContable caja = new CuentaContable("Caja");
			cuentaContableRepository.save(caja);

			CuentaContable iva = new CuentaContable("IVA");
			cuentaContableRepository.save(iva);

			CuentaContable ventaMercaderias = new CuentaContable("Venta de mercaderias");
			cuentaContableRepository.save(ventaMercaderias);

			CuentaContable proveedores = new CuentaContable("Proveedores");
			cuentaContableRepository.save(proveedores);

			CuentaContable percepciones = new CuentaContable("Percepciones");
			cuentaContableRepository.save(percepciones);

			CuentaContable materiales = new CuentaContable("Materiales");
			cuentaContableRepository.save(materiales);

            Producto puertaAluminio = new Producto("Puerta Aluminio", 1030d);

            Producto ventanaAluminio = new Producto("Ventana Aluminio", 550d);

            Producto ventanaHierro = new Producto("Ventana Hierro", 700d);

			StockProducto entradaProducto1 = new StockProducto(puertaAluminio, 99);

			StockProducto entradaProducto2 = new StockProducto(ventanaAluminio, 10);

			StockProducto entradaProducto3 = new StockProducto(ventanaHierro, 2);

            puertaAluminio.setStock(entradaProducto1);
            productoRepository.save(puertaAluminio);

            ventanaAluminio.setStock(entradaProducto2);
            productoRepository.save(ventanaAluminio);

            ventanaHierro.setStock(entradaProducto3);
            productoRepository.save(ventanaHierro);

			Set<PedidoDetalle> pedidoDetalle = new HashSet<>();
			PedidoDetalle item1 = new PedidoDetalle(puertaAluminio, 2);
			pedidoDetalle.add(item1);

			//pedidoDetalleRepository.save(item1);

			PedidoDetalle item2 = new PedidoDetalle(ventanaHierro, 6);
			pedidoDetalle.add(item2);
			//pedidoDetalleRepository.save(item2);

			PedidoCabecera pedido1cab = new PedidoCabecera(cliente2, vendedor1, efectivo);
			pedido1cab.setItems(pedidoDetalle);
			pedidoCabeceraRepository.save(pedido1cab);

			Set<PedidoDetalle> tempItems = new HashSet<>();
			tempItems.add(item1);
			pedido1cab.setItems(tempItems);

			Proveedor proveedor1 = new Proveedor("Hernan Alejo", "Proveedor", "HernanAlejoArias", 29747542L, 20297475429L, 20297475429L, "harias1982@gmail.com", "Rangugni 2934");
			proveedorRepository.save(proveedor1);

			Proveedor proveedor2 = new Proveedor("Marina", "Proveedor", "Brand Team", 29601509L, 20296015099L, 20296015099L, "marinita@gmail.com", "Rangugni 2934");
			proveedorRepository.save(proveedor2);

			Material hierro = new Material("Hierro");

			Material aluminio = new Material("Aluminio");

			StockMaterial entradaMaterial1 = new StockMaterial(hierro, 100);

			StockMaterial entradaMaterial2 = new StockMaterial(aluminio, 30);

			hierro.setStock(entradaMaterial1);
			materialRepository.save(hierro);

			aluminio.setStock(entradaMaterial2);
			materialRepository.save(aluminio);

			Familiares familiares1 = new Familiares("Javier","Matias", 33401049,empleado1,"jmk.fernandez@gmail.com","Primo");
			familiaresRepository.save(familiares1);

			Categoria categoria1 = new Categoria("A1");
			categoriaRepository.save(categoria1);

			Categoria categoria2 = new Categoria("A2");
			categoriaRepository.save(categoria2);

			Categoria categoria3 = new Categoria("A3");
			categoriaRepository.save(categoria3);

			Carrera carrera1 = new Carrera(empleado1,categoria2,"10/10/2010","10/10/2015");
			carreraRepository.save(carrera1);

			Estudios estudios1 = new Estudios(empleado1,"Secundario");
			estudiosRepository.save(estudios1);
		};
	}
}
