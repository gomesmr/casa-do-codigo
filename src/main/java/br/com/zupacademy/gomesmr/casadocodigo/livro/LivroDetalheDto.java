/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.livro;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.gomesmr.casadocodigo.autor.Autor;
import br.com.zupacademy.gomesmr.casadocodigo.autor.AutorDetalheDto;

/**
 * @author marcelo.gomes
 *
 */
public class LivroDetalheDto {
	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private BigInteger numPaginas;
	private String isbn;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPublicacao;
	private Autor autor;

	//AutorDetalheDto autorDetalhe.autorToDetalhe(autor);

	/**
	 * 
	 * @param id
	 * @param titulo
	 * @param resumo
	 * @param sumario
	 * @param preco
	 * @param numPaginas
	 * @param isbn
	 * @param dataPublicacao
	 * @param autor
	 */
	public LivroDetalheDto(Long id, String titulo, String resumo, String sumario, BigDecimal preco,
			BigInteger numPaginas, String isbn, LocalDate dataPublicacao, Autor autor) {
		this.id = id;
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numPaginas = numPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the dataPublicação
	 */
	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}
	/**
	 * @param dataPublicação the dataPublicação to set
	 */
	public void setDataPublicação(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	/**
	 * @return the autor
	 */
	public Autor getAutor() {
		return autor;
	}
	/**
	 * @param autor the autor to set
	 */
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	
}
