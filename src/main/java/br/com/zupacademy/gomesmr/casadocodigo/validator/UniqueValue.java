package br.com.zupacademy.gomesmr.casadocodigo.validator;

//import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
//import static java.lang.annotation.ElementType.CONSTRUCTOR;
//import static java.lang.annotation.ElementType.METHOD;
//import static java.lang.annotation.ElementType.PARAMETER;
//import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



/**
 * Interface de validação Única
 * O arroba é frescura do Spring
 * @author marcelo.gomes
 *
 */
@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
//@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
	/**
	 * As informações desse bloco são obrigatórias
	 * Mensagem padrão caso a validação dê erro
	 * @return
	 */
    String message() default "Este campo precisa ser único";
    /**
     * Define um grupo específico (quase ninguém usa)
     * Não possui retorno padrão
     * @return
     */
    Class<?>[] groups() default { };
    /**
     * mais informações
     * @return
     */
    Class<? extends Payload>[] payload() default { };

    Class<?> domainClass();
    String fieldName();
	
}
