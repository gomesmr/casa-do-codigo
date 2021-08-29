/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.paisEstados;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * @author marcelo.gomes
 *
 */
public class PaisDto {
	private Long id;
	private String nome;

	/**
	 * @param id
	 * @param nome
	 */
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public PaisDto(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public PaisDto(Pais pais) {
		this.id = pais.getId();
		this.nome = pais.getNome();
	}

	/**
	 * @return the id
	 */
	Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	void setNome(String nome) {
		this.nome = nome;
	}

	

}
