	/**
 * 
 */
package com.zupacademy.casadocodigo.paisEstado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author marcelo.gomes
 *
 */
@Entity
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	@Deprecated
	public Pais() {	}
	public Pais(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}

}

