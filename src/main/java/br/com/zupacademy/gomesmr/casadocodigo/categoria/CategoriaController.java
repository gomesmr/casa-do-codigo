/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.categoria;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gomesmr.casadocodigo.validator.VerificaCategoriaDuplicadaValidator;

/**
 * @author marcelo.gomes
 *
 */
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	private final CategoriaRepository categoriaRepository;
	private final VerificaCategoriaDuplicadaValidator verificaCategoriaDuplicadaValidator;


	/**
	 * Injeção de Dependência
	 * @param categoriaRepository
	 * @param verificaCategoriaDuplicadaValidator
	 */
	public CategoriaController(CategoriaRepository categoriaRepository, VerificaCategoriaDuplicadaValidator verificaCategoriaDuplicadaValidator) {
		this.categoriaRepository = categoriaRepository;
		this.verificaCategoriaDuplicadaValidator = verificaCategoriaDuplicadaValidator;
	}
	
	/**
	 * Realiza configurações adicionais na Request deste Controller
	 * @param binder
	 */
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(verificaCategoriaDuplicadaValidator);
	}
	
	@PostMapping
	private ResponseEntity<CategoriaDto> cadastra(@RequestBody @Valid CategoriaForm categoriaForm){
		Categoria novaCategoria = categoriaForm.converter();
		categoriaRepository.save(novaCategoria);
		
		CategoriaDto categoriaDto = novaCategoria.resposta();
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaDto);
	}



}
