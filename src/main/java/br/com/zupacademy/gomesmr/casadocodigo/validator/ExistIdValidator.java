package br.com.zupacademy.gomesmr.casadocodigo.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;


public class ExistIdValidator implements ConstraintValidator<ExistsId, Object> {

    @PersistenceContext
    private EntityManager manager;

    private Class<?> classe;

    @Override
    public void initialize(ExistsId constraintAnnotation) {
        classe = constraintAnnotation.classe();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select 1 from "+ classe.getName() +" t where t.id=:value");
        query.setParameter("value", value);
        return query.getResultList().size() > 0;
    }
}
