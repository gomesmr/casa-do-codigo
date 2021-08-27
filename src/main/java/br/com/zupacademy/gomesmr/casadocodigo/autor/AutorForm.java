package br.com.zupacademy.gomesmr.casadocodigo.autor;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.gomesmr.casadocodigo.categoria.Categoria;
import br.com.zupacademy.gomesmr.casadocodigo.validator.UniqueValue;

public class AutorForm {
	@NotBlank (message="Nome em branco")
	private String nome;
	@UniqueValue(domainClass = Autor.class, fieldName = "email", message= "Este e-mail já consta no sistema.")
	@NotBlank(message = "E-mail em branco")
	@Email(message = "E-mail inválido!")
	private String email;
	@NotBlank (message="Insira uma descrição")
	private String descricao;
	
	
	
	/**
	 * @param nome
	 * @param email
	 * @param descricao
	 */
	public AutorForm(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}


	public Autor converter() {
			return new Autor(this.nome, this.email, this.descricao, LocalDateTime.now());
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


	
	
}
