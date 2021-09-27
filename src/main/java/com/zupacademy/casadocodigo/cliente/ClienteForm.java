/**
 * 
 */
package com.zupacademy.casadocodigo.cliente;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
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
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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
	 * @param paisRepository
	 * @param estadoRepository
	 * @return
	 * p	e
	 * 0	0	0
	 * 0	1	0
	 * 1	0	0
	 * 1	1	1
	 *
	 * existe pais? Monaco
	 * 		existe estado? sim Ceará
	 * 			Verifica se estado pertence ao pais
	 * 				Se existe -> salva
	 * 				Se não    -> Bad-Request
	 * 		não existe estado
	 * 			Verifica se estado foi informado  -> Bad-Request
	 * 			Se não existe estado -> salva
	 *
	 * 		 * existe pais?
	 * 	   			O país possui estados?
	 * 	 					Sim
	 * 	 						O idEstado está presente?
	 * 	 								Sim
	 * 	 										Este estado pertence a este pais?
	 * 	 												Sim -> Salva
	 *
	 * 	 												Não	-> Bad_request
	 * 	 								Não	-> Bad_request
	 * 	 					Não
	 * 	 						O idEstado está presente?
	 * 	 							Sim -> 	Bad_request
	 * 	 							Não -> Salva
	 *
	 *
	 */

	/**
	 *


	public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		Optional<Pais> paisOpt = paisRepository.findById(idPais);
		if (paisOpt.isPresent()) {
			//existe estado neste país?
			Pais pais = paisOpt.get();

			//Verificar se id é nulo
			if (idEstado != null) {
				//Verifica se estado pertence ao pais
				if ()
				Optional<Estado> estadoOpt = estadoRepository.findById(idEstado);
				if (estadoOpt.isPresent()) {
					Estado estado = estadoOpt.get();
					return new Cliente(nome, sobrenome, email, telefone,
							documento, cep, endereco, complemento,
							cidade, pais, estado);
				}
			}
			return new Cliente(nome, sobrenome, email, telefone,
					documento, cep, endereco, complemento,
					cidade, pais, null);
		}

		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "País inexistente");
	}
	 */
	public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository, EntityManager manager) {
		Optional<Pais> paisOpt = paisRepository.findById(idPais);
		if (paisOpt.isPresent() && paisNaoTemEstados(manager) && idEstado == null) {
			Pais pais = paisOpt.get();
			return new Cliente(nome, sobrenome, email, telefone,
					documento, cep, endereco, complemento,
					cidade, pais, null);

		}
		Optional<Estado> estadoOpt = estadoRepository.findById(idEstado);
		if (estadoOpt.isPresent() && estadoOpt.get().estadoPertenceAoPais(idPais)) {
			Pais pais = paisOpt.get();
			Estado estado = estadoOpt.get();
			return new Cliente(nome, sobrenome, email, telefone,
					documento, cep, endereco, complemento,
					cidade, pais, estado);
		}
		else if (!estadoOpt.isPresent()){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Estado inexistente 0001");
		}
		else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Este país não possui estados");

	}

	@Transactional
	public boolean paisNaoTemEstados(EntityManager manager){
		Query query = manager.createQuery("SELECT e FROM " + Estado.class.getName() + " e WHERE pais_id = :criterio");
		query.setParameter("criterio", idPais);
		List<?> list = query.getResultList();
		if (list.isEmpty()) {
			return true;
		} else {
			return false;
	}
}
//	/**
//	 * GTTRS & STTRS
//	 */
//	String getNome() {
//		return nome;
//	}
//
//	void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	String getSobrenome() {
//		return sobrenome;
//	}
//
//	void setSobrenome(String sobrenome) {
//		this.sobrenome = sobrenome;
//	}
//
//	String getEmail() {
//		return email;
//	}
//
//	void setEmail(String email) {
//		this.email = email;
//	}
//
//	String getTelefone() {
//		return telefone;
//	}
//
//	void setTelefone(String telefone) {
//		this.telefone = telefone;
//	}
//
//	String getDocumento() {
//		return documento;
//	}
//
//	void setDocumento(String documento) {
//		this.documento = documento;
//	}
//
//	String getCep() {
//		return cep;
//	}
//
//	void setCep(String cep) {
//		this.cep = cep;
//	}
//
//	String getEndereco() {
//		return endereco;
//	}
//
//	void setEndereco(String endereco) {
//		this.endereco = endereco;
//	}
//
//	String getComplemento() {
//		return complemento;
//	}
//
//	void setComplemento(String complemento) {
//		this.complemento = complemento;
//	}
//
//	String getCidade() {
//		return cidade;
//	}
//
//	void setCidade(String cidade) {
//		this.cidade = cidade;
//	}
//
//	Long getIdPais() {
//		return idPais;
//	}
//
//	void setIdPais(Long idPais) {
//		this.idPais = idPais;
//	}
//
//	Long getIdEstado() {
//		return idEstado;
//	}
//
//	void setIdEstado(Long idEstado) {
//		this.idEstado = idEstado;
//	}

}
