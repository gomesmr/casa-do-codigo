package br.com.zupacademy.gomesmr.casadocodigo.validator;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.gomesmr.casadocodigo.categoria.Categoria;
import br.com.zupacademy.gomesmr.casadocodigo.categoria.CategoriaForm;
import br.com.zupacademy.gomesmr.casadocodigo.categoria.CategoriaRepository;


@Component
public class VerificaCategoriaDuplicadaValidator implements Validator {

	private final CategoriaRepository categoriaRepository;
	
	/**
	 * @param categoriaRepository
	 */
	public VerificaCategoriaDuplicadaValidator(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		CategoriaForm form = (CategoriaForm) target;
		Optional<Categoria> categoria = categoriaRepository.findByNome(form.getNome());
		
		if (categoria.isPresent()) {
			errors.rejectValue("nome", null, "A categoria '"
				+ form.getNome() + "' já existe no sistema");
		}
	}
}
