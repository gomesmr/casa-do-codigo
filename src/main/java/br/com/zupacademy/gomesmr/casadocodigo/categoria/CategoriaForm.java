/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

/**
 * @author marcelo.gomes
 *
 */
public class CategoriaForm {
	@NotBlank (message="Categoria em branco")
	private String nome;


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
