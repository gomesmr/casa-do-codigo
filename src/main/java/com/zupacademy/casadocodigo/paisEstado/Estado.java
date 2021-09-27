/**
 * 
 */
package com.zupacademy.casadocodigo.paisEstado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

/**
 * @author marcelo.gomes
 *
 */
@Entity
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@ManyToOne
	@JoinColumn(name = "idPais")
	private Pais pais;
	
	

	/**
	 * 
	 */
	public Estado() {	}

	/**
	 * @param id
	 * @param nome
	 * @param pais
	 */
	public Estado(Long id, @NotBlank(message = "Nome do Estado em branco") String nome, Pais pais) {
		this.id = id;
		this.nome = nome;
		this.pais = pais;
	}

	public Estado(String nome, Pais pais) {
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the pais
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 *
	 * @return EstadoDto
	 */
	public EstadoDto resposta() {
		return new EstadoDto(this.id, this.nome, this.pais);
	}

	/**
	 * Verifica se o estado pertence ao país
	 * testando se o ID do país desse estado é igual
	 * ao id do país recebido no DTO
	 * @param idPais
	 * @return
	 */
	public boolean estadoPertenceAoPais(Long idPais) {
		return this.pais.getId() == idPais;
	}

}
