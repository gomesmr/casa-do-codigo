	/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.paisEstado;

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
	/**
	 * 
	 */
	@Deprecated
	public Pais() {	}
	/**
	 * @param nome
	 */
	public Pais(String nome) {
		this.nome = nome;
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
}

