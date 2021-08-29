/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<LivroDetalheDto> listarLivros(@PathVariable Long id) {
		return livroRepository
				.findById(id)
				.stream()
				.map(e -> new LivroDetalheDto(e.getId(), e.getTitulo(), e.getResumo(),
						e.getSumario(), e.getPreco(), e.getNumPaginas(), e.getIsbn(),
						e.getDataPublicacao(), e.getAutor() ))
				.collect(Collectors.toList());
	}

}
