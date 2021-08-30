/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zupacademy.gomesmr.casadocodigo.paisEstado.Estado;
import br.com.zupacademy.gomesmr.casadocodigo.paisEstado.Pais;

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

	public Cliente(String nome, String sobrenome, String email, String telefone,
			String documento, String cep, String endereco,
			String complemento, String cidade, Pais pais) {
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
	}

	/**
	 * @return the id
	 */
	Long getId() {
		return id;
	}

	/**
	 * @return the nome
	 */
	String getNome() {
		return nome;
	}

	/**
	 * @return the sobrenome
	 */
	String getSobrenome() {
		return sobrenome;
	}

	/**
	 * @return the email
	 */
	String getEmail() {
		return email;
	}

	/**
	 * @return the telefone
	 */
	String getTelefone() {
		return telefone;
	}

	/**
	 * @return the documento
	 */
	String getDocumento() {
		return documento;
	}

	/**
	 * @return the cep
	 */
	String getCep() {
		return cep;
	}

	/**
	 * @return the endereco
	 */
	String getEndereco() {
		return endereco;
	}

	/**
	 * @return the complemento
	 */
	String getComplemento() {
		return complemento;
	}

	/**
	 * @return the cidade
	 */
	String getCidade() {
		return cidade;
	}

	/**
	 * @return the pais
	 */
	Pais getPais() {
		return pais;
	}
	
    /**
	 * @return the estado
	 */
	Estado getEstado() {
		return estado;
	}
	
    public void setEstado(Estado estado) {
        Assert.isTrue(estado.estadoPertenceAoPais(this.pais.getId()),"Este estado não pertence ao pais escolhido");
        this.estado = estado;
    }
	
}
