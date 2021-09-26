/**
 * 
 */
package com.zupacademy.casadocodigo.cliente;

import java.util.Optional;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.zupacademy.casadocodigo.paisEstado.Estado;
import com.zupacademy.casadocodigo.paisEstado.EstadoRepository;
import com.zupacademy.casadocodigo.paisEstado.Pais;
import com.zupacademy.casadocodigo.paisEstado.PaisRepository;
import com.zupacademy.casadocodigo.validator.UniqueValue;

/**
 * @author marcelo.gomes
 *
 */
public class ClienteForm {
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email", message = "Esse email já consta no sistema")
	private String email;
	@NotBlank
	private String telefone;
	@NotBlank
	@CPF
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento", message = "Esse número de documento já consta no sistema")
	private String documento;
	@NotBlank
	@Size(max = 9)
	private String cep;
	@NotBlank
	private String endereco;
	@NotBlank
	@Size(max = 30)
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@ManyToOne
	private Long idPais;
	@ManyToOne
	private Long idEstado;

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
	public ClienteForm(String nome, String sobrenome, String email, String telefone, String documento, String cep,
			String endereco, String complemento, String cidade, Long idPais, Long idEstado) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.documento = documento;
		this.cep = cep;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
	}

	/**
	 * Método para montar o objeto Cliente que será gravado no banco
	 * 
	 * 
	 * @param paisRepository
	 * @param estadoRepository
	 * @return
	 */
	public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		Pais pais = paisRepository.findById(idPais).get();
		Optional<Estado> estadoOpt = estadoRepository.findById(idEstado);
		if(estadoOpt.isPresent()) {
			Estado estado = estadoOpt.get();
			return new Cliente(nome, sobrenome, email, telefone, 
					documento, cep, endereco, complemento, 
					cidade, pais, estado);
			}
		
		return new Cliente(nome, sobrenome, email, telefone, 
				documento, cep, endereco, complemento, 
				cidade, pais);
	}

	
	/**
	 * GTTRS & STTRS
	 */
	String getNome() {
		return nome;
	}

	void setNome(String nome) {
		this.nome = nome;
	}

	String getSobrenome() {
		return sobrenome;
	}

	void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	String getEmail() {
		return email;
	}

	void setEmail(String email) {
		this.email = email;
	}

	String getTelefone() {
		return telefone;
	}

	void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	String getDocumento() {
		return documento;
	}

	void setDocumento(String documento) {
		this.documento = documento;
	}

	String getCep() {
		return cep;
	}

	void setCep(String cep) {
		this.cep = cep;
	}

	String getEndereco() {
		return endereco;
	}

	void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	String getComplemento() {
		return complemento;
	}

	void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	String getCidade() {
		return cidade;
	}

	void setCidade(String cidade) {
		this.cidade = cidade;
	}

	Long getIdPais() {
		return idPais;
	}

	void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	Long getIdEstado() {
		return idEstado;
	}
	
	void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

}
