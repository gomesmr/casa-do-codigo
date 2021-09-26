/**
 * 
 */
package com.zupacademy.casadocodigo.livro;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author marcelo.gomes
 *
 */
@RestController
@RequestMapping("/livro")
public class LivroDetalhesController {
	private final LivroRepository livroRepository;

	/**
	 * @param livroRepository
	 */
	public LivroDetalhesController(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@GetMapping("/{id}")
	public LivroDetalheDto listarLivros(@PathVariable @Valid Long id) 
			throws Exception {
		Optional<Livro> livroConsulta = livroRepository.findById(id);
		
		if(!livroConsulta.isEmpty()) {
			LivroDetalheDto livroDetalhado = new LivroDetalheDto(livroConsulta.get());
			return livroDetalhado;
		}
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não localizado");
		
	}

}
