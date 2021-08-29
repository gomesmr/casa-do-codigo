/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.livro;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import br.com.zupacademy.gomesmr.casadocodigo.autor.Autor;
import br.com.zupacademy.gomesmr.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.gomesmr.casadocodigo.categoria.Categoria;
import br.com.zupacademy.gomesmr.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.gomesmr.casadocodigo.validator.ExistsId;
import br.com.zupacademy.gomesmr.casadocodigo.validator.UniqueValue;

/**
 * @author marcelo.gomes
 *
 */
public class LivroForm {
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo", message= "Esse título já existe no sistema")
	private String titulo;
	@Size(max = 500)
	private String resumo;
	private String sumario;
	@Min(20)
	private BigDecimal preco;
	@Min(100)
	private BigInteger numPaginas;
	private String isbn;
	@Future
	private LocalDate dataPublicacao;
	@ExistsId(classe = Livro.class, message = "Essa categoria não consta no sistema")
	private Long idCategoria;
	@ExistsId(classe = Livro.class, message = "Autor não cadastrado no sistema")
	private Long idAutor;
	
	/**
	 * Recupera a Categoria e o Autor e retorna um Livro Bonitão 
	 * @param autorRepository
	 * @param categoriaRepository
	 * @return Livro Objeto Livro que será gravado no BD
	 */
	public Livro toModel(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
		Categoria categoria = categoriaRepository.findById(idCategoria).get();
		Autor autor = autorRepository.findById(idAutor).get();
		return new Livro(titulo, resumo, sumario, preco, numPaginas, isbn, dataPublicacao, categoria, autor);
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the resumo
	 */
	public String getResumo() {
		return resumo;
	}

	/**
	 * @param resumo the resumo to set
	 */
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	/**
	 * @return the sumario
	 */
	public String getSumario() {
		return sumario;
	}

	/**
	 * @param sumario the sumario to set
	 */
	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	/**
	 * @return the preco
	 */
	public BigDecimal getPreco() {
		return preco;
	}

	/**
	 * @param preco the preco to set
	 */
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	/**
	 * @return the numPaginas
	 */
	public BigInteger getNumPaginas() {
		return numPaginas;
	}

	/**
	 * @param numPaginas the numPaginas to set
	 */
	public void setNumPaginas(BigInteger numPaginas) {
		this.numPaginas = numPaginas;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the dataPublicacao
	 */
	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	/**
	 * @param dataPublicacao the dataPublicacao to set
	 */
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	/**
	 * @return the idCategoria
	 */
	public Long getIdCategoria() {
		return idCategoria;
	}

	/**
	 * @param idCategoria the idCategoria to set
	 */
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	/**
	 * @return the idAutor
	 */
	public Long getIdAutor() {
		return idAutor;
	}

	/**
	 * @param idAutor the idAutor to set
	 */
	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}



}
