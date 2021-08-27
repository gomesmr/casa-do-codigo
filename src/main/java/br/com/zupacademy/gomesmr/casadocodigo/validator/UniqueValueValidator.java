package br.com.zupacademy.gomesmr.casadocodigo.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

/**
 * Indica qual anotation que vamos trbalhar (UniqueValue) e 
 * o tipo do parâmetro que esperamos receber (Object)
 * @author marcelo.gomes
 *
 */
public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {
	
	private String domainAttribute;
	private Class<?> klazz;
	@PersistenceContext
	private EntityManager manager;


	@Override
	public void initialize(UniqueValue uv) {
		domainAttribute = uv.fieldName();
		klazz = uv.domainClass();
	}


	/**
	 * Critério é o valor contido no atributo da classe de domínio
	 */
	@Override
	public boolean isValid(Object criterio, ConstraintValidatorContext contexto) {
		Query query = manager.createQuery("select 1 from "+
					klazz.getName()+" where "+domainAttribute+"=:criterio");
		query.setParameter("criterio", criterio);
		List<?> list = query.getResultList();
		//Lança Illegal State Exception | Nunca pode ter mais que um no sistema
		//Assert.state(list.size() == 0, "Foi encontrado mais de um "+klazz+" com ");
		
		return list.isEmpty();
	}


}
