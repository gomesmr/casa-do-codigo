/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author marcelo.gomes
 *
 */
@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	/**
	 * 
	 */
	@Deprecated
	public Categoria() {
	}

	/**
	 * @param nome
	 */
	public Categoria(String nome) {
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
	
	public CategoriaDto resposta() {
		return new CategoriaDto(this.id, this.nome);
	}
	
	
	

}
