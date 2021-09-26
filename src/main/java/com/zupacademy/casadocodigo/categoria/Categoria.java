/**
 * 
 */
package com.zupacademy.casadocodigo.categoria;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.zupacademy.casadocodigo.livro.Livro;

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
	@OneToMany
	@JoinColumn(name = "idLivro")
	@JsonIgnore
	private List<Livro> livrosDestaCategoria;

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
		return new CategoriaDto(this.id, this.nome, this.livrosDestaCategoria);
	}
	
	
	

}
