/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;

	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public LivroDto criarLivro(@RequestBody @Valid LivroForm form) 
		throws Exception{
		Livro novoLivro = form.toModel(autorRepository, categoriaRepository);
		return new LivroDto(livroRepository.save(novoLivro));
	}
	
	@GetMapping
	public List<LivrosListagem> listarLivros() {
		return livroRepository
				.findAll()
				.stream()
				.map(e -> new LivrosListagem(e.getId(), e.getTitulo()))
				.collect(Collectors.toList());
	}
	

}
