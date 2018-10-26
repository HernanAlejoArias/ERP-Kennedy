package com.kennedy.erp.controller;

import com.kennedy.erp.model.*;
import com.kennedy.erp.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ERPController {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    VendedorRepository vendedorRepository;

    @Autowired
    ModoPagoRepository modoPagoRepository;

    @Autowired
    TipoClienteRepository tipoClienteRepository;

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    PedidoCabeceraRepository pedidoCabeceraRepository;

    @Autowired
    FacturaCabeceraRepository facturaCabeceraRepository;

    @Autowired
    FacturaDetalleRepository facturaDetalleRepository;

    @Autowired
    OrdenTrabajoRepository ordenTrabajoRepository;

    @Autowired
    ProveedorRepository proveedorRepository;

    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    PedidoMaterialCabeceraRepository pedidoMaterialCabeceraRepository;

    @Autowired
    StockMaterialRepository stockMaterialRepository;

    @Autowired
    CuentaContableRepository cuentaContableRepository;

    @Autowired
    LibroDiarioRepository libroDiarioRepository;


    @PostMapping("/guardar-cliente")
    public ResponseEntity guardarCliente (@RequestBody ClienteDTO clienteDTO){

        long messageClienteUpdated;

        Optional<Cliente> clienteSeleccionado = clienteRepository.findById(clienteDTO.getId());

        TipoCliente tipoClienteSeleccionado = tipoClienteRepository.findById(clienteDTO.getIdTipoCliente()).orElse(null);

        if (clienteSeleccionado.isPresent()){

            clienteSeleccionado.get().setNombre(clienteDTO.getNombre());
            clienteSeleccionado.get().setApellido(clienteDTO.getApellido());
            clienteSeleccionado.get().setRazonSocial(clienteDTO.getRazonSocial());
            clienteSeleccionado.get().setDni(clienteDTO.getDni());
            clienteSeleccionado.get().setCuil(clienteDTO.getCuil());
            clienteSeleccionado.get().setCuit(clienteDTO.getCuit());
            clienteSeleccionado.get().setTipo_cliente(tipoClienteSeleccionado);
            clienteSeleccionado.get().setMail(clienteDTO.getMail());
            clienteSeleccionado.get().setDireccion(clienteDTO.getDireccion());

            clienteRepository.save(clienteSeleccionado.get());

            messageClienteUpdated = clienteSeleccionado.get().getId();
        } else {

            Cliente nuevoCliente = new Cliente(
                    clienteDTO.getNombre(),
                    clienteDTO.getApellido(),
                    clienteDTO.getRazonSocial(),
                    clienteDTO.getDni(),
                    clienteDTO.getCuil(),
                    clienteDTO.getCuit(),
                    tipoClienteSeleccionado,
                    clienteDTO.getMail(),
                    clienteDTO.getDireccion()
            );

            clienteRepository.save(nuevoCliente);

            messageClienteUpdated = nuevoCliente.getId();
        }

        Map<String, Long> responseMessage = new HashMap<>();
        responseMessage.put("ID Cliente", messageClienteUpdated);
        return  new ResponseEntity<>(responseMessage , HttpStatus.CREATED);
    }

    @GetMapping("/buscar-cliente/{idCliente}")
    public ResponseEntity getCliente (@PathVariable("idCliente") long idCliente){

        Optional<Cliente> clienteSeleccionado = clienteRepository.findById(idCliente);

        System.out.println("LLEGO EL GET");

        if (clienteSeleccionado.isPresent()){
            System.out.println("CLIENT_FOUND");
            System.out.println("clienteSeleccionado.get()");

            return new ResponseEntity<>(clienteSeleccionado.get().makeDTOCliente(), HttpStatus.OK);

        }else{
            System.out.println("ERROR_CLIENT_NOT_FOUND");
            return new ResponseEntity<>(ResponseMessages.ERROR_CLIENT_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/buscar-pedido/{idPedido}")
    public ResponseEntity getPedido(@PathVariable("idPedido") long idPedido){

        Optional<PedidoCabecera> pedidoSeleccionado = pedidoCabeceraRepository.findById(idPedido);
        System.out.println("BUSCAR PEDIDO");

        if(!pedidoSeleccionado.isPresent()){
            return new ResponseEntity<>(ResponseMessages.ERROR_ORDER_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

        System.out.println("OK");
        return new ResponseEntity<>(pedidoSeleccionado.get().makeDTO(), HttpStatus.OK);

    }

    @PostMapping("/alta-pedido")
    public ResponseEntity altaPedido (@RequestBody PedidoDTO pedidoDTO){

        System.out.println("ALTA PEDIDO");

        PedidoCabecera nuevoPedidoCabecera;
        PedidoDetalle nuevoPedidoDetalle;
        Set<PedidoDetalle> items = new HashSet<>();

        Optional<Cliente> cliente = clienteRepository.findById(pedidoDTO.getIdCliente());
        Optional<Vendedor> vendedor = vendedorRepository.findById(pedidoDTO.getIdVendedor());
        Optional<ModoPago> modoPago = modoPagoRepository.findById(pedidoDTO.getIdModoPago());

        if (!cliente.isPresent()){
            return new ResponseEntity<>(ResponseMessages.ERROR_CLIENT_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

        if (!vendedor.isPresent()){
            return new ResponseEntity<>(ResponseMessages.ERROR_SALER_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

        if (!modoPago.isPresent()){
            return new ResponseEntity<>(ResponseMessages.ERROR_PAYMODE_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

        nuevoPedidoCabecera = new PedidoCabecera(cliente.get(), vendedor.get(), modoPago.get());

        for (Item item : pedidoDTO.getItems() ) {
            Optional<Producto> producto = productoRepository.findById(item.getProducto());

            System.out.println(item.getProducto());
            System.out.println(producto.get());


            if (producto.isPresent()) {
                nuevoPedidoDetalle = new PedidoDetalle(producto.get(), item.getCantidad());
                items.add(nuevoPedidoDetalle);

            }else{
                return new ResponseEntity<>(makeMap(ResponseMessages.ERROR_PRODUCT_NOT_FOUND, item.getProducto()), HttpStatus.BAD_REQUEST);
            }
        }

        nuevoPedidoCabecera.setItems(items);
        pedidoCabeceraRepository.save(nuevoPedidoCabecera);

        return new ResponseEntity<>(makeMap("NuevoPedido", nuevoPedidoCabecera.getId()), HttpStatus.OK);
    }

    @PostMapping("/facturar/{idPedido}")
    public ResponseEntity facturar (@PathVariable("idPedido") long idPedido){

        Optional<PedidoCabecera> pedido = pedidoCabeceraRepository.findById(idPedido);
        FacturaDetalle facturaDetalle;
        FacturaCabecera facturaCabecera;
        Set<FacturaDetalle> items = new HashSet<>();

        if(pedido.isPresent()){

            facturaCabecera = new FacturaCabecera(pedido.get().getCliente(), pedido.get().getVendedor(), pedido.get().getModoPago());

            for (PedidoDetalle item : pedido.get().getItems() ) {

               facturaDetalle = new FacturaDetalle(item.getProducto(), item.getCantidad(), item.getProducto().getPrecio());
               items.add(facturaDetalle);

            }

            facturaCabecera.setItems(items);
            facturaCabeceraRepository.save(facturaCabecera);

            return new ResponseEntity<>(makeMap("NuevaFactura", facturaCabecera.getId()), HttpStatus.OK);

        }else{
            return new ResponseEntity<>(ResponseMessages.ERROR_ORDER_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/validar-stock/{idPedido}")
    public  ResponseEntity validateStock(@PathVariable("idPedido") long idPedido){

        Optional<PedidoCabecera> pedido = pedidoCabeceraRepository.findById(idPedido);

        if(pedido.isPresent()){

            for (PedidoDetalle item : pedido.get().getItems() ) {

                if(item.getProducto().getStock().getCantidad() < item.getCantidad()){
                    return new ResponseEntity<>(ResponseMessages.ERROR_NO_STOCK_AVAILABLE, HttpStatus.EXPECTATION_FAILED);
                }
            }

            return new ResponseEntity<>(ResponseMessages.STOCK_OK, HttpStatus.OK);

        }else{
            return new ResponseEntity<>(ResponseMessages.ERROR_ORDER_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/crear-orden-trabajo/{idPedido}")
    public ResponseEntity createOT(@PathVariable("idPedido") long idPedido){

        Optional<PedidoCabecera> pedido = pedidoCabeceraRepository.findById(idPedido);
        List<Long> ordenesCreadas = new ArrayList<>();

        if(pedido.isPresent()){

            for (PedidoDetalle item : pedido.get().getItems() ) {

                if(item.getProducto().getStock().getCantidad() < item.getCantidad()){

                    OrdenTrabajo ordenTrabajo = new OrdenTrabajo(item.getProducto(), item.getCantidad());
                    ordenTrabajoRepository.save(ordenTrabajo);

                    ordenesCreadas.add(ordenTrabajo.getId());

                }
            }

            return new ResponseEntity<>(makeMap("OrdenesCreadas", ordenesCreadas), HttpStatus.OK);

        }else{
            return new ResponseEntity<>(ResponseMessages.ERROR_ORDER_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/alta-pedido-material")
    public ResponseEntity altaPedidoMaterial (@RequestBody PedidoDTOMaterial pedidoDTOMaterial){

        System.out.println("ALTA PEDIDO MATERIAL");

        PedidoMaterialCabecera nuevoPedidoCabecera;
        PedidoMaterialDetalle nuevoPedidoDetalle;
        Set<PedidoMaterialDetalle> items = new HashSet<>();

        Optional<Proveedor> proveedor = proveedorRepository.findById(pedidoDTOMaterial.getIdProveedor());

        if (!proveedor.isPresent()){
            return new ResponseEntity<>(ResponseMessages.ERROR_PROVIDER_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

        nuevoPedidoCabecera = new PedidoMaterialCabecera(proveedor.get());

        for (ItemMaterial item : pedidoDTOMaterial.getItems() ) {
            Optional<Material> material = materialRepository.findById(item.getMaterial());

            if (material.isPresent()) {
                nuevoPedidoDetalle = new PedidoMaterialDetalle(material.get(), item.getCantidad());
                items.add(nuevoPedidoDetalle);

            }else{
                return new ResponseEntity<>(makeMap(ResponseMessages.ERROR_MATERIAL_NOT_FOUND, item.getMaterial()), HttpStatus.BAD_REQUEST);
            }
        }

        nuevoPedidoCabecera.setItems(items);
        pedidoMaterialCabeceraRepository.save(nuevoPedidoCabecera);

        return new ResponseEntity<>(makeMap("NuevoPedidoMaterial", nuevoPedidoCabecera.getId()), HttpStatus.OK);
    }

    @GetMapping("/buscar-pedido-material/{idPedido}")
    public ResponseEntity getPedidoMaterial(@PathVariable("idPedido") long idPedido){

        Optional<PedidoMaterialCabecera> pedidoSeleccionado = pedidoMaterialCabeceraRepository.findById(idPedido);

        if(!pedidoSeleccionado.isPresent()){
            return new ResponseEntity<>(ResponseMessages.ERROR_ORDER_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

        System.out.println("OK");
        return new ResponseEntity<>(pedidoSeleccionado.get().makeDTO(), HttpStatus.OK);

    }

    @PostMapping("/entrada-material/{idPedido}")
    public ResponseEntity materialEntry(@PathVariable("idPedido") long idPedido){

        Optional<PedidoMaterialCabecera> pedido = pedidoMaterialCabeceraRepository.findById(idPedido);
        double monto;

        LibroDiario libroDiario = new LibroDiario();


        if(pedido.isPresent()){

            for (PedidoMaterialDetalle item : pedido.get().getItems() ) {

                StockMaterial entradaMaterial = item.getMaterial().getStock();
                entradaMaterial.setCantidad(item.getCantidad());

                monto = item.getPrecio() * item.getCantidad();

                stockMaterialRepository.save(entradaMaterial);

                Optional<CuentaContable> proveedores = cuentaContableRepository.findById(4l);
                EntradaLibroDiario eldProveedores = new EntradaLibroDiario(proveedores.get(),monto, DebeHaber.HABER );
                libroDiario.addEntradaLibroDiario(eldProveedores);

                Optional<CuentaContable> iva = cuentaContableRepository.findById(2l);
                EntradaLibroDiario eldiva = new EntradaLibroDiario(iva.get(),monto * 0.21, DebeHaber.DEBE);
                libroDiario.addEntradaLibroDiario(eldiva);

                Optional<CuentaContable> percepciones = cuentaContableRepository.findById(5l);
                EntradaLibroDiario eldPercepciones= new EntradaLibroDiario(percepciones.get(),monto * 0.1, DebeHaber.DEBE );
                libroDiario.addEntradaLibroDiario(eldPercepciones);

                Optional<CuentaContable> materiales = cuentaContableRepository.findById(6l);
                EntradaLibroDiario eldMateriales = new EntradaLibroDiario(proveedores.get(),monto - (monto * 0.21) - (monto * 0.1), DebeHaber.DEBE );
                libroDiario.addEntradaLibroDiario(eldMateriales);

                libroDiarioRepository.save(libroDiario);

            }

            return new ResponseEntity<>(ResponseMessages.ENTRY_OK, HttpStatus.OK);

        }else{
            return new ResponseEntity<>(ResponseMessages.ERROR_ORDER_NOT_FOUND, HttpStatus.BAD_REQUEST);
        }

    }

    private Map<String, Object> makeMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

}
