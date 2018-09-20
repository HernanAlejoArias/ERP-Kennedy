package com.kennedy.erp.controller;

import com.kennedy.erp.model.Cliente;
import com.kennedy.erp.model.TipoCliente;
import com.kennedy.erp.repositories.ClienteRepository;
import com.kennedy.erp.repositories.TipoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ERPController {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    TipoClienteRepository tipoClienteRepository;

    @PostMapping("/alta-cliente")
    public ResponseEntity altaCliente (@RequestBody ClienteData nuevoClienteData){


        TipoCliente tipoClienteSeleccionado = tipoClienteRepository.findById(nuevoClienteData.getIdTipoCliente()).orElse(null);
        System.out.println(nuevoClienteData.getIdTipoCliente());
        System.out.println(tipoClienteSeleccionado);

        Cliente nuevoCliente = new Cliente(
                nuevoClienteData.getNombre(),
                nuevoClienteData.getApellido(),
                nuevoClienteData.getRazonSocial(),
                nuevoClienteData.getDni(),
                nuevoClienteData.getCuil(),
                nuevoClienteData.getCuit(),
                tipoClienteSeleccionado,
                nuevoClienteData.getMail(),
                nuevoClienteData.getDireccion()
        );

        clienteRepository.save(nuevoCliente);

        Map<String, Long> responseMessage = new HashMap<>();
        responseMessage.put("ID Cliente", nuevoCliente.getId());
        return  new ResponseEntity<>(responseMessage , HttpStatus.CREATED);
    }
}
