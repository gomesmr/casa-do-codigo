/**
 * 
 */
package com.zupacademy.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import com.zupacademy.casadocodigo.validator.UniqueValue;

/**
 * @author marcelo.gomes
 *
 */
public class CategoriaForm {
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message= "Esta categoria já consta no sistema.")
	@NotBlank (message="Categoria em branco")
	private String nome;

	/**
	 * @param nome
	 */
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public CategoriaForm(String nome) {
		this.nome = nome;
	}


	public Categoria converter() {
		return new Categoria(this.nome);
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
