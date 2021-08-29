/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


/**
 * @author marcelo.gomes
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ExistIdValidator.class})
public @interface ExistsId {
    String message() default "Não existe registro com esse campo de identificação";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    Class<?> classe();
}
