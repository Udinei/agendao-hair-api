package com.javaus.agenda.controllers.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.javaus.agenda.controllers.resources.dto.UsuarioDTO;
import com.javaus.agenda.models.entity.Usuario;
import com.javaus.agenda.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public  ResponseEntity insert(@RequestBody UsuarioDTO dto){
		
		Usuario obj = usuarioService.converteUsuarioDTOparaUsuario(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
