package br.com.zupacademy.gomesmr.casadocodigo.autor;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorForm {
	@NotBlank (message="Nome em branco")
	private String nome;
	@NotBlank(message = "E-mail em branco")
	@Email(message = "E-mail inválido!")
	private String email;
	@NotBlank (message="Insira uma descrição")
	private String descricao;
	
	public Autor converter() {
		//if (naoExisteEmail(this.email)) {
			return new Autor(this.nome, this.email, this.descricao, LocalDateTime.now());
		}
		//return null;
	// }

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
