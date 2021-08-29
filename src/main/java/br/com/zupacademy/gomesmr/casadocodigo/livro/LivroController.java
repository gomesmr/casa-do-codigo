/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.livro;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gomesmr.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.gomesmr.casadocodigo.categoria.CategoriaRepository;

/**
 * @author marcelo.gomes
 *
 */
@RestController
@RequestMapping("/livro")
public class LivroController {
	private final LivroRepository livroRepository;
	private final AutorRepository autorRepository;
	private final CategoriaRepository categoriaRepository;

	/**
	 * @param livroRepository
	 */
	public LivroController(LivroRepository livroRepository,
								AutorRepository autorRepository,
								CategoriaRepository categoriaRepository) {
		this.livroRepository = livroRepository;
		this.autorRepository = autorRepository;
		this.categoriaRepository = categoriaRepository;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public LivroDto criarLivro(@RequestBody @Valid LivroForm form) 
		throws Exception{
		Livro novoLivro = form.toModel(autorRepository, categoriaRepository);
		return new LivroDto(livroRepository.save(novoLivro));
	}
	
	

}
