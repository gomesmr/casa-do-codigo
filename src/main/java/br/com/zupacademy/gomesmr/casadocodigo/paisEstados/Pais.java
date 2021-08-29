/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.paisEstados;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.gomesmr.casadocodigo.categoria.Categoria;
import br.com.zupacademy.gomesmr.casadocodigo.validator.UniqueValue;

/**
 * @author marcelo.gomes
 *
 */
@Entity
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message= "Este País já foi cadastrado.")
	//@NotBlank (message="Nome do País em branco")
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
