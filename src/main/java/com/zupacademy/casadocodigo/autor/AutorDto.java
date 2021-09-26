package com.zupacademy.casadocodigo.autor;

import java.time.LocalDateTime;
import java.util.List;

import com.zupacademy.casadocodigo.livro.Livro;

public class AutorDto {
	private Long id;
	private String nome;
	private String email;
	private String descricao;
	private LocalDateTime instanteCriacao;
	private List<Livro> livrosDesteAutor;

	/**
	 * @param id
	 * @param nome
	 * @param email
	 * @param descricao
	 * @param instanteCriacao
	 */
	public AutorDto(Long id, 
			String nome, 
			String email, 
			String descricao, 
			LocalDateTime instanteCriacao,
			List<Livro> livrosDesteAutor) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.instanteCriacao = instanteCriacao;
		this.livrosDesteAutor = livrosDesteAutor;
	}
	
	public AutorDto(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
		this.instanteCriacao = autor.getInstanteCriacao();
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the instanteCriacao
	 */
	public LocalDateTime getInstanteCriacao() {
		return instanteCriacao;
	}

	/**
	 * @param instanteCriacao the instanteCriacao to set
	 */
	public void setInstanteCriacao(LocalDateTime instanteCriacao) {
		this.instanteCriacao = instanteCriacao;
	}

	/**
	 * @return the livrosDesteAutor
	 */
	public List<Livro> getLivrosDesteAutor() {
		return livrosDesteAutor;
	}

	/**
	 * @param livrosDesteAutor the livrosDesteAutor to set
	 */
	public void setLivrosDesteAutor(List<Livro> livrosDesteAutor) {
		this.livrosDesteAutor = livrosDesteAutor;
	}


	
	
	
	
}
