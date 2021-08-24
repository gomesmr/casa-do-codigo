package br.com.zupacademy.gomesmr.casadocodigo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String descricao;
	private LocalDateTime instanteCriacao;
	
	
	@Deprecated
	public Autor() {}


	public Autor(Long id,
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

	public Autor(String nome, 
			String email, 
			String descricao, 
			LocalDateTime instanteCriacao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
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
