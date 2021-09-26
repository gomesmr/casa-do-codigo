/**
 * 
 */
package com.zupacademy.casadocodigo.paisEstado;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author marcelo.gomes
 *
 */
@RestController
@RequestMapping("/estado")
public class EstadoController {
	private EstadoRepository estadoRepository;
	private PaisRepository paisRepository;

	/**
	 * @param EstadoRepository
	 */
	public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository) {
		this.estadoRepository = estadoRepository;
		this.paisRepository = paisRepository;
	}
	
	@PostMapping
	private ResponseEntity <EstadoDto> cadastra(@RequestBody @Valid EstadoForm form)
		throws Exception{
			Estado estado = form.converter(paisRepository);
			estadoRepository.save(estado);
			
			EstadoDto estadoDto = estado.resposta();
			return ResponseEntity.status(HttpStatus.CREATED).body(estadoDto);
		
	}

}

