package br.com.zupacademy.gomesmr.casadocodigo.autor;

import java.time.LocalDateTime;

public class AutorDto {
	private Long id;
	private String nome;
	private String email;
	private String descricao;
	private LocalDateTime instanteCriacao;

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
			LocalDateTime instanteCriacao) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.instanteCriacao = instanteCriacao;
	}
	
	public AutorDto(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
		this.instanteCriacao = autor.getInstanteCriacao();
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @param instanteCriacao the instanteCriacao to set
	 */
	public void setInstanteCriacao(LocalDateTime instanteCriacao) {
		this.instanteCriacao = instanteCriacao;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @return the instanteCriacao
	 */
	public LocalDateTime getInstanteCriacao() {
		return instanteCriacao;
	}
	
	
	
	
}
