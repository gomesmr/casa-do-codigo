package br.com.zupacademy.gomesmr.casadocodigo.categoria;

import java.util.List;

import br.com.zupacademy.gomesmr.casadocodigo.livro.Livro;

public class CategoriaDto {
	private Long id;
	private String nome;
	private List<Livro> livrosDestaCategoria;

	/**
	 * @param nome
	 */
	public CategoriaDto(Long id, String nome, List<Livro> livrosDestaCategoria) {
		this.id = id;
		this.nome = nome;
		this.livrosDestaCategoria = livrosDestaCategoria;
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the livrosDestaCategoria
	 */
	public List<Livro> getLivrosDestaCategoria() {
		return livrosDestaCategoria;
	}

	/**
	 * @param livrosDestaCategoria the livrosDestaCategoria to set
	 */
	public void setLivrosDestaCategoria(List<Livro> livrosDestaCategoria) {
		this.livrosDestaCategoria = livrosDestaCategoria;
	}
	
	

}
