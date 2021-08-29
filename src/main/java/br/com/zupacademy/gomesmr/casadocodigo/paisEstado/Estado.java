/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.paisEstado;

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

	public EstadoDto resposta() {
		return new EstadoDto(this.id, this.nome, this.pais);
	}

}