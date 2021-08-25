package br.com.zupacademy.gomesmr.casadocodigo.autor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gomesmr.casadocodigo.validator.VerificaEmailDuplicadoValidator;

@RestController
@RequestMapping("/autor")
public class AutorController {
	private final AutorRepository autorRepository;
	private final VerificaEmailDuplicadoValidator verificaEmailDuplicadoValidator;

	/**
	 * 
	 * @param autorRepository
	 * @param verificaEmailDuplicadoValidator
	 */
	public AutorController(AutorRepository autorRepository, 
					VerificaEmailDuplicadoValidator verificaEmailDuplicadoValidator) {
		this.autorRepository = autorRepository;
		this.verificaEmailDuplicadoValidator = verificaEmailDuplicadoValidator;
	}
	
	/**
	 * Realiza configurações adicionais na Request deste Controller
	 * @param binder
	 */
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(verificaEmailDuplicadoValidator);
	}

	
	@PostMapping
	private ResponseEntity<AutorDto> cadastrar(@RequestBody @Validated AutorForm autorForm)
			throws Exception{
		Autor autor = autorForm.converter();
		autorRepository.save(autor);
		
		AutorDto autorDto = autor.resposta();
		return ResponseEntity.status(HttpStatus.CREATED).body(autorDto);


    }
		
		
}
	


