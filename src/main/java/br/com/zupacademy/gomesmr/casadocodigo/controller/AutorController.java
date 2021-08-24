package br.com.zupacademy.gomesmr.casadocodigo.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
	private ResponseEntity<AutorDto> cadastrar(@RequestBody AutorForm autorForm, UriComponentsBuilder uriBuilder){
		Autor autor = autorForm.converter();
		autorRepository.save(autor);
		URI uri = uriBuilder.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).body(new AutorDto(autor));
    }
		
		
}
	


