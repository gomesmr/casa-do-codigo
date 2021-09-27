/**
 * 
 */
package com.zupacademy.casadocodigo.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import com.zupacademy.casadocodigo.paisEstado.Estado;
import com.zupacademy.casadocodigo.paisEstado.Pais;

/**
 * @author marcelo.gomes
 *
 */
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	private String email;
	@NotBlank
	private String telefone;
	@NotBlank
	private String documento;
	@NotBlank
	private String cep;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull 
	@ManyToOne
	private Pais pais;
	@ManyToOne
	private Estado estado;

	@Deprecated
	public Cliente() {}

	/**
	 * @param nome
	 * @param sobrenome
	 * @param email
	 * @param telefone
	 * @param documento
	 * @param cep
	 * @param endereco
	 * @param complemento
	 * @param cidade
	 * @param pais
	 * @param estado
	 */
	public Cliente(String nome, String sobrenome, String email, String telefone,
			String documento, String cep, String endereco,
			String complemento, String cidade, Pais pais, Estado estado) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.documento = documento;
		this.cep = cep;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		setEstado(estado);
	}

	Long getId() {
		return id;
	}
	String getNome() {
		return nome;
	}
	String getSobrenome() {
		return sobrenome;
	}
	String getEmail() {
		return email;
	}
	String getTelefone() {
		return telefone;
	}
	String getDocumento() {
		return documento;
	}
	String getCep() {
		return cep;
	}
	String getEndereco() {
		return endereco;
	}
	String getComplemento() {
		return complemento;
	}
	String getCidade() {
		return cidade;
	}
	Pais getPais() {
		return pais;
	}
	Estado getEstado() {
		return estado;
	}
	
    public void setEstado(Estado estado) {
		this.estado = estado;
    }
	
}
