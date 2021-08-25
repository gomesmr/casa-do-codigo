package br.com.zupacademy.gomesmr.casadocodigo.validator;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.gomesmr.casadocodigo.autor.Autor;
import br.com.zupacademy.gomesmr.casadocodigo.autor.AutorForm;
import br.com.zupacademy.gomesmr.casadocodigo.autor.AutorRepository;

@Component
public class VerificaEmailDuplicadoValidator implements Validator{
	
	private final AutorRepository autorRepository;

	/**
	 * @param autorRepository
	 */
	public VerificaEmailDuplicadoValidator(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		AutorForm form = (AutorForm) target;
		Optional<Autor> autor = autorRepository.findByEmail(form.getEmail());
		
		if (autor.isPresent()) {
			errors.rejectValue("email", null, "O e-mail "
				+ form.getEmail() + " já existe no sistema");
		}
		
		
	}
	

}
