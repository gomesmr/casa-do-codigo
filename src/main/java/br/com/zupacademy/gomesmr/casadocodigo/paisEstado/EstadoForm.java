/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.paisEstado;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.gomesmr.casadocodigo.validator.ExistsId;
import br.com.zupacademy.gomesmr.casadocodigo.validator.UniqueValue;

/**
 * @author marcelo.gomes
 *
 */
public class EstadoForm {
	@UniqueValue(domainClass = Estado.class, fieldName = "nome", message = "Este Estado já consta para este País.")
	@NotBlank(message = "Nome do estado em branco")
	private String nome;
	@ExistsId(classe = Pais.class, message = "Pais não cadastrado no sistema")
	private Long idPais;

	/**
	 * @param nome
	 */
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public EstadoForm(String nome, Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	public Estado converter(PaisRepository paisRepository) {
		Pais pais = paisRepository.findById(idPais).get();
		return new Estado(nome, pais);
	}

	/**
	 * @return the nome
	 */
	String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the idPais
	 */
	Long getIdPais() {
		return idPais;
	}

	/**
	 * @param idPais the idPais to set
	 */
	void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

}

