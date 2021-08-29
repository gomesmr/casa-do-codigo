/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.paisEstado;

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
@RequestMapping("/pais")
public class PaisController {
	private final PaisRepository paisRepository;

	/**
	 * @param paisRepository
	 */
	public PaisController(PaisRepository paisRepository) {
		this.paisRepository = paisRepository;
	}

	@PostMapping
	private ResponseEntity<PaisDto> cadastra(@RequestBody @Valid PaisForm form) 
			throws Exception {
		Pais pais = paisRepository.save(form.converter());

		PaisDto paisDto = new PaisDto(pais);
		return ResponseEntity.status(HttpStatus.CREATED).body(paisDto);

	}

}
