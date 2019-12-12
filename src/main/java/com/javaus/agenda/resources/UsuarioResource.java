package com.javaus.agenda.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.javaus.agenda.dto.UsuarioDTO;
import com.javaus.agenda.models.Usuario;
import com.javaus.agenda.services.UsuarioService;
import com.javaus.agenda.services.exceptions.RegraNegocioException;

@RestController
@RequestMapping(value="/api/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;
	
	
	/** 
	 * UsuarioDTO dto - Obj Json que sera convertido para Obj Java pela anotation @RequestBody
	 * @Valid - Para que as anotation do bean validation no DTO sejam executadas
	 */
	@PostMapping
	public ResponseEntity salvar(@Valid @RequestBody UsuarioDTO dto){
		
	 try {
			 Usuario obj = usuarioService.converteUsuarioDTOparaUsuario(dto);
			 obj = usuarioService.salvar(obj);
			 URI uri = geraUriDoUsuarioSalvo(obj);
   
		   // Retorna o codigo http = 201 (objeto criado com sucesso) e
		   // envia uri do obj no Headers da requisição
		   return ResponseEntity.created(uri).body(obj);
		
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
	}

	
	
	private URI geraUriDoUsuarioSalvo(Usuario obj) {

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return uri;
	}
}
