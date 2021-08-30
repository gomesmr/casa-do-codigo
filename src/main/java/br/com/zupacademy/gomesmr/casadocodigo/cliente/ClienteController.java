/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gomesmr.casadocodigo.paisEstado.EstadoRepository;
import br.com.zupacademy.gomesmr.casadocodigo.paisEstado.PaisRepository;

/**
 * @author marcelo.gomes
 *
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ClienteDto cadastrar(@RequestBody @Valid ClienteForm form) 
		throws Exception{
		Cliente novoCliente = form.toModel(paisRepository, estadoRepository);
		return new ClienteDto(clienteRepository.save(novoCliente));
	}
	
}
