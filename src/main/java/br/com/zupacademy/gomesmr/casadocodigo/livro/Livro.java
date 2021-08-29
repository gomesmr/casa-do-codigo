/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.livro;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import br.com.zupacademy.gomesmr.casadocodigo.autor.Autor;
import br.com.zupacademy.gomesmr.casadocodigo.categoria.Categoria;

/**
 * @author marcelo.gomes
 *
 */
@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String titulo;
	@Size(max = 500)
	private String resumo;
	@NotBlank
	private String sumario;
	@NotNull
	@Min(20)
	private BigDecimal preco;
	@NotNull
	@Min(100)
	private BigInteger numPaginas;
	@NotBlank
	private String isbn;
	@NotNull
	@Future
	private LocalDate dataPublicacao;
	@NotNull 
	//@Valid
	@ManyToOne
	@JoinColumn(name = "idCategoria")
	private Categoria categoria;
	@NotNull 
	//@Valid
	@ManyToOne
	@JoinColumn(name = "idAutor")
	private Autor autor;
	
	@Deprecated
	public Livro() {}

	/**
	 * @param id
	 * @param titulo
	 * @param resumo
	 * @param sumario
	 * @param preço
	 * @param numPaginas
	 * @param isbn
	 * @param dataPublicação
	 * @param categoria
	 * @param autor
	 */
	public Livro(String titulo, String resumo, String sumario, BigDecimal preco, BigInteger numPaginas,
			String isbn, LocalDate dataPublicacao, Categoria categoria, Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numPaginas = numPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @return the resumo
	 */
	public String getResumo() {
		return resumo;
	}

	/**
	 * @return the sumario
	 */
	public String getSumario() {
		return sumario;
	}

	/**
	 * @return the preco
	 */
	public BigDecimal getPreco() {
		return preco;
	}

	/**
	 * @return the numPaginas
	 */
	public BigInteger getNumPaginas() {
		return numPaginas;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @return the dataPublicação
	 */
	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @return the autor
	 */
	public Autor getAutor() {
		return autor;
	}
	
	
	

}
