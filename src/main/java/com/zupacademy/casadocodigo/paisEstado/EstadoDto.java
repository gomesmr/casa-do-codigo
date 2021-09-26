/**
 * 
 */
package com.zupacademy.casadocodigo.paisEstado;

/**
 * @author marcelo.gomes
 *
 */
public class EstadoDto {
	private Long id;
	private String nome;
	private Pais pais;

	/**
	 * @param id
	 * @param nome
	 */
	public EstadoDto(Long id, String nome, Pais pais) {
		this.id = id;
		this.nome = nome;
		this.pais = pais;
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
	 * @return the pais
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}
}
