/**
 * 
 */
package com.zupacademy.casadocodigo.cliente;

import java.util.List;
import java.util.Objects;
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
import org.springframework.util.Assert;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.util.Assert.state;

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


	public Cliente toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, idPais);
		state(Objects.nonNull(pais), "Este país não consta no sistema");
		if (estadosDoPais(manager, pais) && idEstado == null) {
			//Se país não possui estados
			return new Cliente(nome, sobrenome, email, telefone, documento, cep, endereco, complemento, cidade, pais, null);
		}
		//Lista de estados não voltou vazia
		//O estado pertence ao país?
		Estado estado = manager.find(Estado.class, idEstado);
		state(Objects.nonNull(estado), "Este estado não é válido");

		if (estado.estadoPertenceAoPais(idPais)) {
			return new Cliente(nome, sobrenome, email, telefone, documento, cep, endereco, complemento, cidade, pais, estado);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O país " + pais.getNome() + " não possui estados");
}

	private boolean estadosDoPais(EntityManager manager, Pais pais) {
		//A partir do pais, localizar se o pais tem estados
		//Usar JPQL
		Query query = manager.createQuery("SELECT e FROM " + Estado.class.getName() + " e WHERE id_pais = :criteria ");
		query.setParameter("criteria", idPais);
		List<?> list = query.getResultList();
		return list.isEmpty();
	}
}
