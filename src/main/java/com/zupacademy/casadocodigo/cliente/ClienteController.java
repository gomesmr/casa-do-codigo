/**
 * 
 */
package com.zupacademy.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zupacademy.casadocodigo.paisEstado.EstadoRepository;
import com.zupacademy.casadocodigo.paisEstado.PaisRepository;

/**
 * @author marcelo.gomes
 *
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private EstadoRepository estadoRepository;

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm form)
		throws Exception{
		Cliente novoCliente = form.toModel(manager);
		ClienteDto clienteDto = new ClienteDto(clienteRepository.save(novoCliente));
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteDto);
	}
	
}
