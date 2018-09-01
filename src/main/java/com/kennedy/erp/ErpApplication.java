package com.kennedy.erp;

import com.kennedy.erp.model.Cliente;
import com.kennedy.erp.model.EnvioPublicidad;
import com.kennedy.erp.model.TipoCliente;
import com.kennedy.erp.repositories.ClienteRepository;
import com.kennedy.erp.repositories.EnvioPublicidadRepository;
import com.kennedy.erp.repositories.PublicidadRepository;
import com.kennedy.erp.repositories.TipoClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClienteRepository clienteRepository, EnvioPublicidadRepository envioPublicidadRepository,
									  PublicidadRepository publicidadRepository, TipoClienteRepository tipoClienteRepository) {
		return (args) -> {

			TipoCliente tipoCliente1 = new TipoCliente("Consumidor Final");
			tipoClienteRepository.save(tipoCliente1);

			Cliente cliente1 = new Cliente("Hernan Alejo", "Arias", "HernanAlejoArias", 29747542, 20297475429L, 20297475429L, tipoCliente1, "harias1982@gmail.com", "Rangugni 2934");
			clienteRepository.save(cliente1);

			Cliente cliente2 = new Cliente("Marina", "Lucia", "Brand Team", 29601509, 20296015099L, 20296015099L, tipoCliente1, "marinita@gmail.com", "Rangugni 2934");
			clienteRepository.save(cliente2);
		};
	}
}
