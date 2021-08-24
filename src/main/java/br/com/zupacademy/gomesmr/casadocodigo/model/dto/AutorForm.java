package br.com.zupacademy.gomesmr.casadocodigo.model.dto;

import java.time.LocalDateTime;

import br.com.zupacademy.gomesmr.casadocodigo.model.Autor;

public class AutorForm {
	private String nome;
	private String email;
	private String descricao;
	
	public Autor converter() {
		return new Autor(this.nome, this.email, this.descricao, LocalDateTime.now());
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
	
	
	
}
