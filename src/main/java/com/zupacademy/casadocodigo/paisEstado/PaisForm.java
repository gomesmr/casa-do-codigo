/**
 * 
 */
package com.zupacademy.casadocodigo.paisEstado;

import javax.validation.constraints.NotBlank;

import com.zupacademy.casadocodigo.validator.UniqueValue;

/**
 * @author marcelo.gomes
 *
 */
public class PaisForm {
	@UniqueValue(domainClass = Pais.class, fieldName = "nome", message= "Este País já consta no sistema.")
	@NotBlank (message="Nome do país em branco")
	private String nome;

	/**
	 * 
	 */
	public PaisForm() {
	}

	/**
	 * @param nome
	 */
	public PaisForm(String nome) {
		this.nome = nome;
	}
	
	public Pais converter() {
		return new Pais(this.nome);
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

}
