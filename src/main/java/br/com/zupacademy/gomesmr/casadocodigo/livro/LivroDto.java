/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.livro;

import java.awt.TextField;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

import br.com.zupacademy.gomesmr.casadocodigo.autor.Autor;
import br.com.zupacademy.gomesmr.casadocodigo.categoria.Categoria;

/**
 * @author marcelo.gomes
 *
 */
public class LivroDto {
	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private BigInteger numPaginas;
	private String isbn;
	private LocalDate dataPublicacao;
	private Categoria categoria;
	private Autor autor;

	
	/**
	 * 
	 * @param livro
	 */
	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numPaginas = livro.getNumPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.dataPublicacao();
		this.categoria = livro.getCategoria();
		this.autor = livro.getAutor();
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
	public LocalDate dataPublicacao() {
		return dataPublicacao;
	}
	/**
	 * @param dataPublicação the dataPublicação to set
	 */
	public void setDataPublicação(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
