package br.com.zupacademy.gomesmr.casadocodigo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gomesmr.casadocodigo.model.Autor;
import br.com.zupacademy.gomesmr.casadocodigo.model.dto.AutorDto;
import br.com.zupacademy.gomesmr.casadocodigo.model.dto.AutorForm;
import br.com.zupacademy.gomesmr.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {
	private final AutorRepository autorRepository;

	/**
	 * @param autorRepository
	 */
	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	@PostMapping
	private ResponseEntity<AutorDto> cadastrar(@RequestBody AutorForm autorForm)
			throws Exception{
		Autor autor = autorForm.converter();
		autorRepository.save(autor);
		
		AutorDto autorDto = autor.resposta();
		return ResponseEntity.status(HttpStatus.CREATED).body(autorDto);


    }
		
		
}
	


